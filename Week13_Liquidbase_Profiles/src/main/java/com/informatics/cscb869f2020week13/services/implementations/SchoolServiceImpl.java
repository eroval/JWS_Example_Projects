package com.informatics.cscb869f2020week13.services.implementations;

import com.informatics.cscb869f2020week13.data.entity.School;
import com.informatics.cscb869f2020week13.data.repository.SchoolRepository;
import com.informatics.cscb869f2020week13.services.Loggable;
import com.informatics.cscb869f2020week13.services.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    @Override
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchool(long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid school Id:" + id));
    }

    @Override
    public School create(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School updateSchool(long id, School school) {
        school.setId(id);
        return schoolRepository.save(school);
    }

    @Override
    public void deleteSchool(long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public List<School> getSchoolsByName(String name) {
        return schoolRepository.findAllByName(name);
    }

    @Override
    @Loggable
    public List<School> getAllHighschools() {
        return schoolRepository.findAllHighSchools();
    }

}
