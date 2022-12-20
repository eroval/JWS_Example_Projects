package com.informatics.cscb869.web.api;

import com.informatics.cscb869.data.entity.School;
import com.informatics.cscb869.data.entity.Teacher;
import com.informatics.cscb869.dto.CreateSchoolDTO;
import com.informatics.cscb869.dto.SchoolDTO;
import com.informatics.cscb869.dto.UpdateSchoolDTO;
import com.informatics.cscb869.services.SchoolService;
import com.informatics.cscb869.web.view.model.CreateSchoolViewModel;
import com.informatics.cscb869.web.view.model.SchoolViewModel;
import com.informatics.cscb869.web.view.model.UpdateSchoolViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/schools")
@AllArgsConstructor
public class SchoolApiController {

    private final SchoolService schoolService;

    private final ModelMapper modelMapper;

    @GetMapping
    public List<SchoolDTO> getSchools() {
        return schoolService.getSchools();
    }

    @RequestMapping("/{id}")
    public SchoolDTO getSchool(@PathVariable("id") int id) {
        return schoolService.getSchool(id);
    }

    @PostMapping
    public School createSchool(@RequestBody CreateSchoolViewModel school) {
        return schoolService.create(modelMapper.map(school, CreateSchoolDTO.class));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public School updateSchool(@PathVariable("id") long id, @RequestBody UpdateSchoolViewModel school) {
        return schoolService.updateSchool(id, modelMapper.map(school, UpdateSchoolDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSchool(@PathVariable long id) {
        schoolService.deleteSchool(id);
    }

    @RequestMapping("/max-students/{maxStudents}")
    public List<SchoolViewModel> getSchoolsByMaxNumberOfStudents(@PathVariable int maxStudents) {
        return schoolService.getSchoolsByMaxNumberOfStudents(maxStudents)
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
    }

    @RequestMapping("/names/{name}")
    public List<SchoolViewModel> getSchoolsByMaxNumberOfStudents(@PathVariable String name) {
        return schoolService.getSchoolsByName(name)
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
    }

    @RequestMapping("/names/{name}/max-students/{maxStudents}")
    public List<SchoolViewModel> getSchoolsByMaxNumberOfStudents(@PathVariable String name, @PathVariable int maxStudents) {
        return schoolService.getSchoolsByNameAndMaxNumberOfStudents(name, maxStudents)
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
    }

    @RequestMapping("/highschools")
    public List<SchoolViewModel> getHighSchools() {
        return schoolService.getAllHighSchools()
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
    }

    @RequestMapping("/{id}/teachers")
    public List<Teacher> getSchoolTeachers(@PathVariable long id) {
        return schoolService.getAllTeachersBySchoolId(id);
    }

    // Sorting using Order By Asc
    @RequestMapping("/name-containing/{substringName}")
    public List<SchoolViewModel> getSchoolsByNameContainingOrderByName(@PathVariable String substringName) {
        return schoolService.getSchoolsByNameContainingOrderByName(substringName)
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
    }

    // Sorting using Order By Desc
    @RequestMapping("/name-containing/{substringName}/desc")
    public List<SchoolViewModel> getSchoolsByNameContainingOrderByNameDesc(@PathVariable String substringName) {
        return schoolService.getSchoolsByNameContainingOrderByNameDesc(substringName)
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
    }

    // Sorting using Sort object
    @RequestMapping("/name-start/{startName}")
    public List<SchoolViewModel> getSchoolsByStartName(@PathVariable String startName) {
        return schoolService.findAllByNameStartsWith(startName)
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
    }

    // Sorting using Sort object
    @RequestMapping("/name-start/{startName}/desc")
    public List<SchoolViewModel> getSchoolsByStartNameDesc(@PathVariable String startName) {

        return schoolService.findAllByNameStartsWithDesc(startName)
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
    }

    // Sorting using Sort object
    @RequestMapping("/sorted-by/{sortedBy}/direction/{direction}")
    public List<SchoolViewModel> getSchoolsSortedBy(@PathVariable String sortedBy, @PathVariable String direction) {
        return schoolService.getSchoolsSortedBy(sortedBy, Sort.Direction.fromString(direction))
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
    }

    // Pagination using Pageable
    @RequestMapping("/max-students-greater-than-equal/{maxStudents}/page/{page}/size/{size}")
    public List<SchoolViewModel> getSchoolsWithMaxNumberOfStudentsGreaterThanEqual(
            @PathVariable int maxStudents, @PathVariable int page, @PathVariable int size) {
        return schoolService.getSchoolsByMaxNumberOfStudentsGreaterThanEqual(maxStudents, page, size)
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
    }

//    // Soft Deletion
//    @PutMapping("/soft-delete/{id}")
//    public void softDeleteSchool(@PathVariable long id) {
//        School school = schoolService.getSchool(id);
//        school.setDeleted(1);
//        schoolService.updateSchool(id, school);
//    }

    private SchoolViewModel convertToSchoolViewModel(SchoolDTO schoolDTO) {
        return modelMapper.map(schoolDTO, SchoolViewModel.class);
    }

}
