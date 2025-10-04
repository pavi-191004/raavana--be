package com.raavana.student.controller;



import com.raavana.student.api.AchievementsApi;
import com.raavana.student.model.AchievementDTO;
import com.raavana.student.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AchievementController implements AchievementsApi {

    private final AchievementService achievementService;

    @Override
    public ResponseEntity<String> achievementsAchievementIdDelete(String achievementId) {
        return ResponseEntity.ok(achievementService.studentIdDelete(achievementId));
    }

    @Override
    public ResponseEntity<AchievementDTO> achievementsAchievementIdGet(String achievementId) {
        return ResponseEntity.ok(achievementService.studentIdGet(achievementId));

    }

    @Override
    public ResponseEntity<AchievementDTO> achievementsAchievementIdPut(String achievementId, AchievementDTO body) {
        return ResponseEntity.ok(achievementService.studentIdPut(achievementId, body));
    }

    @Override
    public ResponseEntity<List<AchievementDTO>> achievementsGet() {
        return ResponseEntity.ok(achievementService.studentGet());

    }

    @Override
    public ResponseEntity<AchievementDTO> achievementsPost(AchievementDTO body) {
        return ResponseEntity.ok(achievementService.studentPost(body));
    }



}

