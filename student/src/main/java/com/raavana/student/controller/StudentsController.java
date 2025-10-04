package com.raavana.student.controller;

import com.raavana.student.api.SkillApi;
import com.raavana.student.model.SkillDTO;
import com.raavana.student.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skill")
@RequiredArgsConstructor
public class StudentsController implements SkillApi {

    private final StudentsService studentsService;

    @Override
    public ResponseEntity<SkillDTO> skillIdPut(String id, SkillDTO body) {
        return studentsService.put(id,body);
    }
}
