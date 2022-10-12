package com.schoolproject.school.service;

import com.schoolproject.school.docs.UserDoc;
import com.schoolproject.school.dtos.UserDto;
import com.schoolproject.school.entity.*;
import com.schoolproject.school.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public List<UserDoc> allUsers() {
        List<User> users = userRepository.findAll();
        List<UserDoc> userDocs = new ArrayList<>();

        for(User us: users){
            userDocs.add(
                    UserDoc.builder()
                            .userId(us.getId())
                            .name(us.getName())
                            .lastName(us.getLastName())
                            .emailAddress(us.getEmailAddress())
                            .roleId(us.getRole().getId())
                            .role(us.getRole().getName())
                            .build());
        }
        return userDocs;
    }

    public UserDoc getById(int userId) {
        User user = userRepository.findUserById(userId).orElse(null);
        if (user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

        return UserDoc.builder()
                .userId(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .role(user.getRole().getName())
                .roleId(user.getRole().getId())
                .emailAddress(user.getEmailAddress())
                .build();
    }

    public ResponseEntity<UserDoc> createUser(UserDto userDto) {
        Role role = roleRepository.findRoleById(userDto.getRoleId()).orElse(null);
        if (role == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol not found");

        User user = userRepository.findUserByEmailAddress(userDto.getEmailAddress()).orElse(null);
        if (user != null)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The email already exists");

        User data = User.builder()
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .emailAddress(userDto.getEmailAddress())
                .role(role)
                .build();
        userRepository.save(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }




        public ResponseEntity<UserDoc> updateUser(int userId, UserDto userDto) {
            User user = userRepository.findUserById(userId).orElse(null);
            if (user == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

        if(!userDto.getEmailAddress().equals(user.getEmailAddress())){
            User userResult = userRepository.findUserByEmailAddress(userDto.getEmailAddress()).orElse(null);
            if (userResult != null)
                throw new ResponseStatusException(HttpStatus.CONFLICT, "The email already exists");
        }
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public boolean login(UserDto userDto) {
        User user = userRepository.findUserByEmailAddress(userDto.getEmailAddress()).orElse(null);
        if (!userDto.getEmailAddress().equals(user.getEmailAddress())) return false;
        if (!userDto.getPassword().equals(user.getPassword())) return false;
        return true;
    }

    public ResponseEntity<UserDoc> deleteUser(int userId) {
        User user = userRepository.findUserById(userId).orElse(null);
        if (user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
