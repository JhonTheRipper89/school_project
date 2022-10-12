package com.schoolproject.school.repository;

import com.schoolproject.school.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmailAddress(String email);
    Optional<User> findUserById(int userId);
    Optional<User> findUserByPassword(String password);
}
