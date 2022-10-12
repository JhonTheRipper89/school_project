package com.schoolproject.school.service;

import com.schoolproject.school.docs.StudentDoc;
import com.schoolproject.school.docs.StudentSubjectDoc;
import com.schoolproject.school.entity.Evaluation;
import com.schoolproject.school.entity.StudentSubject;
import com.schoolproject.school.entity.Subject;
import com.schoolproject.school.entity.User;
import com.schoolproject.school.repository.StudentSubjectRepository;
import com.schoolproject.school.repository.SubjectRepository;
import com.schoolproject.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentSubjectRepository studentSubjectRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public List<StudentDoc> find(){
        List<User> students = userRepository.findAllByRole("Student");
        List<StudentDoc> studentDocs = new ArrayList<>();

        for(User u: students){
            studentDocs.add(
                    StudentDoc.builder()
                            .studentId(u.getId())
                            .name(u.getName())
                            .lastName(u.getLastName())
                            .role(u.getRole().getName())
                            .build());
        }
        return studentDocs;
    }

    public StudentDoc findSubjectsByStudentId(int studentId){
        User student = userRepository.findById(studentId).orElse(null);
        if(student == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }

        if(!student.getRole().getName().equals("Student")){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User is not an student");
        }

        List<StudentSubjectDoc> subjectDocs= new ArrayList<>();
        for(StudentSubject sub: student.getStudentSubject()){
            double grade = 0.0;
            if(sub.getEvaluationList() != null){
                grade = sub.getEvaluationList().stream().mapToDouble(Evaluation::getScore).sum();
            }

            subjectDocs.add(
                    StudentSubjectDoc.builder()
                            .subject(sub.getSubject().getName())
                            .subjectId(sub.getSubject().getId())
                            .grade(grade)
                            .build());
        }

        return StudentDoc.builder()
                .subjects(subjectDocs)
                .name(student.getName())
                .studentId(student.getId())
                .role(student.getRole().getName())
                .lastName(student.getLastName())
                .build();
    }

    public StudentDoc enrollStudentInSubjects(int studentId){
        User student = userRepository.findById(studentId).orElse(null);
        if(student == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        if(!student.getRole().getName().equals("Student")){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User is not an student");
        }

        List<Subject> subjects = subjectRepository.findAll();
        studentSubjectRepository.deleteAllByStudentId(studentId);

        for(Subject sb: subjects){
            StudentSubject data = StudentSubject.builder()
                    .student(student)
                    .subject(sb)
                    .build();
            studentSubjectRepository.save(data);
        }

        student = userRepository.findById(studentId).orElse(null);
        if(student == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }

        List<StudentSubjectDoc> subjectDocs= new ArrayList<>();
        for(StudentSubject sub: student.getStudentSubject()){
            double grade = 0.0;
            if(sub.getEvaluationList() != null){
            grade = sub.getEvaluationList().stream().mapToDouble(Evaluation::getScore).sum();
            }

            subjectDocs.add(
                    StudentSubjectDoc.builder()
                            .subject(sub.getSubject().getName())
                            .subjectId(sub.getSubject().getId())
                            .grade(grade)
                            .build());
        }

        return StudentDoc.builder()
                .subjects(subjectDocs)
                .name(student.getName())
                .studentId(student.getId())
                .role(student.getRole().getName())
                .lastName(student.getLastName())
                .build();
    }
}
