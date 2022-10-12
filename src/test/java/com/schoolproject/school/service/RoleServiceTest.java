package com.schoolproject.school.service;

import com.schoolproject.school.entity.Role;
import com.schoolproject.school.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    private Role role;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        role = new Role();
        role.setId(1);
        role.setName("Maestro");
    }

    @Test
    void roleList() {
        when(roleRepository.findAll()).thenReturn(Arrays.asList(role));
        assertNotNull(roleService.roleList());
    }
}