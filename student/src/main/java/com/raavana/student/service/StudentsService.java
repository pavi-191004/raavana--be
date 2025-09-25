package com.raavana.student.service;

import com.raavana.student.entity.StudentsEntity;
import com.raavana.student.model.SkillDTO;
import com.raavana.student.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentsRepository studentsRepository;

    //404 NotFound
    public ResponseEntity<SkillDTO> put(String id, SkillDTO skillDTO) {

        try {
            //400 bad request
            if (id == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            StudentsEntity studentEntity = studentsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found"));
            studentEntity.setTechnicalSkills(skillDTO.getTechnicalSkills());
            studentEntity.setSoftSkills(skillDTO.getSoftSkills());
            studentEntity.setHobbies(skillDTO.getHobbies());

            StudentsEntity savedEntity = studentsRepository.save(studentEntity);

            SkillDTO dto = new SkillDTO();
            dto.setId(savedEntity.getId());
            dto.setTechnicalSkills(savedEntity.getTechnicalSkills());
            dto.setSoftSkills(savedEntity.getSoftSkills());
            dto.setHobbies(savedEntity.getHobbies());

            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}





