package com.informatics.cscb869.services;

import com.informatics.cscb869.dto.CreateTeacherDTO;
import com.informatics.cscb869.dto.TeacherSchoolDTO;
import com.informatics.cscb869.data.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<TeacherSchoolDTO> getAllTeachersSchools();

    Teacher create(CreateTeacherDTO teacher);
}
