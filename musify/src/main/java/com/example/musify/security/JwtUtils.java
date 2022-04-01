package com.example.musify.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
@Component
public class JwtUtils {
    private final Logger log= LoggerFactory.getLogger(JwtUtils.class);
    private static final String issuer="musify";
    @Value("${jwt.secret:INTERNAROBS}")
    private String signatureSecret ;
    private static List<String> blacklistTokens=new ArrayList<String>();

    @PostConstruct
    public void init(){
        log.info("Secret: {}",signatureSecret);
    }

    public String generateToken(int id, String email, String role) {
        Algorithm algorithm = Algorithm.HMAC256(signatureSecret);

        Calendar c = Calendar.getInstance();
        Date currentDate = c.getTime();

        c.add(Calendar.HOUR, 24);
        Date expireDate = c.getTime();

        return JWT.create()
                .withIssuer(issuer)
                .withSubject(issuer)
                .withIssuedAt(currentDate)
                .withExpiresAt(expireDate)
                .withClaim("id", id)
                .withClaim("email", email)
                .withClaim("role", role)
                .sign(algorithm);
    }

    public Map<String, Object> validateToken(String jwtToken) {
        Algorithm algorithm = Algorithm.HMAC256(signatureSecret);

        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .withSubject(issuer)
                .build();

        DecodedJWT decodedJWT = verifier.verify(jwtToken);
        Integer id = decodedJWT.getClaim("id").asInt();
        String email = decodedJWT.getClaim("email").asString();
        String role = decodedJWT.getClaim("role").asString();

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", id);
        userInfo.put("email", email);
        userInfo.put("role", role);

        return userInfo;
    }
    public  void invalidateToken(String jwtToken){
        //add to blacklist
        blacklistTokens.add(jwtToken);
    }
    public boolean isBlackListed(String token){
        return blacklistTokens.contains(token);
    }
    public Integer getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Map) {
            return (Integer) ((Map<String, Object>) principal).get("id");
        }

        throw new RuntimeException("Something went wrong!");
    }

    public  String getCurrentUserEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Map) {
            return (String) ((Map<String, Object>) principal).get("email");
        }

        throw new RuntimeException("Something went wrong!");
    }

    public String getCurrentUserRole() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Map) {
            return (String) ((Map<String, Object>) principal).get("role");
        }

        throw new RuntimeException("Something went wrong!");
    }
}
