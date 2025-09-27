package com.raavana.thirdparty.controller;

import com.raavana.thirdparty.api.AdminApi;
import com.raavana.thirdparty.model.AdminTriggercredentialsBody;
import com.raavana.thirdparty.service.WorkOsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WorkOsController implements AdminApi {
    @Autowired
    WorkOsService workOsService;

    @Override
    public ResponseEntity<Void> adminTriggerCredentialsPost(AdminTriggercredentialsBody body) {

        //Response From WorkOS
        ResponseEntity triggerUserApiResponse =  workOsService.triggerUserApi(body.getEmail());

        return triggerUserApiResponse;
    }
    
}

