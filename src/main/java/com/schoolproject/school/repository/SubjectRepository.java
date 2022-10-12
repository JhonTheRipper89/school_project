package com.schoolproject.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolproject.school.entities.Subject;

import java.io.Serializable;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Serializable> {
}
