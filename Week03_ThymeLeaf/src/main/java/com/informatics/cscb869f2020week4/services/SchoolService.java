package com.informatics.cscb869f2020week4.services;

import com.informatics.cscb869f2020week4.data.entity.School;
import com.informatics.cscb869f2020week4.data.entity.Teacher;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface SchoolService {
    List<School> getSchools();

    School getSchool(long id);

    School create(School school);

    School updateSchool(long id, School school);

    void saveSchool(School school);

    void deleteSchool(long id);

    List<School> getSchoolsByMaxNumberOfStudents(int maxNumberOfStudents);

    List<School> getSchoolsByName(String name);

    List<School> getSchoolsByNameAndMaxNumberOfStudents(String name, int maxStudents);

    List<School> getAllHighSchools();

    List<Teacher> getAllTeachersBySchoolId(long id);

    List<School> getSchoolsByNameContainingOrderByName(String substringName);

    List<School> getSchoolsByNameContainingOrderByNameDesc(String substringName);

    List<School> findAllByNameStartsWith(String startName);

    List<School> findAllByNameStartsWithDesc(String startName);

    List<School> getSchoolsSortedBy(String sortedBy, Sort.Direction direction);

    List<School> getSchoolsByMaxNumberOfStudentsGreaterThanEqual(int maxStudents, int page, int size);

}
