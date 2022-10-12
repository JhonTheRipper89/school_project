package com.schoolproject.school.service;

import com.schoolproject.school.docs.SubjectDoc;
import com.schoolproject.school.dtos.SubjectDto;
import com.schoolproject.school.entity.Subject;
import com.schoolproject.school.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<SubjectDoc> find(){
       List<Subject>  subjects = subjectRepository.findAll();
       List<SubjectDoc> subjectDocs = new ArrayList<>();

       for(Subject sb: subjects){
           subjectDocs.add(
                   SubjectDoc.builder()
                           .subjectId(sb.getId())
                           .name(sb.getName())
                           .build());
       }

       return subjectDocs;
    }

    public SubjectDoc findOne(int subjectId){
        Subject subject = subjectRepository.findById(subjectId).orElse(null);
        if(subject == null ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject not found");
        }

        return SubjectDoc.builder()
                .subjectId(subject.getId())
                .name(subject.getName())
                .build();
    }

    public SubjectDoc save(SubjectDto subjectDto){
        Subject subject = Subject.builder().name(subjectDto.getName()).build();
        subjectRepository.save(subject);

        return SubjectDoc.builder()
                .subjectId(subject.getId())
                .name(subject.getName())
                .build();
    }

    public SubjectDoc update(int subjectId, SubjectDto subjectDto){
        Subject subject = subjectRepository.findById(subjectId).orElse(null);
         if(subject == null){
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The subject does not exist");
         }

         subject.setName(subjectDto.getName());
         subjectRepository.save(subject);

         return SubjectDoc.builder()
                 .subjectId(subject.getId())
                 .name(subject.getName())
                 .build();
    }
}
