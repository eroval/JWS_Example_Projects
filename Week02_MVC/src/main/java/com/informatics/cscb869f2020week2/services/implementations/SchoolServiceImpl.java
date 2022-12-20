package com.informatics.cscb869f2020week2.services.implementations;

import com.informatics.cscb869f2020week2.data.entity.School;
import com.informatics.cscb869f2020week2.data.entity.Teacher;
import com.informatics.cscb869f2020week2.data.repository.SchoolRepository;
import com.informatics.cscb869f2020week2.services.SchoolService;
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
        //Optional<School> school = schoolRepository.findById(id);
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
//        School school = schoolRepository.findById(id).orElseThrow(()
//                -> new IllegalArgumentException("Invalid school Id:" + id));
        schoolRepository.deleteById(id);
       // return
    }

    @Override
    public List<School> getSchoolsByMaxNumberOfStudents(int maxNumberOfStudents) {
        return schoolRepository.findAllByMaxNumberOfStudents(maxNumberOfStudents);
    }

    @Override
    public List<School> getSchoolsByName(String name) {
        return schoolRepository.findAllByName(name);
    }

    @Override
    public List<School> getSchoolsByNameAndMaxNumberOfStudents(String name, int maxstudents) {
        return schoolRepository.findAllByNameAndMaxNumberOfStudents(name, maxstudents);
    }

    @Override
    public List<School> getAllHighSchools() {
        return schoolRepository.findAllHighSchools();
    }

    @Override
    public List<Teacher> getAllTeachersBySchoolId(long id) {
        School school = getSchool(id);
        return school.getTeachers();
    }

}
