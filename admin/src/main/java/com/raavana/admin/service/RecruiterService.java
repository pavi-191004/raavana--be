package com.raavana.admin.service;


import com.raavana.admin.entity.RecruiterEntity;
import com.raavana.admin.mapper.RecruiterMapper;
import com.raavana.admin.model.RecruiterDTO;
import com.raavana.admin.repository.RecruiterRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;
    private final RecruiterMapper recruiterMapper;

    public ResponseEntity<RecruiterDTO> add(RecruiterDTO recruiterDTO) {

        try {
            RecruiterEntity recruiterEntity = recruiterMapper.dtoToEntity(recruiterDTO);
            RecruiterEntity savedEntity = recruiterRepository.save(recruiterEntity);

            return ResponseEntity.status(HttpStatus.CREATED).body(recruiterMapper.entityToDto(savedEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<RecruiterDTO> getById(String id) {

        try {
            RecruiterEntity recruiterEntity = recruiterRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recruiter not found with id: " + id));

            return ResponseEntity.ok(recruiterMapper.entityToDto(recruiterEntity));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<RecruiterDTO> updateById(String id, RecruiterDTO recruiterDTO) {

        try {
            RecruiterEntity existingEntity = recruiterRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recruiter not found with id: " + id));

            //  Update only fields from DTO — keeps same entity reference
            recruiterMapper.updateEntityFromDto(recruiterDTO, existingEntity);

            RecruiterEntity savedEntity = recruiterRepository.save(existingEntity);


            return ResponseEntity.ok(recruiterMapper.entityToDto(savedEntity));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<String> deleteById(String id) {

        try {
            RecruiterEntity recruiterEntity = recruiterRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recruiter not found with id: " + id));

            recruiterRepository.delete(recruiterEntity);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<RecruiterDTO>> getAll() {

        try {
            List<RecruiterDTO> dtos = recruiterRepository.findAll().stream()
                    .map(recruiterMapper::entityToDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtos);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
