package com.schoolproject.school.repository;

import com.schoolproject.school.entity.Role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

  Optional<Role> findRoleById(Integer roleId);
}
