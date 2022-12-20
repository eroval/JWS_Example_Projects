package com.informatics.cscb869f2020week4.data.repository;

import com.informatics.cscb869f2020week4.data.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
