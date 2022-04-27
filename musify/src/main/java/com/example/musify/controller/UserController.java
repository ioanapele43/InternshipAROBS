package com.example.musify.controller;

import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserViewDTO;
import com.example.musify.security.AdminVerify;
import com.example.musify.security.JwtUtils;
import com.example.musify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserViewDTO>> getAllUsers() {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        List<UserViewDTO> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        UserViewDTO user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/register")
    public String register(@RequestBody @Valid UserDTO userDTO) {
        userService.register(userDTO);
        return "Success!";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        String token = userService.login(email, password);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
    @PutMapping("/user/update/my_account")
    public String updateMyUser(@PathVariable Integer id,@RequestBody @Valid UserDTO userDTO) {
        userService.updateUser(JwtUtils.getCurrentUserId(),userDTO);
        return "updated with success!";
    }
    @PutMapping("/user/update/{id}")
    public String updateUser(@PathVariable Integer id,@RequestBody @Valid UserDTO userDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        userService.updateUser(id,userDTO);
        return "updated with success!";
    }

    @PutMapping("/user/setActive/{id}")
    public String setUserActive(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        userService.setActive(id);
        return "success!";
    }

    @PutMapping("/user/setInactive/{id}")
    public String setUserInactive(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        userService.setInactive(id);
        return "success!";
    }

    @PutMapping("/user/inactivate_my_account")
    public String inactivate() {
        userService.inactivateUser();
        return "success!";
    }

    @PutMapping("/user/activate_my_account")
    public String activate() {
        userService.activateUser();
        return "success!";
    }


}
