package com.example.musify.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
@Component
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    @Autowired
    private JwtUtils jwtUtils;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX) || jwtUtils.isBlackListed(header)) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(header);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    // Reads the JWT from the Authorization header, and then uses JWT to validate the token
    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        if (token != null) {
            token = token.replaceAll(TOKEN_PREFIX, "").trim();

            Map<String, Object> userInfo = jwtUtils.validateToken(token);

            String id = String.valueOf(userInfo.get("id"));
            String email = (String) userInfo.get("email");
            String role = (String) userInfo.get("role");

            if (id != null && email != null && role != null) {
                // new arraylist means authorities
                return new UsernamePasswordAuthenticationToken(userInfo, null, new ArrayList<>());
            }

            return null;
        }

        return null;
    }
}
