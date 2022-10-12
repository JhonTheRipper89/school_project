package com.schoolproject.school.controller;

import com.schoolproject.school.entity.Role;
import com.schoolproject.school.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping
    public List<Role> roleList(){
        return roleService.roleList();
    }
}
