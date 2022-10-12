package com.schoolproject.school.controller;

import com.schoolproject.school.docs.SubjectDoc;
import com.schoolproject.school.dtos.SubjectDto;
import com.schoolproject.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<SubjectDoc>> find(){
        return new ResponseEntity<>(subjectService.find(), HttpStatus.OK);
    }

    @GetMapping(path = "/{subjectId}")
    public ResponseEntity<SubjectDoc> findOne(@PathVariable int subjectId){
        return new ResponseEntity<>(subjectService.findOne(subjectId), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<SubjectDoc> save(@RequestBody SubjectDto subjectDto){
        System.out.println(subjectDto.getName());
        return new ResponseEntity<>(subjectService.save(subjectDto), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{subjectId}")
    public ResponseEntity<SubjectDoc> update(@PathVariable int subjectId, @RequestBody SubjectDto subjectDto){
        return new ResponseEntity<>(subjectService.update(subjectId, subjectDto), HttpStatus.ACCEPTED);
    }
}
