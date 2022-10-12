package com.schoolproject.school.service;

import com.schoolproject.school.docs.UserDoc;
import com.schoolproject.school.dtos.SaveUserDto;
import com.schoolproject.school.dtos.UpdateUserDto;
import com.schoolproject.school.entity.Role;
import com.schoolproject.school.entity.User;
import com.schoolproject.school.repository.RoleRepository;
import com.schoolproject.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public List<UserDoc> find() {
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

    public UserDoc add(SaveUserDto userDto) {
        Role role = roleRepository.findById(userDto.getRoleId()).orElse(null);
        if(role == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found");
        }

        User user = userRepository.findUserByEmailAddress(userDto.getEmailAddress()).orElse(null);
        if(user != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The email already exists");
        }

        User data = User.builder()
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .emailAddress(userDto.getEmailAddress())
                .role(role)
                .build();
        userRepository.save(data);

        return UserDoc.builder()
                .userId(data.getId())
                .name(data.getName())
                .lastName(data.getLastName())
                .emailAddress(data.getEmailAddress())
                .roleId(data.getRole().getId())
                .role(data.getRole().getName())
                .build();
    }

    public UserDoc findById(Integer userId){
        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        return UserDoc.builder()
                .userId(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .role(user.getRole().getName())
                .roleId(user.getRole().getId())
                .emailAddress(user.getEmailAddress())
                .build();
    }

    public UserDoc update(int userId, UpdateUserDto userDto){
        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        if(!userDto.getEmailAddress().equals(user.getEmailAddress())){
            User userResult = userRepository.findUserByEmailAddress(userDto.getEmailAddress()).orElse(null);
            if(userResult != null){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "The email already exists");
            }
        }

        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmailAddress(userDto.getEmailAddress());
        userRepository.save(user);

        return UserDoc.builder()
                .userId(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .emailAddress(user.getEmailAddress())
                .role(user.getRole().getName())
                .roleId(user.getRole().getId())
                .build();
    }
}
