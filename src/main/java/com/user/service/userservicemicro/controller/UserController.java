package com.user.service.userservicemicro.controller;

import com.user.service.userservicemicro.request.UserRequest;
import com.user.service.userservicemicro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserRequest> saveUser(@RequestBody UserRequest userRequest) {
        UserRequest userRequest1 = this.userService.saveUser(userRequest);
        return new ResponseEntity<UserRequest>(userRequest1,HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserRequest>> getAllUser() {
        List<UserRequest> userRequest = this.userService.getAllUser();
        return new ResponseEntity<List<UserRequest>>(userRequest, HttpStatus.FOUND);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<UserRequest> getUser(@PathVariable("userId") Long userId) {
        UserRequest userRequest = this.userService.getUser(userId);
        return new ResponseEntity<UserRequest>(userRequest, HttpStatus.FOUND);
    }

}
