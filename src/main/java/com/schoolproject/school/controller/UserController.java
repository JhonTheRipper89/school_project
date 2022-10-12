package com.schoolproject.school.controller;

import com.schoolproject.school.docs.UserDoc;
import com.schoolproject.school.dtos.SaveUserDto;
import com.schoolproject.school.dtos.UpdateUserDto;
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
        return new ResponseEntity<>(userService.find(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDoc> addUser(@RequestBody SaveUserDto user){
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }

    @GetMapping( path = "/{userId}")
    public ResponseEntity<UserDoc> findById(@PathVariable int userId){
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.FOUND);
    }

    @PatchMapping( path = "/{userId}")
    public ResponseEntity<UserDoc> update(@PathVariable int userId, @RequestBody UpdateUserDto userDto){
        return new ResponseEntity<>(userService.update(userId, userDto), HttpStatus.ACCEPTED);
    }
}
