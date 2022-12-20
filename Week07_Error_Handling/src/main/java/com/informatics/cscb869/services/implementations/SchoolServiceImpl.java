package com.informatics.cscb869.services.implementations;

import com.informatics.cscb869.dto.CreateSchoolDTO;
import com.informatics.cscb869.dto.SchoolDTO;
import com.informatics.cscb869.dto.SchoolTeachersDTO;
import com.informatics.cscb869.dto.UpdateSchoolDTO;
import com.informatics.cscb869.data.entity.School;
import com.informatics.cscb869.data.entity.Teacher;
import com.informatics.cscb869.data.repository.SchoolRepository;
import com.informatics.cscb869.services.SchoolService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<SchoolDTO> getSchools() {
        return schoolRepository.findAll().stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SchoolDTO> getSchoolsSortedByName(String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by(Sort.Direction.DESC, "name") : Sort.by("name");
        return schoolRepository.findAll(sort).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<SchoolDTO> getSchoolsPagination(Pageable pageable) {
        List<SchoolDTO> schoolList = schoolRepository.findAll()
                .stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
        int page = pageable.getPageNumber();
        int size = pageable.getPageSize();
        int firstSchoolNumber = page * size;

        List<SchoolDTO> schoolPageList;

        if (schoolList.size() < firstSchoolNumber) {
            schoolPageList = Collections.emptyList();
        } else {
            int toIndex = Math.min(firstSchoolNumber + size, schoolList.size());
            schoolPageList = schoolList.subList(firstSchoolNumber, toIndex);
        }

        Page<SchoolDTO> pageOfSchools
                = new PageImpl<SchoolDTO>(schoolPageList, PageRequest.of(page, size), schoolList.size());

        return pageOfSchools;

    }

    @Override
    public SchoolDTO getSchool(@Min(1) long id) {
        return modelMapper.map(schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid school Id:" + id)), SchoolDTO.class);
    }

    @Override
    public School create(@Valid CreateSchoolDTO createSchoolDTO) {
        return schoolRepository.save(modelMapper.map(createSchoolDTO, School.class));
    }

    @Override
    public School updateSchool(long id, UpdateSchoolDTO updateSchoolDTO) {
        School school = modelMapper.map(updateSchoolDTO, School.class);
        school.setId(id);
        return schoolRepository.save(school);
    }

    @Override
    public void deleteSchool(long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public List<SchoolDTO> getSchoolsByMaxNumberOfStudents(int maxNumberOfStudents) {
        return schoolRepository.findAllByMaxNumberOfStudents(maxNumberOfStudents).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SchoolDTO> getSchoolsByName(String name) {
        return schoolRepository.findAllByName(name).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SchoolDTO> getSchoolsByNameAndMaxNumberOfStudents(String name, int maxStudents) {

        return schoolRepository.findAllByNameAndMaxNumberOfStudents(name, maxStudents).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SchoolDTO> getAllHighSchools() {

        return schoolRepository.findAllHighSchools().stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Teacher> getAllTeachersBySchoolId(long id) {
        SchoolTeachersDTO school = modelMapper.map(getSchool(id), SchoolTeachersDTO.class);
        return school.getTeachers();
    }

    @Override
    public List<SchoolDTO> getSchoolsByNameContainingOrderByName(String substringName) {
        return schoolRepository.findAllByNameContainingOrderByName(substringName).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SchoolDTO> getSchoolsByNameContainingOrderByNameDesc(String substringName) {
        return schoolRepository.findAllByNameContainingOrderByNameDesc(substringName).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SchoolDTO> findAllByNameStartsWith(String startName) {
        return schoolRepository.findAllByNameStartsWith(startName, Sort.by("name")).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SchoolDTO> findAllByNameStartsWithDesc(String startName) {
        return schoolRepository.findAllByNameStartsWith(
                startName, Sort.by(Sort.Direction.DESC, "name")).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SchoolDTO> getSchoolsSortedBy(String sortedBy, Sort.Direction direction) {
        return schoolRepository.findAll(Sort.by(direction, sortedBy)).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SchoolDTO> getSchoolsByMaxNumberOfStudentsGreaterThanEqual(int maxStudents, int page, int size) {
        return schoolRepository.findAllByMaxNumberOfStudentsGreaterThanEqual(
                maxStudents, PageRequest.of(page, size, Sort.by("name"))).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SchoolDTO> getSchoolsByNameAndFoundationDate(String name, LocalDate foundationDate) {
        return schoolRepository.findAllByNameAndFoundationDate(name, foundationDate).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SchoolDTO> getSchoolsByNameAndIsHighSchool(String schoolName, boolean isHighSchool) {
        return schoolRepository.findAllByNameAndIsHighSchool(schoolName, isHighSchool).stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    private SchoolDTO convertToSchoolDTO(School school) {
        return modelMapper.map(school, SchoolDTO.class);
    }
}
