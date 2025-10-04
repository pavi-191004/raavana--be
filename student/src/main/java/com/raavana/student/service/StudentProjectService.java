package com.raavana.student.service;


import com.raavana.student.entity.StudentProjectEntity;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.repository.StudentProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentProjectService {

    private final StudentProjectRepository studentProjectRepository; // keep only this

    public StudentDTO studentPost(StudentDTO studentDTO){
        StudentProjectEntity studentProjectEntity = StudentProjectEntity.builder()
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .startDate(studentDTO.getStartDate())
                .endDate(studentDTO.getEndDate())
                .description(studentDTO.getDescription())
                .technologies(studentDTO.getTechnologies())
                .build();

        StudentProjectEntity savedEntity = studentProjectRepository.save(studentProjectEntity);

        StudentDTO savedDTO = new StudentDTO();
        savedDTO.setId(savedEntity.getId());
        savedDTO.setName(savedEntity.getName());
        savedDTO.setStartDate(savedEntity.getStartDate());
        savedDTO.setEndDate(savedEntity.getEndDate());
        savedDTO.setDescription(savedEntity.getDescription());
        savedDTO.setTechnologies(savedEntity.getTechnologies());

        return savedDTO;
    }
    public StudentDTO studentIdGet(String id){

        StudentProjectEntity savedEntity = studentProjectRepository.findById(id).orElseThrow();

        StudentDTO dto = new StudentDTO();
        dto.setId(savedEntity.getId());
        dto.setName(savedEntity.getName());
        dto.setStartDate(savedEntity.getStartDate());
        dto.setEndDate(savedEntity.getEndDate());
        dto.setDescription(savedEntity.getDescription());
        dto.setTechnologies(savedEntity.getTechnologies());

        return dto;
    }


    public StudentDTO studentIdPut(String id, StudentDTO studentDTO) {
        StudentProjectEntity savedEntity = studentProjectRepository.findById(id).orElseThrow();

        // Update the saved entity
        savedEntity.setId(studentDTO.getId());
        savedEntity.setName(studentDTO.getName());
        savedEntity.setStartDate(studentDTO.getStartDate());
        savedEntity.setEndDate(studentDTO.getEndDate());
        savedEntity.setDescription(studentDTO.getDescription());
        savedEntity.setTechnologies(studentDTO.getTechnologies());

        // Save updated entity
        StudentProjectEntity updatedEntity = studentProjectRepository.save(savedEntity);

        // Prepare DTO to return
        StudentDTO dto = new StudentDTO();
        dto.setId(updatedEntity.getId());
        dto.setName(updatedEntity.getName());
        dto.setStartDate(updatedEntity.getStartDate());
        dto.setEndDate(updatedEntity.getEndDate());
        dto.setDescription(updatedEntity.getDescription());
        dto.setTechnologies(updatedEntity.getTechnologies());

        return dto;
    }


    public String studentIdDelete(String id){
        StudentProjectEntity studentProjectEntity = studentProjectRepository.findById(id).orElseThrow();
        studentProjectRepository.delete(studentProjectEntity);
        return "Deleted Successfully";
    }


    public List<StudentDTO> studentGet(){
        List<StudentProjectEntity> studentProjectEntity = studentProjectRepository.findAll();

        List<StudentDTO> studentDTOS =  new ArrayList<>();
        for(StudentProjectEntity entity : studentProjectEntity){
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setStartDate(entity.getStartDate());
            dto.setEndDate(entity.getEndDate());
            dto.setDescription(entity.getDescription());
            dto.setTechnologies(entity.getTechnologies());

            studentDTOS.add(dto);
        }

        return studentDTOS;
    }
}
