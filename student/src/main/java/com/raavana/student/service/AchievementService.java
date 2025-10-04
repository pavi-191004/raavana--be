package com.raavana.student.service;



import com.raavana.student.entity.AchievementEntity;
import com.raavana.student.model.AchievementDTO;
import com.raavana.student.repository.AchievementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementService {

    private final AchievementRepository achievementRepository;

    public AchievementDTO studentPost(AchievementDTO achievementDTO){
        AchievementEntity achievementEntity = AchievementEntity.builder()
                .id(achievementDTO.getId())
                .title(achievementDTO.getTitle())
                .event(achievementDTO.getEvent())
                .eventDate(achievementDTO.getEventDate())
                .description(achievementDTO.getDescription())
                .awardedBy(achievementDTO.getAwardedBy())
                .build();

        AchievementEntity savedEntity = achievementRepository.save(achievementEntity);

        AchievementDTO savedDTO = new AchievementDTO();
        savedDTO.setId(savedEntity.getId());
        savedDTO.setTitle(savedEntity.getTitle());
        savedDTO.setEvent(savedEntity.getEvent());
        savedDTO.setEventDate(savedEntity.getEventDate());
        savedDTO.setDescription(savedEntity.getDescription());
        savedDTO.setAwardedBy(savedEntity.getAwardedBy());

        return savedDTO;
    }

    public AchievementDTO studentIdGet(String id){
        AchievementEntity savedEntity = achievementRepository.findById(id).orElseThrow();

        AchievementDTO dto = new AchievementDTO();
        dto.setId(savedEntity.getId());
        dto.setTitle(savedEntity.getTitle());
        dto.setEvent(savedEntity.getEvent());
        dto.setEventDate(savedEntity.getEventDate());
        dto.setDescription(savedEntity.getDescription());
        dto.setAwardedBy(savedEntity.getAwardedBy());

        return dto;
    }

    public AchievementDTO studentIdPut(String id, AchievementDTO achievementDTO) {
        AchievementEntity savedEntity = achievementRepository.findById(id).orElseThrow();

        savedEntity.setId(achievementDTO.getId());
        savedEntity.setTitle(achievementDTO.getTitle());
        savedEntity.setEvent(achievementDTO.getEvent());
        savedEntity.setEventDate(achievementDTO.getEventDate());
        savedEntity.setDescription(achievementDTO.getDescription());
        savedEntity.setAwardedBy(achievementDTO.getAwardedBy());

        AchievementEntity updatedEntity = achievementRepository.save(savedEntity);

        AchievementDTO dto = new AchievementDTO();
        dto.setId(updatedEntity.getId());
        dto.setTitle(updatedEntity.getTitle());
        dto.setEvent(updatedEntity.getEvent());
        dto.setEventDate(updatedEntity.getEventDate());
        dto.setDescription(updatedEntity.getDescription());
        dto.setAwardedBy(updatedEntity.getAwardedBy());

        return dto;
    }

    public String studentIdDelete(String id){
        AchievementEntity achievementEntity = achievementRepository.findById(id).orElseThrow();
        achievementRepository.delete(achievementEntity);
        return "Deleted Successfully";
    }

    public List<AchievementDTO> studentGet(){
        List<AchievementEntity> achievementEntities = achievementRepository.findAll();

        List<AchievementDTO> achievementDTOS =  new ArrayList<>();
        for(AchievementEntity entity : achievementEntities){
            AchievementDTO dto = new AchievementDTO();
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setEvent(entity.getEvent());
            dto.setEventDate(entity.getEventDate());
            dto.setDescription(entity.getDescription());
            dto.setAwardedBy(entity.getAwardedBy());

            achievementDTOS.add(dto);
        }

        return achievementDTOS;
    }


}

