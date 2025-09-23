package com.raavana.thirdparty.service;

import com.workos.WorkOS;
import com.workos.usermanagement.builders.CreateUserOptionsBuilder;
import com.workos.usermanagement.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WorkOsService{
    public ResponseEntity triggerUserApi(String userEmail){

        WorkOS workos = new WorkOS("sk_test_a2V5XzAxSzU0RTVGMTlDUjJNMFRYUEI5WjU5R1FaLHhFNU9xVW55a0sxaWZZQTdiY3NkVGE2a2s");
        try {

            // Trigerring WorkOS User Creation API
            User user = workos.userManagement.createUser(
                    new CreateUserOptionsBuilder(userEmail).build());

            System.out.println("user created successfully");

            //Response with 204 status code
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {

            e.printStackTrace();

            //Response with 503 status code
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
