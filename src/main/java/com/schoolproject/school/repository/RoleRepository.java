package com.schoolproject.school.repository;

import com.schoolproject.school.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
