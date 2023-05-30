package com.example.userservice.controllers;


import com.example.userservice.entities.User;
import com.example.userservice.services.UserService;
import com.example.userservice.services.UserServiceImpl;
import org.apache.coyote.Response;
import net.minidev.json.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AmqpTemplate template;

    private boolean statusOk = true;

    @PostMapping("user")
    public ResponseEntity createUser(@RequestBody JSONObject jsonReq){
        var user = new User();
        user.setName(jsonReq.getAsString("Name"));
        user.setSurname(jsonReq.getAsString("Surname"));
        user.setAddress(jsonReq.getAsString("Address"));
        userService.addUser(user);
        template.convertAndSend("user-queue", "User: " +
                user.getName() + user.getSurname() +" was added");
        return ResponseEntity.ok().build();
    }

    @GetMapping("user")
    public ResponseEntity getAllUsers() throws InterruptedException {
        
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("user/{userId}")
    public ResponseEntity getUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping("user/bad")
    public void bad(){
        statusOk = false;
    }

    @GetMapping("user/repair")
    public void repair(){
        statusOk = true;
    }

    @GetMapping("user/ids")
    public List<Long> getAllIds() throws InterruptedException {
	    if(!statusOk)
        {
            Thread.sleep(10000);
        }
        return userService.getAllIds();
    }
}
