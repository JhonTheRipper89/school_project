package com.schoolproject.school.repository;

import com.schoolproject.school.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;
    @Test
    public void add(){
        Role role;
        role= Role.builder()
                .name("Professor")
                .build();
        roleRepository.save(role);
    }
}