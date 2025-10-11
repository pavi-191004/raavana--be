package com.raavana.student.mapper;

import com.raavana.student.entity.StudentProjectEntity;
import com.raavana.student.model.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentProjectMapper {
    // DTO → Entity
    public static StudentProjectEntity toEntity(StudentDTO dto) {
        if (dto == null) return null;

        return StudentProjectEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .description(dto.getDescription())
                .technologies(dto.getTechnologies())
                .build();
    }

    // Entity → DTO
    public static StudentDTO toDto(StudentProjectEntity entity) {
        if (entity == null) return null;

        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setDescription(entity.getDescription());
        dto.setTechnologies(entity.getTechnologies());
        return dto;
    }

    // List<Entity> → List<DTO>
    public static List<StudentDTO> toDtoList(List<StudentProjectEntity> entityList) {
        if (entityList == null || entityList.isEmpty()) return new ArrayList<>();
        List<StudentDTO> dtoList = new ArrayList<>();
        for (StudentProjectEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
