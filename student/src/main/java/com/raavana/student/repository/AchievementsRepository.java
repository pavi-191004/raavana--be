package com.raavana.student.repository;

import com.raavana.student.entity.AchievementsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AchievementsRepository extends MongoRepository<AchievementsEntity, String> {
    List<AchievementsEntity> findByStudentId(String studentId);
}
