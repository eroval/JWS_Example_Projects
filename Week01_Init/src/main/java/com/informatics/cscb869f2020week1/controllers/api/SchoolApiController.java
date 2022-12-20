package com.informatics.cscb869f2020week1.controllers.api;

import com.informatics.cscb869f2020week1.data.entity.School;
import com.informatics.cscb869f2020week1.services.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SchoolApiController {

    private final SchoolService schoolService;

    @GetMapping(value="/api/schools")
    public List<School> getSchools() {
        return schoolService.getSchools();
    }
}
