package com.informatics.cscb869f2021week11.data.repository;

import com.informatics.cscb869f2021week11.data.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
