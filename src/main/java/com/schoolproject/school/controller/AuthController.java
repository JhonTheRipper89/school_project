package com.schoolproject.school.controller;

import com.schoolproject.school.dtos.UserDto;
import com.schoolproject.school.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/auth/login")
public class AuthController {
  @Autowired
    AuthService userService;

  @PostMapping
  public ResponseEntity<Boolean> Login(@RequestBody UserDto user){
    return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
  }
}
