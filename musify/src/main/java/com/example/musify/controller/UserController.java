package com.example.musify.controller;

import com.example.musify.model.User;
import com.example.musify.repo.UserRepository;
import com.example.musify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    private UserRepository userRepository;
   /* @GetMapping
    public String helloSpring(@RequestParam String id){
        System.out.println("id : "+id);
        return userService.getMessage();
    }*/
   @GetMapping("/u")
   public String helloSpring(){

       return userService.getMessage();
   }
   @GetMapping("/user")
    public String getUserFromURL(@RequestParam String firstName,@RequestParam String lastName){
       System.out.println(" first name: "+firstName+" and last name: "+lastName);
       return " first name: "+firstName+" <br> and<br> last name: "+lastName+" ";

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
