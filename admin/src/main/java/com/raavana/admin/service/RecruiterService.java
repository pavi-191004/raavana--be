package com.raavana.admin.service;


import com.raavana.admin.entity.RecruiterEntity;
import com.raavana.admin.mapper.RecruiterMapper;
import com.raavana.admin.model.RecruiterDTO;
import com.raavana.admin.repository.RecruiterRepository;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;
    private final RecruiterMapper recruiterMapper;

    public ResponseEntity<RecruiterDTO> add(RecruiterDTO recruiterDTO) {

        try {
            log.info("Adding new recruiter: {}",recruiterDTO.getName());
            RecruiterEntity recruiterEntity = recruiterMapper.dtoToEntity(recruiterDTO);
            RecruiterEntity savedEntity = recruiterRepository.save(recruiterEntity);
            log.info("Recruiter saved with id: {}",savedEntity.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(recruiterMapper.entityToDto(savedEntity));
        } catch (Exception e) {
            log.error("Error while add recruiter : {}",recruiterDTO.getName(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<RecruiterDTO> getById(String id) {

        try {
            log.info("Get recruiter by id: {}",id);
            RecruiterEntity recruiterEntity = recruiterRepository.findById(id)
                    .orElseThrow(() -> {
                        log.error("Recruiter not found with this id: {}",id);
                        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Recruiter not found with id: " + id);
                    });
            return ResponseEntity.ok(recruiterMapper.entityToDto(recruiterEntity));
        } catch (Exception e) {
            log.error("Error while getting the id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<RecruiterDTO> updateById(String id, RecruiterDTO recruiterDTO) {

        try {
            log.info("Update Recruiter details by id: {}",id);
            RecruiterEntity existingEntity = recruiterRepository.findById(id)
                    .orElseThrow(() ->{
                        log.error("Recruiter is not found with this id:{}", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Recruiter not found with id: " + id);
                    });
            recruiterMapper.updateEntityFromDto(recruiterDTO, existingEntity);
            log.info("Recruiter details updated with this id:{}",id);
            RecruiterEntity savedEntity = recruiterRepository.save(existingEntity);
            return ResponseEntity.ok(recruiterMapper.entityToDto(savedEntity));
        } catch (Exception e) {
            log.error("Error while updating the recruiter with this id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<String> deleteById(String id) {

        try {
            log.info("Deleting recruiter with id: {}",id);
            RecruiterEntity recruiterEntity = recruiterRepository.findById(id)
                    .orElseThrow(() ->{
                          return   new ResponseStatusException(HttpStatus.NOT_FOUND, "Recruiter not found with id: " + id);
                    });
            recruiterRepository.delete(recruiterEntity);
            log.info("Recruiter successfully deleted with this id: {}",id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error while deleting the recruiter with id: {}",id, e  );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<RecruiterDTO>> getAll() {

        try {
            log.info("get all recruiters");
            List<RecruiterDTO> dtos = recruiterRepository.findAll().stream()
                    .map(recruiterMapper::entityToDto)
                    .collect(Collectors.toList());
            log.info("Total recruiters found: {}",dtos.size());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            log.error("Error while getting all the recruiters",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
