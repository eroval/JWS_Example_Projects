package com.informatics.cscb869f2020week13.services;

import com.informatics.cscb869f2020week13.data.entity.School;

import java.util.List;

public interface SchoolService {
    List<School> getSchools();

    School getSchool(long id);

    School create(School school);

    School updateSchool(long id, School school);

    void deleteSchool(long id);

    List<School> getSchoolsByName(String name);

    List<School> getAllHighschools();
}
