package com.raavana.admin.repository;

import com.raavana.admin.entity.CompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<CompanyEntity , String> {
}
