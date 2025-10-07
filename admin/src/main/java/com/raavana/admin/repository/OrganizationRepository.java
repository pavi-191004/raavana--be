package com.raavana.admin.repository;

import com.raavana.admin.entity.OrganizationEntity;
import com.raavana.admin.model.OrganizationInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface OrganizationRepository extends MongoRepository<OrganizationEntity, String> {
    Optional<OrganizationEntity> findOrganizationEntitiesByOrganizationId(String organizationId);
}

