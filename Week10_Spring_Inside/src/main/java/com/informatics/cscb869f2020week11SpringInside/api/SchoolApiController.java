package com.informatics.cscb869f2020week11SpringInside.api;

import com.informatics.cscb869f2020week11SpringInside.dto.SchoolDTO;
import com.informatics.cscb869f2020week11SpringInside.service.SchoolService;
import lombok.AllArgsConstructor;
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

}
