package com.raavana.admin.service;

import com.raavana.admin.entity.RecruitmentDriveEntity;
import com.raavana.admin.model.*;
import com.raavana.admin.repository.RecruitmentDriveRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class RecruitmentDriveServiceTest {

    @Mock
    private RecruitmentDriveRepository recruitmentDriveRepository;

    @InjectMocks
    private RecruitmentDriveService recruitmentDriveService;

    private RecruitmentDriveEntity entity1;
    private RecruitmentDriveEntity entity2;
    private RecruitmentDrivesDTO dto1;
    private RecruitmentDrivesDTO dto2;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        RecruitmentDrivesDTOVenueDetails venueDetails = new RecruitmentDrivesDTOVenueDetails();
        venueDetails.setVenue("Computer Lab");
        venueDetails.setAddress("A101");
        venueDetails.setContact("Coordinator");

        RecruitmentDrivesDTOInterviewDetails interviewDetails = new RecruitmentDrivesDTOInterviewDetails();
        interviewDetails.setInterviewType("TECHNICAL");
        interviewDetails.setDuration("3 Mins");
        interviewDetails.setMode(RecruitmentDrivesDTOInterviewDetails.ModeEnum.VIRTUAL);

        List<RecruitmentDrivesDTOInterviewRounds> interviewRounds = new ArrayList<>();
        RecruitmentDrivesDTOInterviewRounds round1 = new RecruitmentDrivesDTOInterviewRounds();
        round1.setRoundName("Round 1");
        round1.setRoundDescription("Assessment round for 2 mins");
        RecruitmentDrivesDTOInterviewRounds round2 = new RecruitmentDrivesDTOInterviewRounds();
        round2.setRoundName("Round 2");
        round2.setRoundDescription("Technical HR round");
        interviewRounds.add(round1);
        interviewRounds.add(round2);

        entity1 = new RecruitmentDriveEntity();
        entity1.setId("1");
        entity1.setTitleOfTheDrive("Drive 1");
        entity1.setCompany("Amazon");
        entity1.setRoleOrDesignation("SOFTWARE_ENGINEER");
        entity1.setWorkLocation(RecruitmentDrivesDTO.WorkLocationEnum.ONSITE);
        entity1.setJobDescription("Job Desc 1");
        entity1.setDate(LocalDate.parse("10/10/2025", dateFormatter));
        entity1.setTime(LocalTime.parse("10:30 AM", timeFormatter));
        entity1.setEligibilityCriteria("B_TECH_CS");
        entity1.setVenueDetails(venueDetails);
        entity1.setInterviewDetails(interviewDetails);
        entity1.setInterviewRounds(interviewRounds);

        entity2 = new RecruitmentDriveEntity();
        entity2.setId("2");
        entity2.setTitleOfTheDrive("Drive 2");
        entity2.setCompany("Google");
        entity2.setRoleOrDesignation("QA_ENGINEER");
        entity2.setWorkLocation(RecruitmentDrivesDTO.WorkLocationEnum.REMOTE);
        entity2.setJobDescription("Job Desc 2");
        entity2.setDate(LocalDate.parse("10/12/2025", dateFormatter));
        entity2.setTime(LocalTime.parse("02:00 PM", timeFormatter));
        entity2.setEligibilityCriteria("CGPA 8.4+");
        entity2.setVenueDetails(venueDetails);
        entity2.setInterviewDetails(interviewDetails);
        entity2.setInterviewRounds(interviewRounds);

        dto1 = new RecruitmentDrivesDTO();
        dto1.setId("1");
        dto1.setTitleOfTheDrive("Drive 1");
        dto1.setCompany("Amazon");
        dto1.setRoleOrDesignation("SOFTWARE_ENGINEER");
        dto1.setWorkLocation(RecruitmentDrivesDTO.WorkLocationEnum.ONSITE);
        dto1.setJobDescription("Job Desc 1");
        dto1.setDate("10/10/2025");
        dto1.setTime("10:30 AM");
        dto1.setEligibilityCriteria("B_TECH_CS");
        dto1.setVenueDetails(venueDetails);
        dto1.setInterviewDetails(interviewDetails);
        dto1.setInterviewRounds(interviewRounds);

        dto2 = new RecruitmentDrivesDTO();
        dto2.setId("2");
        dto2.setTitleOfTheDrive("Drive 2");
        dto2.setCompany("Google");
        dto2.setRoleOrDesignation("QA_ENGINEER");
        dto2.setWorkLocation(RecruitmentDrivesDTO.WorkLocationEnum.REMOTE);
        dto2.setJobDescription("Job Desc 2");
        dto2.setDate("10/12/2025");
        dto2.setTime("02:00 PM");
        dto2.setEligibilityCriteria("CGPA 8.4+");
        dto2.setVenueDetails(venueDetails);
        dto2.setInterviewDetails(interviewDetails);
        dto2.setInterviewRounds(interviewRounds);
    }

    @Test
    void testGetAllRecruitmentDrives() {
        when(recruitmentDriveRepository.findAll()).thenReturn(Arrays.asList(entity1, entity2));

        ResponseEntity<List<RecruitmentDrivesDTO>> response = recruitmentDriveService.getAllRecruitmentDrives();

        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getTitleOfTheDrive()).isEqualTo("Drive 1");
        verify(recruitmentDriveRepository, times(1)).findAll();
    }

    @Test
    void testGetRecruitmentDriveById() {
        when(recruitmentDriveRepository.findById("1")).thenReturn(Optional.of(entity1));

        ResponseEntity<RecruitmentDrivesDTO> response = recruitmentDriveService.getRecruitmentDriveById("1");

        assertThat(response.getBody().getCompany()).isEqualTo("Amazon");
        verify(recruitmentDriveRepository, times(1)).findById("1");
    }

    @Test
    void testCreateRecruitmentDrive() {
        when(recruitmentDriveRepository.findByTitleOfTheDriveAndCompany(dto1.getTitleOfTheDrive(), dto1.getCompany()))
                .thenReturn(Optional.empty());
        when(recruitmentDriveRepository.save(any(RecruitmentDriveEntity.class))).thenReturn(entity1);

        ResponseEntity<String> response = recruitmentDriveService.createRecruitmentDrive(dto1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo("Recruitment Drive Created successfully!");
        verify(recruitmentDriveRepository, times(1)).save(any(RecruitmentDriveEntity.class));
    }

    @Test
    void testUpdateRecruitmentDrive() {
        when(recruitmentDriveRepository.findById("1")).thenReturn(Optional.of(entity1));
        when(recruitmentDriveRepository.save(any(RecruitmentDriveEntity.class))).thenReturn(entity1);

        ResponseEntity<String> response = recruitmentDriveService.updateRecruitmentDrive("1", dto1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Recruitment Drive Updated successfully!");
        verify(recruitmentDriveRepository, times(1)).save(any(RecruitmentDriveEntity.class));
    }

    @Test
    void testDeleteRecruitmentDrive() {
        when(recruitmentDriveRepository.findById("1")).thenReturn(Optional.of(entity1));

        ResponseEntity<String> response = recruitmentDriveService.deleteRecruitmentDrive("1");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Recruitment Drive Deleted Successfully!");
        verify(recruitmentDriveRepository, times(1)).delete(entity1);
    }
}
