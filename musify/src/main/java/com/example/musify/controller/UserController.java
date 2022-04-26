package com.example.musify.controller;

import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserViewDTO;
import com.example.musify.model.User;
import com.example.musify.repo.UserRepositoryJPA;
import com.example.musify.security.AdminVerification;
import com.example.musify.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Hex;
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
        AdminVerification.checkIfTheUserLoggedIsAdmin();
        List<UserViewDTO> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Integer id) {
        AdminVerification.checkIfTheUserLoggedIsAdmin();
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

    @PutMapping("/user/update")
    public String updateUser(@RequestBody @Valid UserDTO userDTO) {
        userService.updateUser(userDTO);
        return "updated with success!";
    }

    @PutMapping("/user/setActive/{id}")
    public String setUserActive(@PathVariable Integer id) {
        AdminVerification.checkIfTheUserLoggedIsAdmin();
        userService.setActive(id);
        return "success!";
    }

    @PutMapping("/user/setInactive/{id}")
    public String setUserInactive(@PathVariable Integer id) {
        userService.setInactive(id);
        return "success!";
    }

    @PutMapping("/user/inactivate_account")
    public String inactivate() {
        userService.inactivateUser();
        return "success!";
    }

    @PutMapping("/user/activate_account")
    public String activate() {
        userService.activateUser();
        return "success!";
    }


}
