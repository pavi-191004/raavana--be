package com.raavana.student.repository;




import com.raavana.student.entity.AchievementEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AchievementRepository extends MongoRepository<AchievementEntity, String> {

}
