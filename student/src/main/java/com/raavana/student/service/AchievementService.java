package com.raavana.student.service;


import com.raavana.student.entity.AchievementEntity;
import com.raavana.student.mapper.AchievementMapper;
import com.raavana.student.model.AchievementDTO;
import com.raavana.student.repository.AchievementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementService {

    private final AchievementRepository achievementRepository;


    public AchievementDTO studentPost(AchievementDTO achievementDTO) {
        AchievementEntity entity = AchievementMapper.toEntity(achievementDTO);
        AchievementEntity savedEntity = achievementRepository.save(entity);
        return AchievementMapper.toDto(savedEntity);
    }


    public AchievementDTO studentIdGet(String id) {
        AchievementEntity entity = achievementRepository.findById(id).orElseThrow();
        return AchievementMapper.toDto(entity);
    }


    public AchievementDTO studentIdPut(String id, AchievementDTO achievementDTO) {
        AchievementEntity entity = achievementRepository.findById(id).orElseThrow();


        entity.setTitle(achievementDTO.getTitle());
        entity.setEvent(achievementDTO.getEvent());
        entity.setEventDate(achievementDTO.getEventDate());
        entity.setDescription(achievementDTO.getDescription());
        entity.setAwardedBy(achievementDTO.getAwardedBy());

        AchievementEntity updated = achievementRepository.save(entity);
        return AchievementMapper.toDto(updated);
    }


    public String studentIdDelete(String id) {
        AchievementEntity entity = achievementRepository.findById(id).orElseThrow();
        achievementRepository.delete(entity);
        return "Deleted Successfully";
    }


    public List<AchievementDTO> studentGet() {
        List<AchievementEntity> entityList = achievementRepository.findAll();
        return AchievementMapper.toDtoList(entityList);
    }

}
