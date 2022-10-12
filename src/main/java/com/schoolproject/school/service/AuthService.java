package com.schoolproject.school.service;

import com.schoolproject.school.dtos.UserDto;
import com.schoolproject.school.entity.*;
import com.schoolproject.school.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public boolean login(UserDto userDto) {
        User user = userRepository.findUserByEmailAddress(userDto.getEmailAddress()).orElse(null);
        if (!userDto.getEmailAddress().equals(user.getEmailAddress())) return false;
        if (!userDto.getPassword().equals(user.getPassword())) return false;
        return true;
    }

}
