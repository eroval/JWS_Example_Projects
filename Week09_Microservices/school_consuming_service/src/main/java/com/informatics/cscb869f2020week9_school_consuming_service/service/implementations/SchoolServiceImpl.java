package com.informatics.cscb869f2020week9_school_consuming_service.service.implementations;

import com.informatics.cscb869f2020week9_school_consuming_service.api.SchoolClient;
import com.informatics.cscb869f2020week9_school_consuming_service.dto.SchoolDTO;
import com.informatics.cscb869f2020week9_school_consuming_service.service.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolClient schoolClient;

    @Override
    public List<SchoolDTO> getSchools() {
        return schoolClient.getSchools();
    }

    @Override
    public List<SchoolDTO> getSchoolsWithNamesStartingWith(String startingLetter) {
        return this.getSchools()
                .stream()
                .filter(schoolDTO -> schoolDTO.getName().startsWith(startingLetter))
                .collect(Collectors.toList());
    }
}
