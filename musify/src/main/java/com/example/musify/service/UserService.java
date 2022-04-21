package com.example.musify.service;

import com.example.musify.dto.UserDTO;
import com.example.musify.exception.UnauthorizedException;
import com.example.musify.model.User;
import com.example.musify.repo.UserRepositoryJPA;
import com.example.musify.security.JwtUtils;
import com.example.musify.service.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserRepositoryJPA userRepositoryJPA;
    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userRepositoryJPA.findAll();
    }

    public User getUserById(Integer id) {
        return userRepositoryJPA.getUserById(id);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepositoryJPA.findByEmailAndPassword(email, password);
    }

    @Transactional
    public void register(UserDTO userDTO) {
        byte[] bytes = userDTO.getPassword().getBytes();
        String encoded = String.valueOf(Hex.encode(bytes));
        userDTO.setPassword(encoded);
        userRepositoryJPA.save(userMapper.toEntity(userDTO));
    }

    @Transactional
    public void updateUser(UserDTO userDTO) {
        userRepositoryJPA.save(userMapper.toEntity(userDTO));
    }

    @Transactional
    public void setInactive(Integer id) {
        User user = getUserById(id);
        user.setStatus("inactive");
    }

    @Transactional
    public void setActive(Integer id) {
        User user = getUserById(id);
        user.setStatus("active");
    }

    public String login(String email, String password) {
        User user = null;
        if (userRepositoryJPA.getUserByEmail(email) != null) {
            user = userRepositoryJPA.getUserByEmail(email);
        }
        byte[] bytes = password.getBytes();
        String encoded = String.valueOf(Hex.encode(bytes));
        if (user == null || !encoded.equals(user.getPassword()) || user.getStatus().equals("inactive")) {
            throw new UnauthorizedException("Email or password invalid");
        }
        return JwtUtils.generateToken(user.getId(), user.getEmail(), user.getRole());
    }

    public void logout(String token) {
        JwtUtils.invalidateToken(token);
    }

    public String justAdmin() {
        String role = JwtUtils.getCurrentUserRole();
        if (role.equals("admin")) {
            return "Welcome admin";
        } else {
            throw new UnauthorizedException("you're not admin");
        }
    }

    public void inactivateUser() {
        Integer id = JwtUtils.getCurrentUserId();
        User user = userRepositoryJPA.getUserById(id);
        user.setStatus("inactive");
        userRepositoryJPA.save(user);
    }

    public void activateUser() {
        Integer id = JwtUtils.getCurrentUserId();
        User user = userRepositoryJPA.getUserById(id);
        user.setStatus("active");
        userRepositoryJPA.save(user);

    }
    //inactive an account
    //activate an account

}
