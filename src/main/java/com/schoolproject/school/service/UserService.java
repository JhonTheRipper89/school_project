package com.schoolproject.school.service;

import com.schoolproject.school.entity.User;
import com.schoolproject.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    User user;
    public List<User> show() {
        return userRepository.findAll();
    }

    public void add(@RequestBody User user) {
        User data = User.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .emailAddress(user.getEmailAddress())
                .role(user.getRole())
                .build();
        userRepository.save(data);
    }

    public void delete(int userId) {
        boolean exist = userRepository.existsById(userId);
        if (!exist) {
            throw new IllegalStateException(
                    "ERROR BY ID " + userId + "DOESN'T ID WHIT USER"
            );
        }
        userRepository.deleteById(userId);
    }
}
