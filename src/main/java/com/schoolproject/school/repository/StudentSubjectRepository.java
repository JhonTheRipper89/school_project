package com.schoolproject.school.repository;

import com.schoolproject.school.entity.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {
}
