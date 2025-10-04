package com.raavana.admin.entity;
import com.raavana.admin.model.RecruitmentDrivesDTO;
import com.raavana.admin.model.RecruitmentDrivesDTOInterviewDetails;
import com.raavana.admin.model.RecruitmentDrivesDTOInterviewRounds;
import com.raavana.admin.model.RecruitmentDrivesDTOVenueDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "recruitment")
public class RecruitmentDriveEntity{
        @Id
        private String id;
        private String titleOfTheDrive;
        private RecruitmentDrivesDTO.CompanyEnum company;
        private String roleOrDesignation;
        private RecruitmentDrivesDTO.WorkLocationEnum workLocation;
        private String jobDescription;
        private String date;
        private String time;
        private String eligibilityCriteria;
        private RecruitmentDrivesDTOVenueDetails venueDetails;
        private RecruitmentDrivesDTOInterviewDetails interviewDetails;
        private List<RecruitmentDrivesDTOInterviewRounds> interviewRounds;
        private String createdAt;
        private String createdBy;
        private String updatedAt;
        private String updatedBy;
}

