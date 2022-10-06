package com.schoolproject.school.controller;

import com.schoolproject.school.entity.User;
import com.schoolproject.school.items.UserItem;
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
    public void addUser(@RequestBody UserItem user){
        System.out.println("AQUIIIIII");
        userService.add(user);
    }

    @DeleteMapping(path = "userId")
    public void deleteUser(@PathVariable Long userId){
        userService.delete(userId);
    }
}
