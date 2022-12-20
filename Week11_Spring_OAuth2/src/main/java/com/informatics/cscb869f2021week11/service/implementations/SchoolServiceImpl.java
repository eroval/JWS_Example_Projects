package com.informatics.cscb869f2021week11.service.implementations;

import com.informatics.cscb869f2021week11.data.entity.School;
import com.informatics.cscb869f2021week11.data.repository.SchoolRepository;
import com.informatics.cscb869f2021week11.dto.SchoolDTO;
import com.informatics.cscb869f2021week11.service.SchoolService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<SchoolDTO> getSchools() {
        return schoolRepository.findAll().stream()
                .map(this::convertToSchoolDTO)
                .collect(Collectors.toList());
    }

    private SchoolDTO convertToSchoolDTO(School school) {
        return modelMapper.map(school, SchoolDTO.class);
    }

}
