package com.example.musify.controller;

import com.example.musify.model.User;
import com.example.musify.repo.UserRepository;
import com.example.musify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserRepository userRepository;

    /* @GetMapping
     public String helloSpring(@RequestParam String id){
         System.out.println("id : "+id);
         return userService.getMessage();
     }*/
    @GetMapping("/u")
    public String helloSpring() {

        return userService.getMessage();
    }

    @GetMapping("/user")
    public String getUserFromURL(@RequestParam String firstName, @RequestParam String lastName) {
        System.out.println(" first name: " + firstName + " and last name: " + lastName);
        return " first name: " + firstName + " <br> and<br> last name: " + lastName + " ";

    }

    @GetMapping("/allusers")
    public String getAllUsers() {
        userRepository = new UserRepository(dataSource);
        List<User> users = userRepository.getALlUSers();
        AtomicReference<String> s = new AtomicReference<>("");
        users.forEach(u -> {
            System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole());
            s.set(s + u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole() + "<br>");
        });
        return s.get();
    }

    @GetMapping("/getuser")
    public String getUserById(@RequestParam int id) {
        userRepository = new UserRepository(dataSource);
        List<User> users = userRepository.getUserById(id);
       // User u=userRepository.getUserById(id);
        AtomicReference<String> s = new AtomicReference<>("");
        users.forEach(u -> {
            System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole());
            s.set(s + u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole() + "<br>");
        });
        return s.get();
    }

    @GetMapping("/insertUser")
    public String insertUser(@RequestParam int id, @RequestParam String firstname,@RequestParam String lastname, @RequestParam String email, @RequestParam String password, @RequestParam String country, @RequestParam String role) {
        userRepository = new UserRepository(dataSource);
        try {
            userRepository.insertUser(new User(id,firstname, lastname, email, password, country, role));
        } catch (Exception e) {
            System.out.println("exista deja");
        }
        List<User> users = userRepository.getALlUSers();
        AtomicReference<String> s = new AtomicReference<>("");
        users.forEach(u -> {
            System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole());
            s.set(s + u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole() + "<br>");
        });
        return s.get();
        //localhost:8080/insertUser?firstname=bb&lastname=bb&email=bb&password=1234&country=romania&role=regular
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam int id,@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String password, @RequestParam String country, @RequestParam String role) {
        userRepository = new UserRepository(dataSource);
        try {
            userRepository.updateUser(new User(id,firstname, lastname, email, password, country, role));
        } catch (Exception e) {
        }
        List<User> users = userRepository.getALlUSers();
        AtomicReference<String> s = new AtomicReference<>("");
        users.forEach(u -> {
            System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole());
            s.set(s + u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole() + "<br>");
        });
        return s.get();
        //localhost:8080/updateUser?firstname=bb&lastname=bb&email=bb&password=1234&country=romania&role=regular
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam int id,@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String password, @RequestParam String country, @RequestParam String role) {
        userRepository = new UserRepository(dataSource);
        try {
            userRepository.deleteUser(new User(id,firstname, lastname, email, password, country, role));
        } catch (Exception e) {
        }
        List<User> users = userRepository.getALlUSers();
        AtomicReference<String> s = new AtomicReference<>("");
        users.forEach(u -> {
            System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole());
            s.set(s + u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole() + "<br>");
        });
        return s.get();
        //localhost:8080/deleteUser?firstname=bb&lastname=bb&email=bb&password=1234&country=romania&role=regular
    }
   /* @PostMapping
    public String post(@RequestBody User user){
        System.out.println("");
        return "";
    }

    PATH PARAMS_url/1
    QUERY PARAMS_url?name=Vlad
    BODY PARAMS(POST/PUT)
*/
   /*
   @GetMapping("{id}")
    public String helloSpring(Integer id){
        System.out.println("id : "+id);
        return userService.getMessage();
    }
   @GetMapping("/hello-spring")
    public String helloSpring(){
        return "hello spring";
    }
    */
}
