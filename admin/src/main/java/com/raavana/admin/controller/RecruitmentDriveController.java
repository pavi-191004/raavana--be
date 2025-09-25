package com.raavana.admin.controller;

import com.raavana.admin.api.DrivesApi;
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
public class RecruitmentDriveController implements DrivesApi {

    private final RecruitmentDriveService recruitmentDriveService;

    @Override
    public ResponseEntity<List<RecruitmentDrivesDTO>> drivesGet() {
        return recruitmentDriveService.recruitmentDrivesGet();
    }

    @Override
    public ResponseEntity<String> drivesIdDelete(String id) {
        return recruitmentDriveService.recruitmentDrivesIdDelete(id);
    }

    @Override
    public ResponseEntity<RecruitmentDrivesDTO> drivesIdGet(String id) {
        return recruitmentDriveService.recruitmentDrivesIdGet(id);
    }

    @Override
    public ResponseEntity<String> drivesIdPut(String id, RecruitmentDrivesDTO body) {
        return recruitmentDriveService.recruitmentDrivesIdPut(id, body);
    }

    @Override
    public ResponseEntity<String> drivesPost(RecruitmentDrivesDTO body) {
        return recruitmentDriveService.recruitmentDrivesPost(body);
    }
}
