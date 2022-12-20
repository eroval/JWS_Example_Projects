package com.informatics.cscb869f2020week1.services;

import com.informatics.cscb869f2020week1.data.entity.School;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SchoolService {
    List<School> getSchools();
}
