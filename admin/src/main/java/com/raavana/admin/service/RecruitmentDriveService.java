package com.raavana.admin.service;

import com.raavana.admin.entity.RecruitmentDriveEntity;
import com.raavana.admin.model.RecruitmentDrivesDTO;
import com.raavana.admin.repository.RecruitmentDriveRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RecruitmentDriveService {

    private final RecruitmentDriveRepository recruitmentDriveRepository;

    // CREATE
    public ResponseEntity<String> createRecruitmentDrive(RecruitmentDrivesDTO dto) {
        try {
            boolean exists = recruitmentDriveRepository
                    .findByTitleOfTheDriveAndCompany(dto.getTitleOfTheDrive(), dto.getCompany())
                    .isPresent();
            if (exists) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Recruitment Drive already exists!");
            }
            RecruitmentDriveEntity entity = new RecruitmentDriveEntity();
            updateEntityFromDto(entity, dto);
            recruitmentDriveRepository.save(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body("Recruitment Drive Created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Creation Failed");
        }
    }

    // GET ALL
    public ResponseEntity<List<RecruitmentDrivesDTO>> getAllRecruitmentDrives() {
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
    public ResponseEntity<RecruitmentDrivesDTO> getRecruitmentDriveById(String id) {
        RecruitmentDriveEntity entity = recruitmentDriveRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Recruitment Drive not found with id: " + id));
        return ResponseEntity.ok(toDTO(entity));
    }

    // UPDATE
    public ResponseEntity<String> updateRecruitmentDrive(String id, RecruitmentDrivesDTO dto) {
        try {
            RecruitmentDriveEntity entity = recruitmentDriveRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Recruitment Drive not found with id: " + id));

            updateEntityFromDto(entity, dto);
            recruitmentDriveRepository.save(entity);
            return ResponseEntity.ok("Recruitment Drive Updated successfully!");
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update Failed");
        }
    }

    // DELETE
    public ResponseEntity<String> deleteRecruitmentDrive(String id) {
        return recruitmentDriveRepository.findById(id)
                .map(entity -> {
                    recruitmentDriveRepository.delete(entity);
                    return ResponseEntity.ok("Recruitment Drive Deleted Successfully!");
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Recruitment Drive not found with id: " + id));
    }

    // Get All Registered Companies as Dropdown via Company Service
    public List<String> getAllCompanies() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String companyApi = ""; // TODO: Replace With CompanyAPI after backend deployed

            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                    companyApi,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Map<String, Object>>>() {}
            );
            if (response.getBody() == null) return new ArrayList<>();
            List<String> companyNames = new ArrayList<>();
            response.getBody().forEach(company -> {
                Object name = company.get("companyName");
                if (name != null) companyNames.add(name.toString());
            });

            return companyNames;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Mapper Methods
    private void updateEntityFromDto(RecruitmentDriveEntity entity, RecruitmentDrivesDTO dto) {
        entity.setTitleOfTheDrive(dto.getTitleOfTheDrive());
        entity.setCompany(dto.getCompany());
        entity.setRoleOrDesignation(dto.getRoleOrDesignation());
        entity.setWorkLocation(dto.getWorkLocation());
        entity.setJobDescription(dto.getJobDescription());

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

        entity.setDate(LocalDate.parse(dto.getDate(), dateFormatter));
        entity.setTime(LocalTime.parse(dto.getTime(), timeFormatter));

        entity.setEligibilityCriteria(dto.getEligibilityCriteria());
        entity.setVenueDetails(dto.getVenueDetails());
        entity.setInterviewDetails(dto.getInterviewDetails());
        entity.setInterviewRounds(dto.getInterviewRounds());
        entity.setStatus(dto.getStatus());
    }

    private RecruitmentDrivesDTO toDTO(RecruitmentDriveEntity entity) {
        RecruitmentDrivesDTO dto = new RecruitmentDrivesDTO();
        dto.setId(entity.getId());
        dto.setTitleOfTheDrive(entity.getTitleOfTheDrive());
        dto.setCompany(entity.getCompany());
        dto.setRoleOrDesignation(entity.getRoleOrDesignation());
        dto.setWorkLocation(entity.getWorkLocation());
        dto.setJobDescription(entity.getJobDescription());
        dto.setDate(entity.getDate().toString());
        dto.setTime(entity.getTime().toString());
        dto.setEligibilityCriteria(entity.getEligibilityCriteria());
        dto.setVenueDetails(entity.getVenueDetails());
        dto.setInterviewDetails(entity.getInterviewDetails());
        dto.setInterviewRounds(entity.getInterviewRounds());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
