package com.raavana.student.service;


import com.raavana.student.entity.StudentProjectEntity;
import com.raavana.student.mapper.StudentProjectMapper;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.repository.StudentProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentProjectService {

    private final StudentProjectRepository studentProjectRepository;
    private StudentProjectMapper StudentProjectMapper;

    public StudentDTO studentPost(StudentDTO studentDTO) {
        StudentProjectEntity entity = com.raavana.student.mapper.StudentProjectMapper.toEntity(studentDTO);
        StudentProjectEntity savedEntity = studentProjectRepository.save(entity);
        return com.raavana.student.mapper.StudentProjectMapper.toDto(savedEntity);
    }

    public StudentDTO studentIdGet(String id) {
        StudentProjectEntity entity = studentProjectRepository.findById(id).orElseThrow();
        return com.raavana.student.mapper.StudentProjectMapper.toDto(entity);
    }

    public StudentDTO studentIdPut(String id, StudentDTO studentDTO) {
        StudentProjectEntity entity = studentProjectRepository.findById(id).orElseThrow();

        // Update fields
        entity.setName(studentDTO.getName());
        entity.setStartDate(studentDTO.getStartDate());
        entity.setEndDate(studentDTO.getEndDate());
        entity.setDescription(studentDTO.getDescription());
        entity.setTechnologies(studentDTO.getTechnologies());

        StudentProjectEntity updatedEntity = studentProjectRepository.save(entity);
        return com.raavana.student.mapper.StudentProjectMapper.toDto(updatedEntity);
    }

    public String studentIdDelete(String id) {
        StudentProjectEntity entity = studentProjectRepository.findById(id).orElseThrow();
        studentProjectRepository.delete(entity);
        return "Deleted Successfully";
    }

    public List<StudentDTO> studentGet() {
        List<StudentProjectEntity> entityList = studentProjectRepository.findAll();
        return com.raavana.student.mapper.StudentProjectMapper.toDtoList(entityList);
    }
}
