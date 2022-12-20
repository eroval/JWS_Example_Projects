package com.informatics.cscb869f2020week4.controllers.api;

import com.informatics.cscb869f2020week4.data.entity.School;
import com.informatics.cscb869f2020week4.data.entity.Teacher;
import com.informatics.cscb869f2020week4.services.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
@AllArgsConstructor
public class SchoolApiController {

    private final SchoolService schoolService;

    @GetMapping
    public List<School> getSchools() {
        return schoolService.getSchools();
    }

    @RequestMapping("/{id}")
    public School getSchool(@PathVariable("id") int id) {
        return schoolService.getSchool(id);
    }

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolService.create(school);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public School createSchool(@RequestBody School school) {
//        return schoolService.create(school);
//    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public School updateSchool(@PathVariable("id") long id, @RequestBody School school) {
        return schoolService.updateSchool(id, school);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSchool(@PathVariable long id) {
        schoolService.deleteSchool(id);
    }

    @RequestMapping("/max-students/{maxStudents}")
    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable int maxStudents) {
        return schoolService.getSchoolsByMaxNumberOfStudents(maxStudents);
    }

    @RequestMapping("/names/{name}")
    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable String name) {
        return schoolService.getSchoolsByName(name);
    }

    @RequestMapping("/names/{name}/max-students/{maxStudents}")
    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable String name, @PathVariable int maxStudents) {
        return schoolService.getSchoolsByNameAndMaxNumberOfStudents(name, maxStudents);
    }

    @RequestMapping("/highschools")
    public List<School> getHighSchools() {
        return schoolService.getAllHighSchools();
    }

    @RequestMapping("/{id}/teachers")
    public List<Teacher> getSchoolTeachers(@PathVariable long id) {
        return schoolService.getAllTeachersBySchoolId(id);
    }

    // Sorting using Order By Asc
    @RequestMapping("/name-containing/{substringName}")
    public List<School> getSchoolsByNameContainingOrderByName(@PathVariable String substringName) {
        return schoolService.getSchoolsByNameContainingOrderByName(substringName);
    }

    // Sorting using Order By Desc
    @RequestMapping("/name-containing/{substringName}/desc")
    public List<School> getSchoolsByNameContainingOrderByNameDesc(@PathVariable String substringName) {
        return schoolService.getSchoolsByNameContainingOrderByNameDesc(substringName);
    }

    // Sorting using Sort object
    @RequestMapping("/name-start/{startName}")
    public List<School> getSchoolsByStartName(@PathVariable String startName) {
        return schoolService.findAllByNameStartsWith(startName);
    }

    // Sorting using Sort object
    @RequestMapping("/name-start/{startName}/desc")
    public List<School> getSchoolsByStartNameDesc(@PathVariable String startName) {
        return schoolService.findAllByNameStartsWithDesc(startName);
    }

    // Sorting using Sort object
    @RequestMapping("/sorted-by/{sortedBy}/direction/{direction}")
    public List<School> getSchoolsSortedBy(@PathVariable String sortedBy, @PathVariable String direction) {
        return schoolService.getSchoolsSortedBy(sortedBy, Sort.Direction.fromString(direction));
    }

    // Pagination using Pageable
    @RequestMapping("/max-students-greater-than-equal/{maxStudents}/page/{page}/size/{size}")
    public List<School> getSchoolsWithMaxNumberOfStudentsGreaterThanEqual(
            @PathVariable int maxStudents, @PathVariable int page, @PathVariable int size) {
        return schoolService.getSchoolsByMaxNumberOfStudentsGreaterThanEqual(maxStudents, page, size);
    }

    // Soft Deletion
    @PutMapping("/soft-delete/{id}")
    public void softDeleteSchool(@PathVariable long id) {
        School school = schoolService.getSchool(id);
        school.setDeleted(1);
        schoolService.updateSchool(id, school);
    }
}
