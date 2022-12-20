package com.informatics.cscb869f2020week2.data.repository;

import com.informatics.cscb869f2020week2.data.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {

    List<School> findAllByMaxNumberOfStudents(int maxNumberOfStudents);

    List<School> findAllByName(String name);

    List<School> findAllByNameAndMaxNumberOfStudents(String name, int maxstudents);

    @Query("SELECT s FROM School s WHERE s.isHighSchool = true")
    List<School> findAllHighSchools();
}
