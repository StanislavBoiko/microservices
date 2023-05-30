package com.example.userservice.controllers;


import com.example.userservice.entities.User;
import com.example.userservice.services.UserService;
import com.example.userservice.services.UserServiceImpl;
import org.apache.coyote.Response;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("user")
    public ResponseEntity createUser(@RequestBody JSONObject jsonReq){
        var user = new User();
        user.setName(jsonReq.getAsString("Name"));
        user.setSurname(jsonReq.getAsString("Surname"));
        user.setAddress(jsonReq.getAsString("Address"));
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("user")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("user/{userId}")
    public ResponseEntity getUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }
}
