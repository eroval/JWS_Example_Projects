package com.informatics.cscb869f2022week5.data.repository;

import com.informatics.cscb869f2022week5.data.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
