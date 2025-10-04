package com.raavana.admin.repository;


import com.raavana.admin.entity.RecruiterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecruiterRepository extends MongoRepository<RecruiterEntity,String> {
}
