package com.raavana.thirdparty.controller;

import com.raavana.thirdparty.api.ApiApi;
import com.raavana.thirdparty.model.AdminTriggercredentialsBody;
import com.raavana.thirdparty.service.WorkOsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkOsController implements ApiApi {
    @Autowired
    WorkOsService workOsService;

    @Override
    public ResponseEntity<Void> apiAdminTriggerCredentialsPost(AdminTriggercredentialsBody body) {

        //Response From WorkOS
        ResponseEntity triggerUserApiResponse =  workOsService.triggerUserApi(body.getEmail());

        return triggerUserApiResponse;
    }


}

