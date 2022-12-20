package com.informatics.cscb869f2020week7.services;

import com.informatics.cscb869f2020week7.data.entity.Teacher;
import com.informatics.cscb869f2020week7.dto.CreateTeacherDTO;
import com.informatics.cscb869f2020week7.dto.TeacherSchoolDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherSchoolDTO> getAllTeachersSchools();

    Teacher create(CreateTeacherDTO teacher);
}
