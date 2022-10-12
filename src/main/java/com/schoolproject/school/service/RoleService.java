package com.schoolproject.school.service;

import com.schoolproject.school.entity.Role;
import com.schoolproject.school.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<Role> roleList (){
        return roleRepository.findAll();
    }
}
