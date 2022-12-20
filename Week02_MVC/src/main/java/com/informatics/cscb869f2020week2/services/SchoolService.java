package com.informatics.cscb869f2020week2.services;

import com.informatics.cscb869f2020week2.data.entity.School;
import com.informatics.cscb869f2020week2.data.entity.Teacher;

import java.util.List;

public interface SchoolService {
    List<School> getSchools();

    School getSchool(long id);

    School create(School school);

    School updateSchool(long id, School school);

    void deleteSchool(long id);

    List<School> getSchoolsByMaxNumberOfStudents(int maxNumberOfStudents);

    List<School> getSchoolsByName(String name);

    List<School> getSchoolsByNameAndMaxNumberOfStudents(String name, int maxstudents);

    List<School> getAllHighSchools();

    List<Teacher> getAllTeachersBySchoolId(long id);
}
