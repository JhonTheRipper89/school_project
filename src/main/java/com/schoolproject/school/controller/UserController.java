package com.schoolproject.school.controller;

import com.schoolproject.school.docs.UserDoc;
import com.schoolproject.school.dtos.UserDto;
import com.schoolproject.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDoc>> get(){
        return new ResponseEntity<>(userService.allUsers(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UserDoc> post(@RequestBody UserDto user){
        return userService.createUser(user);
    }


    @GetMapping( path = "/{userId}")
    public ResponseEntity<UserDoc> getByUserId(@PathVariable int userId){
        return new ResponseEntity<>(userService.getById(userId), HttpStatus.OK);
    }


    @PatchMapping( path = "/{userId}")
    public ResponseEntity<UserDoc> put(@PathVariable int userId, @RequestBody UserDto userDto){
        return userService.updateUser(userId, userDto);
    }

    @DeleteMapping( path = "/{userId}")
    public ResponseEntity<UserDoc> delete(@PathVariable int userId){
        return userService.deleteUser(userId);
    }
}
