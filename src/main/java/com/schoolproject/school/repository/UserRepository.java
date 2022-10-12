package com.schoolproject.school.repository;

import com.schoolproject.school.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmailAddress(String email);

    @Query(value = "SELECT * FROM tbl_user u LEFT JOIN tbl_role r ON r.role_id = u.role_id WHERE  r.name= ?1", nativeQuery = true)
    List<User> findAllByRole(String role);
}
