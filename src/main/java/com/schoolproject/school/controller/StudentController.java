package com.schoolproject.school.controller;

import com.schoolproject.school.docs.StudentDoc;
import com.schoolproject.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDoc>> find(){
        return new ResponseEntity<>(studentService.find(), HttpStatus.OK);
    }

    @GetMapping(path = "/{studentId}/subjects")
    public ResponseEntity<StudentDoc> findSubjectsByStudentId(@PathVariable int studentId){
        return new ResponseEntity<>(studentService.findSubjectsByStudentId(studentId), HttpStatus.FOUND);
    }

    @GetMapping(path = "/{studentId}/subjects-enroll")
    public ResponseEntity<StudentDoc> enrollStudentInSubjects(@PathVariable int studentId){
        return new ResponseEntity<>(studentService.enrollStudentInSubjects(studentId), HttpStatus.OK);
    }
}
