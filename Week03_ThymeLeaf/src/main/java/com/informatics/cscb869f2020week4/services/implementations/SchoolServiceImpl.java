package com.informatics.cscb869f2020week4.services.implementations;

import com.informatics.cscb869f2020week4.data.entity.School;
import com.informatics.cscb869f2020week4.data.entity.Teacher;
import com.informatics.cscb869f2020week4.data.repository.SchoolRepository;
import com.informatics.cscb869f2020week4.services.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public void deleteSchool(long id) {
        schoolRepository.deleteById(id);
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

    @Override
    public List<School> getSchoolsByNameContainingOrderByName(String substringName) {
        return schoolRepository.findAllByNameContainingOrderByName(substringName);
    }

    @Override
    public List<School> getSchoolsByNameContainingOrderByNameDesc(String substringName) {
        return schoolRepository.findAllByNameContainingOrderByNameDesc(substringName);
    }

    @Override
    public List<School> findAllByNameStartsWith(String startName) {
        return schoolRepository.findAllByNameStartsWith(startName, Sort.by("name"));
    }

    @Override
    public List<School> findAllByNameStartsWithDesc(String startName) {
        return schoolRepository.findAllByNameStartsWith(
                startName, Sort.by(Sort.Direction.DESC, "name"));
    }

    @Override
    public List<School> getSchoolsSortedBy(String sortedBy, Sort.Direction direction) {
        return schoolRepository.findAll(Sort.by(direction, sortedBy));
    }

    @Override
    public List<School> getSchoolsByMaxNumberOfStudentsGreaterThanEqual(int maxStudents, int page, int size) {
        // return schoolRepository.findAllByMaxNumberOfStudentsGreaterThanEqual(maxStudents, Pageable.unpaged());
        // return schoolRepository.findAllByMaxNumberOfStudentsGreaterThanEqual(maxStudents, PageRequest.of(0,4));
        return schoolRepository.findAllByMaxNumberOfStudentsGreaterThanEqual(
                maxStudents, PageRequest.of(page, size, Sort.by("name")));
    }

}
