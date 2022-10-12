package com.schoolproject.school.repository;

import com.schoolproject.school.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
