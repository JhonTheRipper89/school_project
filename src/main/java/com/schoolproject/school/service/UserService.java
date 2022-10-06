package com.schoolproject.school.service;

import com.schoolproject.school.entity.Role;
import com.schoolproject.school.entity.User;
import com.schoolproject.school.items.UserItem;
import com.schoolproject.school.repository.RoleRepository;
import com.schoolproject.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    RoleRepository roleRepository;

    public List<User> show() {
        return userRepository.findAll();
    }

    public void add(@RequestBody UserItem userItem) {
        Long roleId = userItem.getRoleId();
        Role role = roleRepository.getReferenceById(roleId);
        User user = new User();
        user.setName(userItem.getName());
        user.setLastName(userItem.getLastName());
        user.setEmailAddress(userItem.getEmailAddress());
        user.setRole(role);
        userRepository.save(user);
    }

    public void delete(Long userId) {
        boolean exist = userRepository.existsById(userId);
        if (!exist) {
            throw new IllegalStateException(
                    "ERROR BY ID " + userId + "DOESN'T ID WHIT USER"
            );
        }
        userRepository.deleteById(userId);
    }
}
