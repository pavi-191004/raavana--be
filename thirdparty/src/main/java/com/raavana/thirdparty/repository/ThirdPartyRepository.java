package com.raavana.thirdparty.repository;

import com.raavana.thirdparty.entity.ThirdPartyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThirdPartyRepository extends MongoRepository<ThirdPartyEntity,String> {
}
