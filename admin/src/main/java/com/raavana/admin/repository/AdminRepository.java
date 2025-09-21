package com.raavana.admin.repository;

import com.raavana.admin.entity.AdminEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<AdminEntity,String> {
}
