package com.raavana.admin.service;


import com.raavana.admin.entity.RecruiterEntity;
import com.raavana.admin.model.RecruiterDTO;
import com.raavana.admin.repository.RecruiterRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;

    public ResponseEntity<RecruiterDTO> recruiterPost(RecruiterDTO recruiterDTO) {
        try {

            if (recruiterDTO.getName() == null || recruiterDTO.getName().isEmpty() ||
                    recruiterDTO.getDesignation() == null || recruiterDTO.getDesignation().isEmpty() ||
                    recruiterDTO.getEmail() == null || recruiterDTO.getEmail().isEmpty() ||
                    recruiterDTO.getPhoneNumber() == null || recruiterDTO.getPhoneNumber().isEmpty() ||
                    recruiterDTO.getLocation() == null || recruiterDTO.getLocation().isEmpty() ||
                    recruiterDTO.getCompany() == null || recruiterDTO.getCompany().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            RecruiterEntity recruiterEntities = RecruiterEntity.builder()
                    .id(recruiterDTO.getId())
                    .name(recruiterDTO.getName())
                    .designation(recruiterDTO.getDesignation())
                    .email(recruiterDTO.getEmail())
                    .secondaryEmail(recruiterDTO.getSecondaryEmail())
                    .phoneNumber(recruiterDTO.getPhoneNumber())
                    .mobileNumber(recruiterDTO.getMobileNumber())
                    .location(recruiterDTO.getLocation())
                    .company(recruiterDTO.getCompany())
                    .description(recruiterDTO.getDescription())
                    .createdAt(recruiterDTO.getCreatedAt())
                    .createdBy(recruiterDTO.getCreatedBy())
                    .updatedAt(recruiterDTO.getUpdatedAt())
                    .updatedBy(recruiterDTO.getUpdatedBy())
                    .build();

            RecruiterEntity savedEntity = recruiterRepository.save(recruiterEntities);

            RecruiterDTO savedDTO = new RecruiterDTO();
            savedDTO.setId(savedEntity.getId());
            savedDTO.setName(savedEntity.getName());
            savedDTO.setDesignation(savedEntity.getDesignation());
            savedDTO.setEmail(savedEntity.getEmail());
            savedDTO.setSecondaryEmail(savedEntity.getSecondaryEmail());
            savedDTO.setPhoneNumber(savedEntity.getPhoneNumber());
            savedDTO.setMobileNumber(savedEntity.getMobileNumber());
            savedDTO.setLocation(savedEntity.getLocation());
            savedDTO.setCompany(savedEntity.getCompany());
            savedDTO.setDescription(savedEntity.getDescription());
            savedDTO.setCreatedAt(savedEntity.getCreatedAt());
            savedDTO.setCreatedBy(savedEntity.getCreatedBy());
            savedDTO.setUpdatedAt(savedEntity.getUpdatedAt());
            savedDTO.setUpdatedBy(savedEntity.getUpdatedBy());

            return ResponseEntity.status(HttpStatus.CREATED).body(savedDTO); // 201 Created

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<RecruiterDTO> recruiterIdGet(String id) {
        try {
            if (id == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

            RecruiterEntity recruiterEntities = recruiterRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recruiter not found with id: " + id));

            RecruiterDTO dto = new RecruiterDTO();
            dto.setId(recruiterEntities.getId());
            dto.setName(recruiterEntities.getName());
            dto.setDesignation(recruiterEntities.getDesignation());
            dto.setEmail(recruiterEntities.getEmail());
            dto.setSecondaryEmail(recruiterEntities.getSecondaryEmail());
            dto.setPhoneNumber(recruiterEntities.getPhoneNumber());
            dto.setMobileNumber(recruiterEntities.getMobileNumber());
            dto.setLocation(recruiterEntities.getLocation());
            dto.setCompany(recruiterEntities.getCompany());
            dto.setDescription(recruiterEntities.getDescription());
            dto.setCreatedAt(recruiterEntities.getCreatedAt());
            dto.setCreatedBy(recruiterEntities.getCreatedBy());
            dto.setUpdatedAt(recruiterEntities.getUpdatedAt());
            dto.setUpdatedBy(recruiterEntities.getUpdatedBy());

            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<RecruiterDTO> recruiterIdPut(String id, RecruiterDTO recruiterDTO) {
        try {
            if (id == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

            RecruiterEntity recruiterEntities = recruiterRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recruiter not found with id: " + id));

            recruiterEntities.setName(recruiterDTO.getName());
            recruiterEntities.setDesignation(recruiterDTO.getDesignation());
            recruiterEntities.setEmail(recruiterDTO.getEmail());
            recruiterEntities.setSecondaryEmail(recruiterDTO.getSecondaryEmail());
            recruiterEntities.setPhoneNumber(recruiterDTO.getPhoneNumber());
            recruiterEntities.setMobileNumber(recruiterDTO.getMobileNumber());
            recruiterEntities.setLocation(recruiterDTO.getLocation());
            recruiterEntities.setCompany(recruiterDTO.getCompany());
            recruiterEntities.setDescription(recruiterDTO.getDescription());
            recruiterEntities.setCreatedAt(recruiterDTO.getCreatedAt());
            recruiterEntities.setCreatedBy(recruiterDTO.getCreatedBy());
            recruiterEntities.setUpdatedAt(recruiterDTO.getUpdatedAt());
            recruiterEntities.setUpdatedBy(recruiterDTO.getUpdatedBy());

            RecruiterEntity updatedEntity = recruiterRepository.save(recruiterEntities);

            RecruiterDTO dto = new RecruiterDTO();
            dto.setId(updatedEntity.getId());
            dto.setName(updatedEntity.getName());
            dto.setDesignation(updatedEntity.getDesignation());
            dto.setEmail(updatedEntity.getEmail());
            dto.setSecondaryEmail(updatedEntity.getSecondaryEmail());
            dto.setPhoneNumber(updatedEntity.getPhoneNumber());
            dto.setMobileNumber(updatedEntity.getMobileNumber());
            dto.setLocation(updatedEntity.getLocation());
            dto.setCompany(updatedEntity.getCompany());
            dto.setDescription(updatedEntity.getDescription());
            dto.setCreatedAt(updatedEntity.getCreatedAt());
            dto.setCreatedBy(updatedEntity.getCreatedBy());
            dto.setUpdatedAt(updatedEntity.getUpdatedAt());
            dto.setUpdatedBy(updatedEntity.getUpdatedBy());

            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<String> recruiterIdDelete(String id) {
        try {
            if (id == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

            RecruiterEntity recruiterEntities = recruiterRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recruiter not found with id: " + id));

            recruiterRepository.delete(recruiterEntities);

            return ResponseEntity.noContent()
                    .build(); // 204 No Content

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<RecruiterDTO>> recruiterGet() {
        try {
            List<RecruiterEntity> recruiterEntities = recruiterRepository.findAll();
            List<RecruiterDTO> dtos = new ArrayList<>();
            for (RecruiterEntity entity : recruiterEntities) {
                RecruiterDTO dto = new RecruiterDTO();
                dto.setId(entity.getId());
                dto.setName(entity.getName());
                dto.setDesignation(entity.getDesignation());
                dto.setEmail(entity.getEmail());
                dto.setSecondaryEmail(entity.getSecondaryEmail());
                dto.setPhoneNumber(entity.getPhoneNumber());
                dto.setMobileNumber(entity.getMobileNumber());
                dto.setLocation(entity.getLocation());
                dto.setCompany(entity.getCompany());
                dto.setDescription(entity.getDescription());
                dto.setCreatedAt(entity.getCreatedAt());
                dto.setCreatedBy(entity.getCreatedBy());
                dto.setUpdatedAt(entity.getUpdatedAt());
                dto.setUpdatedBy(entity.getUpdatedBy());
                dtos.add(dto);
            }
            return ResponseEntity.ok(dtos);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
