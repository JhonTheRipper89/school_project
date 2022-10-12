package com.schoolproject.school.service;

import com.schoolproject.school.entity.Role;
import com.schoolproject.school.entity.User;
import com.schoolproject.school.repository.RoleRepository;
import com.schoolproject.school.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        Role role = roleRepository.findById(14).orElse(null);
        user = User.builder()
                .name("Amy Denisse")
                .lastName("Ventura")
                .emailAddress("Amy@hotmail.com")
                .role(role)
                .build();
    }
    @Test
    void show() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        assertNotNull(userService.show());
    }
}