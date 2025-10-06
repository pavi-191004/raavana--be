package com.raavana.admin.controller;

import com.raavana.admin.api.CompaniesApi;
import com.raavana.admin.api.RecruitmentDrivesApi;
import com.raavana.admin.model.RecruitmentDrivesDTO;
import com.raavana.admin.service.RecruitmentDriveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/recruitment")
@RequiredArgsConstructor
public class RecruitmentDriveController implements CompaniesApi, RecruitmentDrivesApi {

    private final RecruitmentDriveService recruitmentDriveService;

    @Override
    public ResponseEntity<RecruitmentDrivesDTO> getById(String id) {
        return recruitmentDriveService.getRecruitmentDriveById(id);
    }

    @Override
    public ResponseEntity<String> deleteById(String id) {
        return recruitmentDriveService.deleteRecruitmentDrive(id);
    }

    @Override
    public ResponseEntity<List<RecruitmentDrivesDTO>> getAll() {
        return recruitmentDriveService.getAllRecruitmentDrives();
    }
    @Override
    public ResponseEntity<String> updateById(String id, RecruitmentDrivesDTO body) {
        return recruitmentDriveService.updateRecruitmentDrive(id, body);
    }
    @Override
    public ResponseEntity<String> add(RecruitmentDrivesDTO body) {
        return recruitmentDriveService.createRecruitmentDrive(body);
    }
    @Override
    public ResponseEntity<List<String>> getCompanies() {
        return ResponseEntity.ok(recruitmentDriveService.getAllCompanies());
    }

}
