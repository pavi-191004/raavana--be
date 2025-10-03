package com.raavana.admin.controller;

import com.raavana.admin.api.OrganizationinfoApi;
import com.raavana.admin.model.OrganizationInfo;
import com.raavana.admin.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organization")
public class OrganizationController implements OrganizationinfoApi {

    private final OrganizationService organizationService;

    @Override
    public ResponseEntity<OrganizationInfo> organizationinfoPost(OrganizationInfo body) {
        return organizationService.organizationPost(body);
    }
}
