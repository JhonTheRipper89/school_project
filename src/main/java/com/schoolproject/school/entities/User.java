package com.schoolproject.school.entities;

import lombok.*;
import javax.persistence.*;
<<<<<<<< HEAD:src/main/java/com/schoolproject/school/entities/Student.java
import java.io.Serializable;
import java.util.*;
========
import java.util.List;
>>>>>>>> a514e515c66af9b305d34ec63d5085e4d13f8115:src/main/java/com/schoolproject/school/entities/User.java

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_user",
        uniqueConstraints = @UniqueConstraint(
                name = "emailaddess_unique",
                columnNames = "email_address"
        )
)
<<<<<<<< HEAD:src/main/java/com/schoolproject/school/entities/Student.java
public class Student implements Serializable {
========
public class User {
>>>>>>>> a514e515c66af9b305d34ec63d5085e4d13f8115:src/main/java/com/schoolproject/school/entities/User.java
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailAddress;

<<<<<<<< HEAD:src/main/java/com/schoolproject/school/entities/Student.java
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
========
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<StudentSubject> studentSubject;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;
>>>>>>>> a514e515c66af9b305d34ec63d5085e4d13f8115:src/main/java/com/schoolproject/school/entities/User.java
}
