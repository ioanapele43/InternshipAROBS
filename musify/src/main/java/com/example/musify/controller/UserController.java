package com.example.musify.controller;

import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserViewDTO;
import com.example.musify.security.AdminVerify;
import com.example.musify.security.JwtUtils;
import com.example.musify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;

    @GetMapping("/users")
    public List<UserViewDTO> getAllUsers() {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public UserViewDTO getUserById(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public UserViewDTO register(@RequestBody @Valid UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    @PutMapping("/user/update/my_account")
    public UserViewDTO updateMyUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.updateUser(JwtUtils.getCurrentUserId(), userDTO);
    }

    @PutMapping("/user/update/{id}")
    public UserViewDTO updateUser(@PathVariable Integer id, @RequestBody @Valid UserDTO userDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return userService.updateUser(id, userDTO);
    }

    @PutMapping("/user/setActive/{id}")
    public UserViewDTO setUserActive(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return userService.setActive(id);
    }

    @PutMapping("/user/setInactive/{id}")
    public UserViewDTO setUserInactive(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return userService.setInactive(id);
    }

    @PutMapping("/user/inactivate_my_account")
    public UserViewDTO inactivate() {
        return userService.inactivateUser();
    }

    @PutMapping("/user/activate_my_account")
    public UserViewDTO activate() {
        return userService.activateUser();
    }


}
