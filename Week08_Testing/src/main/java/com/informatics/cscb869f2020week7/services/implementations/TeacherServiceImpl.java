package com.informatics.cscb869f2020week7.services.implementations;

import com.informatics.cscb869f2020week7.data.entity.School;
import com.informatics.cscb869f2020week7.data.entity.Teacher;
import com.informatics.cscb869f2020week7.data.repository.TeacherRepository;
import com.informatics.cscb869f2020week7.dto.CreateTeacherDTO;
import com.informatics.cscb869f2020week7.dto.SchoolDTO;
import com.informatics.cscb869f2020week7.dto.TeacherSchoolDTO;
import com.informatics.cscb869f2020week7.services.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    public List<TeacherSchoolDTO> getAllTeachersSchools() {
        return teacherRepository.findAll().stream()
                .map(this::convertToTeacherSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Teacher create(CreateTeacherDTO teacher) {
        return teacherRepository.save(modelMapper.map(teacher, Teacher.class));
    }


    private TeacherSchoolDTO convertToTeacherSchoolDTO(Teacher teacher) {
        return modelMapper.map(teacher, TeacherSchoolDTO.class);
    }

}
