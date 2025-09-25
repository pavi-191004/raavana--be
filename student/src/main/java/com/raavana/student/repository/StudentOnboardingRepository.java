package com.raavana.student.repository;

import com.raavana.student.entity.StudentOnboardingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOnboardingRepository extends MongoRepository<StudentOnboardingEntity, String> {
}
