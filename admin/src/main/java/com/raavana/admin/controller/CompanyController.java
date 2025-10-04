package com.raavana.admin.controller;
import com.raavana.admin.api.CompanyApi;
import com.raavana.admin.model.CompanyDTO;
import com.raavana.admin.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController implements CompanyApi{

    private final CompanyService companyService;


    @Override
    public ResponseEntity<String> companyIdDelete(String id) {
        return companyService.companyIdDelete(id);
    }
    @Override
    public ResponseEntity<List<CompanyDTO>> companyGet() {
        return companyService.companyGet();
    }

    @Override
    public ResponseEntity<CompanyDTO> companyIdGet(String id) {
        return companyService.companyIdGet(id);
    }

    @Override
    public ResponseEntity<CompanyDTO> companyIdPut(String id, CompanyDTO body) {
        return companyService.companyIdPut(id,body);
    }

    @Override
    public ResponseEntity<CompanyDTO> companyPost(CompanyDTO body) {
        return companyService.companyPost(body);
    }
}






