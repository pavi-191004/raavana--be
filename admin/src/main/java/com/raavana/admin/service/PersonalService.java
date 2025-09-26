package com.raavana.admin.service;


import com.raavana.admin.entity.PersonalEntity;
import com.raavana.admin.model.PersonalInfo;
import com.raavana.admin.repository.PersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalService {
    private final PersonalRepository personalRepository;

    public ResponseEntity<PersonalInfo> personalPost(PersonalInfo personalInfo) {
        try {
            if (personalInfo.getFullName() == null || personalInfo.getFullName().isEmpty() ||
                    personalInfo.getDesignation() == null || personalInfo.getDesignation().isEmpty() ||
                    personalInfo.getContactNumber() == null ||
                    personalInfo.getRoleId() == null) {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            PersonalEntity personalEntity = PersonalEntity.builder()
                    .fullName(personalInfo.getFullName())
                    .designation(personalInfo.getDesignation())
                    .contactNumber(personalInfo.getContactNumber())
                    .roleId(personalInfo.getRoleId())
                    .build();

            PersonalEntity savedEntity = personalRepository.save(personalEntity);

            PersonalInfo savedInfo = new PersonalInfo();
            savedInfo.setFullName(savedEntity.getFullName());
            savedInfo.setDesignation(savedEntity.getDesignation());
            savedInfo.setContactNumber(savedEntity.getContactNumber());
            savedInfo.setRoleId(savedEntity.getRoleId());
            return ResponseEntity.ok(savedInfo);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}






