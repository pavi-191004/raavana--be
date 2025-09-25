package com.raavana.admin.service;

import com.raavana.admin.entity.RecruitmentDriveEntity;
import com.raavana.admin.model.RecruitmentDrivesDTO;
import com.raavana.admin.repository.RecruitmentDriveRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RecruitmentDriveService {

    private final RecruitmentDriveRepository recruitmentDriveRepository;

    // CREATE
    public ResponseEntity<String> recruitmentDrivesPost(RecruitmentDrivesDTO dto) {
        try {
            if (dto.getTitleOfTheDrive() == null || dto.getCompany() == null
                    || dto.getRoleOrDesignation() == null || dto.getWorkLocation() == null
                    || dto.getJobDescription() == null || dto.getDate() == null
                    || dto.getTime() == null || dto.getEligibilityCriteria() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input data or Missing required fields");
            }

            boolean exists = recruitmentDriveRepository
                    .findByTitleOfTheDriveAndCompany(dto.getTitleOfTheDrive(), dto.getCompany())
                    .isPresent();
            if (exists) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Recruitment Drive already exists");
            }

            RecruitmentDriveEntity entity = toEntity(dto);
            recruitmentDriveRepository.save(entity);

            return ResponseEntity.status(HttpStatus.CREATED).body("Recruitment Drive Created successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Creation Failed");
        }
    }


    // GET ALL
    public ResponseEntity<List<RecruitmentDrivesDTO>> recruitmentDrivesGet() {
        try {
            List<RecruitmentDriveEntity> entities = recruitmentDriveRepository.findAll();
            List<RecruitmentDrivesDTO> dtos = new ArrayList<>();
            for (RecruitmentDriveEntity entity : entities) {
                dtos.add(toDTO(entity));
            }
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // GET BY ID
    public ResponseEntity<RecruitmentDrivesDTO> recruitmentDrivesIdGet(String id) {
        if (id == null || id.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid ID");
        }

        RecruitmentDriveEntity entity = recruitmentDriveRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Recruitment Drive not found with id: " + id));

        return ResponseEntity.ok(toDTO(entity));
    }


    // UPDATE
    public ResponseEntity<String> recruitmentDrivesIdPut(String id, RecruitmentDrivesDTO dto) {
        // Check for null ID
        if (id == null || id.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID");
        }

        if (dto.getTitleOfTheDrive() == null || dto.getTitleOfTheDrive().isEmpty() ||
                dto.getCompany() == null ||
                dto.getRoleOrDesignation() == null || dto.getRoleOrDesignation().isEmpty() ||
                dto.getWorkLocation() == null ||
                dto.getJobDescription() == null || dto.getJobDescription().isEmpty() ||
                dto.getDate() == null || dto.getTime() == null ||
                dto.getEligibilityCriteria() == null || dto.getEligibilityCriteria().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing required fields");
        }

        try {
            RecruitmentDriveEntity entity = recruitmentDriveRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Recruitment Drive not found with id: " + id));

            entity.setTitleOfTheDrive(dto.getTitleOfTheDrive());
            entity.setCompany(dto.getCompany());
            entity.setRoleOrDesignation(dto.getRoleOrDesignation());
            entity.setWorkLocation(dto.getWorkLocation());
            entity.setJobDescription(dto.getJobDescription());
            entity.setDate(dto.getDate());
            entity.setTime(dto.getTime());
            entity.setEligibilityCriteria(dto.getEligibilityCriteria());
            entity.setVenueDetails(dto.getVenueDetails());
            entity.setInterviewDetails(dto.getInterviewDetails());
            entity.setInterviewRounds(dto.getInterviewRounds());

            recruitmentDriveRepository.save(entity);
            return ResponseEntity.ok("Recruitment Drive Updated successfully");

        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update Failed");
        }
    }

    // DELETE
    public ResponseEntity<String> recruitmentDrivesIdDelete(String id) {
        try {
            if (id == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

            RecruitmentDriveEntity entity = recruitmentDriveRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Recruitment Drive not found with id: " + id));

            recruitmentDriveRepository.delete(entity);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // --- Mapper Methods ---
    private RecruitmentDriveEntity toEntity(RecruitmentDrivesDTO dto) {
        RecruitmentDriveEntity entity = new RecruitmentDriveEntity();
        entity.setTitleOfTheDrive(dto.getTitleOfTheDrive());
        entity.setCompany(dto.getCompany());
        entity.setRoleOrDesignation(dto.getRoleOrDesignation());
        entity.setWorkLocation(dto.getWorkLocation());
        entity.setJobDescription(dto.getJobDescription());
        entity.setDate(dto.getDate());
        entity.setTime(dto.getTime());
        entity.setEligibilityCriteria(dto.getEligibilityCriteria());
        entity.setVenueDetails(dto.getVenueDetails());
        entity.setInterviewDetails(dto.getInterviewDetails());
        entity.setInterviewRounds(dto.getInterviewRounds());
        return entity;
    }

    private RecruitmentDrivesDTO toDTO(RecruitmentDriveEntity entity) {
        RecruitmentDrivesDTO dto = new RecruitmentDrivesDTO();
        dto.setTitleOfTheDrive(entity.getTitleOfTheDrive());
        dto.setCompany(entity.getCompany());
        dto.setRoleOrDesignation(entity.getRoleOrDesignation());
        dto.setWorkLocation(entity.getWorkLocation());
        dto.setJobDescription(entity.getJobDescription());
        dto.setDate(entity.getDate());
        dto.setTime(entity.getTime());
        dto.setEligibilityCriteria(entity.getEligibilityCriteria());
        dto.setVenueDetails(entity.getVenueDetails());
        dto.setInterviewDetails(entity.getInterviewDetails());
        dto.setInterviewRounds(entity.getInterviewRounds());
        return dto;
    }
}
