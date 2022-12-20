package com.informatics.cscb869f2021week11.api;

import com.informatics.cscb869f2021week11.dto.SchoolDTO;
import com.informatics.cscb869f2021week11.service.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
@AllArgsConstructor
public class SchoolApiController {
    private final SchoolService schoolService;

    @GetMapping
    public List<SchoolDTO> getSchools() {
        return schoolService.getSchools();
    }

    @GetMapping(value="/token")
    public String getToken(@AuthenticationPrincipal Jwt jwt) {
        return jwt.getTokenValue();
    }

}
