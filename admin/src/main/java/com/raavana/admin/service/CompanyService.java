package com.raavana.admin.service;

import com.raavana.admin.entity.CompanyEntity;
import com.raavana.admin.mapper.CompanyMapper;
import com.raavana.admin.model.CompanyDTO;
import com.raavana.admin.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public ResponseEntity<CompanyDTO> add(CompanyDTO companyDTO) {
        try {
            log.info("Adding new company: {}", companyDTO.getCompanyName());
            CompanyEntity entity = companyMapper.dtoToEntity(companyDTO);
            CompanyEntity saved = companyRepository.save(entity);
            log.info("Company saved with id: {}", saved.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(companyMapper.entityToDto(saved));
        } catch (Exception e) {
            log.error("Error while adding company: {}", companyDTO.getCompanyName(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<CompanyDTO> getById(String id) {
        try {
            log.info("Fetching company with id: {}", id);
            CompanyEntity entity = companyRepository.findById(id)
                    .orElseThrow(() -> {
                        log.error("Company not found with id: {}", id);
                        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found with id: " + id);
                    });
            return ResponseEntity.ok(companyMapper.entityToDto(entity));
        } catch (Exception e) {
            log.error("Error while fetching company with id : {}", id,  e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<CompanyDTO> update(String id, CompanyDTO companyDTO) {
        try {
            log.info("Updating company with id: {}", id);
            CompanyEntity entity = companyRepository.findById(id)
                    .orElseThrow(() -> {
                        log.error("Company not found with id: {}", id);
                        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
                    });

            companyMapper.updateEntityFromDto(companyDTO, entity);
            CompanyEntity updated = companyRepository.save(entity);
            log.info("Company updated successfully with id: {}",id);
            return ResponseEntity.ok(companyMapper.entityToDto(updated));
        } catch (Exception e) {
            log.error("Error while updating company with id : {}", id,  e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<String> delete(String id) {
        try {
            log.info("Deleting company with id: {}", id);
            CompanyEntity entity = companyRepository.findById(id)
                    .orElseThrow(() -> {
                        log.error("Company not found with id: {}", id);
                        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
                    });
            companyRepository.delete(entity);
            log.info("Company deleted successfully with id: {}", id);
            return ResponseEntity.ok("Deleted Successfully");
        } catch (Exception e) {
            log.error("Error while deleting company with id : {}", id,  e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<List<CompanyDTO>> getAll() {
        try {
            log.info("Fetching all companies");
            List<CompanyDTO> dtos = companyRepository.findAll()
                    .stream()
                    .map(companyMapper::entityToDto)
                    .collect(Collectors.toList());
            log.info("Total companies found: {}", dtos.size());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            log.error("Error while fetching all companies", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}