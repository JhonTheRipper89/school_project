package com.schoolproject.school.repository;

import com.schoolproject.school.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {
}
