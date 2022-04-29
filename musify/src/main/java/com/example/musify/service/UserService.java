package com.example.musify.service;

import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserUpdateDTO;
import com.example.musify.dto.UserViewDTO;
import com.example.musify.exception.UnauthorizedException;
import com.example.musify.model.User;
import com.example.musify.repo.UserRepositoryJPA;
import com.example.musify.security.JwtUtils;
import com.example.musify.service.mappers.UserMapper;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepositoryJPA userRepositoryJPA;
    private final UserMapper userMapper;
    private final ValidationsService validationsService;

    public UserService(UserRepositoryJPA userRepositoryJPA, UserMapper userMapper, ValidationsService validationsService) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.userMapper = userMapper;
        this.validationsService = validationsService;
    }

    public List<UserViewDTO> getUsers() {
        return userRepositoryJPA.findAll().stream().map(u -> userMapper.toViewDto(u)).collect(Collectors.toList());
    }

    public UserViewDTO getUserById(Integer id) {
        validationsService.checkIfAUserExists(id);
        return userMapper.toViewDto(userRepositoryJPA.getUserById(id));
    }

    public UserViewDTO getUserByEmailAndPassword(String email, String password) {
        return userMapper.toViewDto(userRepositoryJPA.findByEmailAndPassword(email, password));
    }

    @Transactional
    public void register(UserDTO userDTO) {
        byte[] bytes = userDTO.getPassword().getBytes();
        String encoded = String.valueOf(Hex.encode(bytes));
        userDTO.setPassword(encoded);
        User user=userMapper.toEntity(userDTO);
        user.setStatus("active");
        if(user.getEmail().endsWith("@arobs.com"))
            user.setRole("admin");
        else
            user.setRole("user");
        userRepositoryJPA.save(user);
    }

    @Transactional
    public void updateUser(Integer id, UserUpdateDTO userDTO) {
        validationsService.checkIfAUserExists(id);
        User user=userRepositoryJPA.getUserById(id);
        if(!userDTO.getFirstName().equals(""))
            user.setFirstName(userDTO.getFirstName());
        if(!userDTO.getLastName().equals(""))
            user.setLastName(userDTO.getLastName());
        if(!userDTO.getCountry().equals(""))
            user.setCountry(userDTO.getCountry());
        if(!userDTO.getStatus().equals(""))
            user.setStatus(userDTO.getStatus());
        if(!userDTO.getRole().equals("") )
            if(JwtUtils.getCurrentUserRole().equals("admin"))
                user.setRole(userDTO.getRole());
            else
                throw new UnauthorizedException("you can't change your role");
        if(!userDTO.getPassword().equals("")){
            byte[] bytes = userDTO.getPassword().getBytes();
            String encoded = String.valueOf(Hex.encode(bytes));
            user.setPassword(encoded);
        }
        userRepositoryJPA.save(user);
    }

    @Transactional
    public void setInactive(Integer id) {
        validationsService.checkIfAUserExists(id);
        User user = userRepositoryJPA.getUserById(id);
        user.setStatus("inactive");
    }

    @Transactional
    public void setActive(Integer id) {
        validationsService.checkIfAUserExists(id);
        User user = userRepositoryJPA.getUserById(id);
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


}
