package com.raavana.admin.repository;

import com.raavana.admin.entity.SubDomainEntity;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface SubDomainRepository extends MongoRepository<SubDomainEntity,String> {

}

