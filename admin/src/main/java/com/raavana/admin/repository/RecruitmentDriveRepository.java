package com.raavana.admin.repository;

import com.raavana.admin.entity.RecruitmentDriveEntity;
import com.raavana.admin.model.RecruitmentDrivesDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RecruitmentDriveRepository extends MongoRepository<RecruitmentDriveEntity,String> {
    Optional<RecruitmentDriveEntity> findByTitleOfTheDriveAndCompany(String titleOfTheDrive, RecruitmentDrivesDTO.CompanyEnum company);
}