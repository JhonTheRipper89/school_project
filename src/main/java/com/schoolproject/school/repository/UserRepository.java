package com.schoolproject.school.repository;

import com.schoolproject.school.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
