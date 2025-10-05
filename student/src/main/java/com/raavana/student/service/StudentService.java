package com.raavana.student.service;


import com.raavana.student.entity.StudentEntity;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentDTO addPost(StudentDTO studentDTO){
        StudentEntity studentEntity=StudentEntity.builder()
                .studentName(studentDTO.getStudentName())
                .studentAge(studentDTO.getStudentAge())
                .build();
        StudentEntity saveEntity = studentRepository.save(studentEntity);
        return studentDTO;
    }
}
