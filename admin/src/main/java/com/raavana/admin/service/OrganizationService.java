package com.raavana.admin.service;

import com.raavana.admin.entity.OrganizationEntity;
import com.raavana.admin.model.OrganizationInfo;
import com.raavana.admin.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public ResponseEntity<OrganizationInfo> organizationPost(OrganizationInfo organizationInfo) {
        try {
            // 400 Bad Request if any required field is missing
            if (organizationInfo.getOrganizationId() == null || organizationInfo.getOrganizationId().isEmpty() ||
                    organizationInfo.getOrganizationName() == null || organizationInfo.getOrganizationName().isEmpty() ||
                    organizationInfo.getOrganizationType() == null ||
                    organizationInfo.getDepartments() == null || organizationInfo.getDepartments().isEmpty() ||
                    organizationInfo.getLocation() == null || organizationInfo.getLocation().isEmpty() ||
                    organizationInfo.getWebsite() == null || organizationInfo.getWebsite().isEmpty()) {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            OrganizationEntity organizationEntity = OrganizationEntity.builder()
                    .organizationId(organizationInfo.getOrganizationId())
                    .organizationName(organizationInfo.getOrganizationName())
                    .organizationType(organizationInfo.getOrganizationType().name())
                    .departments(organizationInfo.getDepartments())
                    .location(organizationInfo.getLocation())
                    .website(organizationInfo.getWebsite())
                    .subdomain(organizationInfo.getSubdomain())
                    .build();

            OrganizationEntity savedEntity = organizationRepository.save(organizationEntity);

            OrganizationInfo savedInfo = new OrganizationInfo();
            savedInfo.setOrganizationId(savedEntity.getOrganizationId());
            savedInfo.setOrganizationName(savedEntity.getOrganizationName());
            savedInfo.setOrganizationType(OrganizationInfo.OrganizationTypeEnum.valueOf(savedEntity.getOrganizationType()));
            savedInfo.setDepartments(savedEntity.getDepartments());
            savedInfo.setLocation(savedEntity.getLocation());
            savedInfo.setWebsite(savedEntity.getWebsite());
            savedInfo.setSubdomain(savedEntity.getSubdomain());

            return ResponseEntity.ok(savedInfo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
