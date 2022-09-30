package com.schoolproject.school.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private List<StudentSubject> studentSubjects;
}
