package com.informatics.cscb869f2020week11SpringInside.data.repository;

import com.informatics.cscb869f2020week11SpringInside.data.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
