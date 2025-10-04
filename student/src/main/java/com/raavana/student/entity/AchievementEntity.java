package com.raavana.student.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "achievements")
public class AchievementEntity {



    @Id
    private String id;
    private String title;
    private String event;
    private LocalDate eventDate;
    private String awardedBy;
    private String description;
}

