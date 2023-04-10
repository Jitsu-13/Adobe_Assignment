package com.adobe.social_media.controller;

import com.adobe.social_media.model.User;
import com.adobe.social_media.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User createdUser=userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
        User user=userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id,@Valid @RequestBody User user){
        User updatedUser=userService.updateUser(id,user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/analytics/users")
    public ResponseEntity<Integer> getTotalUsers() {
        Integer totalUsers = userService.getTotalUsers();
        return new ResponseEntity<>(totalUsers, HttpStatus.OK);
    }
    @GetMapping("/analytics/users/top-active")
    public ResponseEntity<List<User>> getTopActiveUsers() {
        List<User> topActiveUsers = userService.getTopActiveUsers();
        return new ResponseEntity<>(topActiveUsers, HttpStatus.OK);
    }

}
