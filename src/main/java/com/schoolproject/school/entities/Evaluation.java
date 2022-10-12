package com.schoolproject.school.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_evaluation")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_id")
    private Integer id;
    private Double score;
    private Date timeStamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_subject_id")
    private StudentSubject studentSubject;
}
