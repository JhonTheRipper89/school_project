package com.schoolproject.school.controller;

import com.schoolproject.school.entity.User;
import com.schoolproject.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> get(){
        return userService.show();
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.add(user);
    }

    @DeleteMapping(path = "userId")
    public void deleteUser(@PathVariable int userId){
        userService.delete(userId);
    }
}
