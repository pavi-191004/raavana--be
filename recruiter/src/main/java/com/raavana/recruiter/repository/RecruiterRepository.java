package com.raavana.recruiter.repository;

import com.raavana.recruiter.entities.RecruiterEntities;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecruiterRepository extends MongoRepository<RecruiterEntities,String> {
}
