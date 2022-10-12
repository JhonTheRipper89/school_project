package com.schoolproject.school.repository;

import com.schoolproject.school.entity.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {
    @Modifying
    @Query(value = "DELETE FROM tbl_student_subject WHERE user_id = ?1", nativeQuery = true)
    int deleteAllByStudentId(int studentId);
}
