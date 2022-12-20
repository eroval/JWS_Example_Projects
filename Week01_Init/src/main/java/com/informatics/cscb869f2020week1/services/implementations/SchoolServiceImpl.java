package com.informatics.cscb869f2020week1.services.implementations;

import com.informatics.cscb869f2020week1.data.entity.School;
import com.informatics.cscb869f2020week1.data.repository.SchoolRepository;
import com.informatics.cscb869f2020week1.services.SchoolService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    @Override
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }
}
