package com.informatics.cscb869f2020week4.data.repository;

import com.informatics.cscb869f2020week4.data.entity.School;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {

    List<School> findAllByMaxNumberOfStudents(int maxNumberOfStudents);

    List<School> findAllByName(String name);

    List<School> findAllByNameAndMaxNumberOfStudents(String name, int maxStudents);

    // Sorting using Order By
    List<School> findAllByNameContainingOrderByName(String substringName);

    // Sorting using Order By Desc
    List<School> findAllByNameContainingOrderByNameDesc(String substringName);

    // Sorting using Sort object
    List<School> findAllByNameStartsWith(String startName, Sort sort);

    // Pagination using Pageable object
    List<School> findAllByMaxNumberOfStudentsGreaterThanEqual(int maxNumberOfStudents, Pageable pageable);

    // Using Query Annotation
    @Query("SELECT s FROM School s WHERE s.isHighSchool = true")
    List<School> findAllHighSchools();
}
