package com.raavana.student.mapper;

import com.raavana.student.entity.AchievementEntity;
import com.raavana.student.model.AchievementDTO;

import java.util.ArrayList;
import java.util.List;

public class AchievementMapper {

    // Convert DTO → Entity
    public static AchievementEntity toEntity(AchievementDTO dto) {
        AchievementEntity entity = new AchievementEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setEvent(dto.getEvent());
        entity.setEventDate(dto.getEventDate());
        entity.setDescription(dto.getDescription());
        entity.setAwardedBy(dto.getAwardedBy());
        return entity;
    }

    // Convert Entity → DTO
    public static AchievementDTO toDto(AchievementEntity entity) {
        AchievementDTO dto = new AchievementDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setEvent(entity.getEvent());
        dto.setEventDate(String.valueOf(entity.getEventDate()));
        dto.setDescription(entity.getDescription());
        dto.setAwardedBy(entity.getAwardedBy());
        return dto;
    }

    // Convert List<Entity> → List<DTO>
    public static List<AchievementDTO> toDtoList(List<AchievementEntity> entityList) {
        List<AchievementDTO> dtoList = new ArrayList<>();
        for (AchievementEntity entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
