package com.informatics.cscb869f2022week5.services;

import com.informatics.cscb869f2022week5.data.entity.School;
import com.informatics.cscb869f2022week5.data.entity.Teacher;
import com.informatics.cscb869f2022week5.dto.CreateSchoolDTO;
import com.informatics.cscb869f2022week5.dto.SchoolDTO;
import com.informatics.cscb869f2022week5.dto.UpdateSchoolDTO;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

public interface SchoolService {
    List<SchoolDTO> getSchools();

    SchoolDTO getSchool(long id);

    School create(CreateSchoolDTO createSchoolDTO );

    School updateSchool(long id, UpdateSchoolDTO updateSchoolDTO );

    void deleteSchool(long id);

    List<SchoolDTO> getSchoolsByMaxNumberOfStudents(int maxNumberOfStudents);

    List<SchoolDTO> getSchoolsByName(String name);

    List<SchoolDTO> getSchoolsByNameAndMaxNumberOfStudents(String name, int maxStudents);

    List<SchoolDTO> getAllHighSchools();

    List<Teacher> getAllTeachersBySchoolId(long id);

    List<SchoolDTO> getSchoolsByNameContainingOrderByName(String substringName);

    List<SchoolDTO> getSchoolsByNameContainingOrderByNameDesc(String substringName);

    List<SchoolDTO> findAllByNameStartsWith(String startName);

    List<SchoolDTO> findAllByNameStartsWithDesc(String startName);

    List<SchoolDTO> getSchoolsSortedBy(String sortedBy, Sort.Direction direction);

    List<SchoolDTO> getSchoolsByMaxNumberOfStudentsGreaterThanEqual(int maxStudents, int page, int size);

    List<SchoolDTO> getSchoolsByNameAndFoundationDate(String name, LocalDate foundationDate);

    List<SchoolDTO> getSchoolsByNameAndIsHighSchool(String schoolName, boolean isHighSchool);
}
