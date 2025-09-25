package com.raavana.admin.service;

import com.raavana.admin.entity.CompanyEntity;
import com.raavana.admin.model.CompanyDTO;
import com.raavana.admin.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {


    private final CompanyRepository companyRepository;

    public ResponseEntity<CompanyDTO> companyPost(CompanyDTO companyDTO) {
        try {

            // 400 Bad Request if any required field is missing
            if (companyDTO.getCompanyName() == null || companyDTO.getCompanyName().isEmpty() ||
                    companyDTO.getIndustry() == null || companyDTO.getIndustry().isEmpty() ||
                    companyDTO.getLocation() == null || companyDTO.getLocation(). isEmpty() ||
                    companyDTO.getWebsite() == null || companyDTO.getWebsite().isEmpty()) {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            // Build entity from DTO  fields
            CompanyEntity companyEntities = CompanyEntity.builder()
                    .companyName(companyDTO.getCompanyName())
                    .industry(companyDTO.getIndustry())
                    .website(companyDTO.getWebsite())
                    .location(companyDTO.getLocation())
                    .specialities(companyDTO.getSpecialities())
                    .description(companyDTO.getDescription())
                    .createdAt(companyDTO.getCreatedAt())
                    .createdBy(companyDTO.getCreatedBy())
                    .updatedAt(companyDTO.getUpdatedAt())
                    .updatedBy(companyDTO.getUpdatedBy())
                    .build();

            CompanyEntity savedEntity = companyRepository.save(companyEntities);

            // Map entity back to DTO
            CompanyDTO savedDTO = new CompanyDTO();
            savedDTO.setId(savedEntity.getId());
            savedDTO.setCompanyName(savedEntity.getCompanyName());
            savedDTO.setIndustry(savedEntity.getIndustry());
            savedDTO.setWebsite(savedEntity.getWebsite());
            savedDTO.setLocation(savedEntity.getLocation());
            savedDTO.setSpecialities(savedEntity.getSpecialities());
            savedDTO.setDescription(savedEntity.getDescription());
            savedDTO.setCreatedAt(savedEntity.getCreatedAt());
            savedDTO.setCreatedBy(savedEntity.getCreatedBy());
            savedDTO.setUpdatedAt(savedEntity.getUpdatedAt());
            savedDTO.setUpdatedBy(savedEntity.getUpdatedBy());

            // 201 Created
            return ResponseEntity.ok(savedDTO);

        } catch (Exception e) {
            // 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<CompanyDTO> companyIdGet(String id) {

        try {

            // 400 Bad Request
            if (id == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            // 404 Not Found
            CompanyEntity companyEntities = companyRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found with id: " + id));


            // Mapping entity → DTO
            CompanyDTO dto = new CompanyDTO();
            dto.setId(companyEntities.getId());
            dto.setCompanyName(companyEntities.getCompanyName());
            dto.setLocation(companyEntities.getLocation());
            dto.setIndustry(companyEntities.getIndustry());
            dto.setWebsite(companyEntities.getWebsite());
            dto.setSpecialities(companyEntities.getSpecialities());
            dto.setDescription(companyEntities.getDescription());
            dto.setCreatedAt(companyEntities.getCreatedAt());
            dto.setCreatedBy(companyEntities.getCreatedBy());
            dto.setUpdatedAt(companyEntities.getUpdatedAt());
            dto.setUpdatedBy(companyEntities.getUpdatedBy());

            // 200 Ok
            return ResponseEntity.ok(dto);

        }catch (Exception e){
            // 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    public ResponseEntity<CompanyDTO> companyIdPut(String id, CompanyDTO companyDTO) {

        try {

            // 400 Bad Request
            if (id == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            //404 Not Found
            CompanyEntity companyEntities = companyRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "company not found"));

            companyEntities.setCompanyName(companyDTO.getCompanyName());
            companyEntities.setLocation(companyDTO.getLocation());
            companyEntities.setIndustry(companyDTO.getIndustry());
            companyEntities.setWebsite(companyDTO.getWebsite());
            companyEntities.setSpecialities(companyDTO.getSpecialities());
            companyEntities.setDescription(companyDTO.getDescription());
            companyEntities.setCreatedAt(companyDTO.getCreatedAt());
            companyEntities.setCreatedBy(companyDTO.getCreatedBy());
            companyEntities.setUpdatedAt(companyDTO.getUpdatedAt());
            companyEntities.setUpdatedBy(companyDTO.getUpdatedBy());

            // Save updated entity
            CompanyEntity updatedEntity = companyRepository.save(companyEntities);


            CompanyDTO updatedDTO = new CompanyDTO();
            updatedDTO.setId(updatedEntity.getId());
            updatedDTO.setCompanyName(updatedEntity.getCompanyName());
            updatedDTO.setLocation(updatedEntity.getLocation());
            updatedDTO.setIndustry(updatedEntity.getIndustry());
            updatedDTO.setWebsite(updatedEntity.getWebsite());
            updatedDTO.setSpecialities(updatedEntity.getSpecialities());
            updatedDTO.setDescription(updatedEntity.getDescription());
            updatedDTO.setCreatedAt(updatedEntity.getCreatedAt());
            updatedDTO.setCreatedBy(updatedEntity.getCreatedBy());
            updatedDTO.setUpdatedAt(updatedEntity.getUpdatedAt());
            updatedDTO.setUpdatedBy(updatedEntity.getUpdatedBy());

            //200 Ok
            return ResponseEntity.ok(updatedDTO);

        }catch (Exception e) {

            // 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    public  ResponseEntity<String> companyIdDelete(String id){

        try {

            // 400 Bad Request
            if (id == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            //404 Not Found
            CompanyEntity companyEntities = companyRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"company not found"));
            companyRepository.delete(companyEntities);

            //200 Ok
            return ResponseEntity.ok("Delete Successfully");

        }catch (Exception e) {
            // 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    public ResponseEntity<List<CompanyDTO>> companyGet() {
        try {
            // Fetch all companies
            List<CompanyEntity> entities = companyRepository.findAll();

            // If no companies found, you can still return 200 with empty list
            if (entities.isEmpty()) {
                return ResponseEntity.ok(new ArrayList<>()); // 200 OK with empty list
            }

            // Map entities to DTOs
            List<CompanyDTO> dtos = new ArrayList<>();
            for (CompanyEntity entity : entities) {
                CompanyDTO dto = new CompanyDTO();
                dto.setId(entity.getId());
                dto.setCompanyName(entity.getCompanyName());
                dto.setLocation(entity.getLocation());
                dto.setIndustry(entity.getIndustry());
                dto.setWebsite(entity.getWebsite());
                dto.setSpecialities(entity.getSpecialities());
                dto.setDescription(entity.getDescription());
                dto.setCreatedAt(entity.getCreatedAt());
                dto.setCreatedBy(entity.getCreatedBy());
                dto.setUpdatedAt(entity.getUpdatedAt());
                dto.setUpdatedBy(entity.getUpdatedBy());
                dtos.add(dto);
            }

            // 200 OK
            return ResponseEntity.ok(dtos);

        } catch (IllegalArgumentException e) {
            // 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        } catch (Exception e) {
            // 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}



