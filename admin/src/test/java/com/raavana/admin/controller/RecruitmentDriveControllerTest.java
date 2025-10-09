package com.raavana.admin.controller;

import com.raavana.admin.model.RecruitmentDrivesDTO;
import com.raavana.admin.service.RecruitmentDriveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecruitmentDriveControllerTest {

    @Mock
    private RecruitmentDriveService service;

    @InjectMocks
    private RecruitmentDriveController controller;

    private RecruitmentDrivesDTO drive1;
    private RecruitmentDrivesDTO drive2;

    @BeforeEach
    void setUp() {
        drive1 = new RecruitmentDrivesDTO();
        drive1.setId("1");
        drive1.setTitleOfTheDrive("Drive1");

        drive2 = new RecruitmentDrivesDTO();
        drive2.setId("2");
        drive2.setTitleOfTheDrive("Drive2");
    }

    @Test
    void shouldReturnAllDrives() {
        when(service.getAllRecruitmentDrives())
                .thenReturn(ResponseEntity.ok(Arrays.asList(drive1, drive2)));

        ResponseEntity<List<RecruitmentDrivesDTO>> response = controller.getAll();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).containsExactly(drive1, drive2);
        verify(service).getAllRecruitmentDrives();
    }

    @Test
    void shouldReturnDriveById() {
        when(service.getRecruitmentDriveById("1")).thenReturn(ResponseEntity.ok(drive1));

        ResponseEntity<RecruitmentDrivesDTO> response = controller.getById("1");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(drive1);
        verify(service).getRecruitmentDriveById("1");
    }

    @Test
    void shouldCreateDrive() {
        when(service.createRecruitmentDrive(drive1))
                .thenReturn(ResponseEntity.status(HttpStatus.CREATED).body("Recruitment Drive Created successfully"));

        ResponseEntity<String> response = controller.add(drive1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo("Recruitment Drive Created successfully");
        verify(service).createRecruitmentDrive(drive1);
    }

    @Test
    void shouldUpdateDrive() {
        when(service.updateRecruitmentDrive("1", drive1))
                .thenReturn(ResponseEntity.ok("Recruitment Drive Updated successfully"));

        ResponseEntity<String> response = controller.updateById("1", drive1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Recruitment Drive Updated successfully");
        verify(service).updateRecruitmentDrive("1", drive1);
    }

    @Test
    void shouldDeleteDrive() {
        when(service.deleteRecruitmentDrive("1"))
                .thenReturn(ResponseEntity.ok("Recruitment Drive Deleted Successfully"));

        ResponseEntity<String> response = controller.deleteById("1");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Recruitment Drive Deleted Successfully");
        verify(service).deleteRecruitmentDrive("1");
    }

    @Test
    void shouldReturnAllCompanies() {
        List<String> companies = List.of("Google", "Amazon");
        when(service.getAllCompanies()).thenReturn(companies);

        ResponseEntity<List<String>> response = controller.getCompanies();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).containsExactly("Google", "Amazon");
        verify(service).getAllCompanies();
    }
}
