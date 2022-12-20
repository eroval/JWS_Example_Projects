package com.informatics.cscb869f2020week2.data.repository;

import com.informatics.cscb869f2020week2.data.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
