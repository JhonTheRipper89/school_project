package com.schoolproject.school.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailaddess_unique",
                columnNames = "email_address"
        )
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailAddress;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_student_subject",
            joinColumns = {
                    @JoinColumn(name = "student_fk", referencedColumnName = "student_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "subject_fk", referencedColumnName = "subject_id")
            }
    )
    private List<Subject> subjectList;
}
