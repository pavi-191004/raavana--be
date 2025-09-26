package com.raavana.admin.controller;

import com.raavana.admin.api.PersonalinfoApi;
import com.raavana.admin.model.PersonalInfo;
import com.raavana.admin.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal")
@RequiredArgsConstructor
public class PersonalController implements PersonalinfoApi {

    private final PersonalService personalService;

    @Override
    public ResponseEntity<PersonalInfo> personalinfoPost(PersonalInfo body) {
        return personalService.personalPost(body);
    }
}
