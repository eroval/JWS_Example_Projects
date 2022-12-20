package com.informatics.cscb869f2020week9_school_consuming_service.api;

import com.informatics.cscb869f2020week9_school_consuming_service.dto.SchoolDTO;
import com.informatics.cscb869f2020week9_school_consuming_service.service.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/schools")
@AllArgsConstructor
public class SchoolApiController {

    private SchoolService schoolService;

    @GetMapping
    public List<SchoolDTO> getSchools() {
        return schoolService.getSchools();
    }

    @GetMapping("/schools-with-names-starting-with/{startingLetter}")
    public List<SchoolDTO> getSchoolsWithNamesStartingWith(@PathVariable String startingLetter) {
        return schoolService.getSchools()
                .stream()
                .filter(schoolDTO -> schoolDTO.getName().startsWith(startingLetter))
                .collect(Collectors.toList());
    }

}
