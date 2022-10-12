package com.schoolproject.school.repository;

import com.schoolproject.school.entity.Role;
import com.schoolproject.school.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Test
    public void add() {
        Role role = roleRepository.findById(14).orElse(null);
        User user;
        user = User.builder()
                .name("Amy Denisse")
                .lastName("Ventura")
                .emailAddress("Amy@hotmail.com")
                .role(role)
                .build();

        userRepository.save(user);

    }

}