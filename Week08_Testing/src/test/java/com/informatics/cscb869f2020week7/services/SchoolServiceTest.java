package com.informatics.cscb869f2020week7.services;

import com.informatics.cscb869f2020week7.data.entity.School;
import com.informatics.cscb869f2020week7.data.repository.SchoolRepository;
import com.informatics.cscb869f2020week7.dto.SchoolDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SchoolServiceTest {

    @MockBean
    private SchoolRepository schoolRepository;

    @Autowired
    private SchoolService schoolService;

    @Test
    void getSchoolById() {
        long schoolId = 1;

        School school = new School();
        school.setId(schoolId);

        Mockito.when(schoolRepository.findById(schoolId))
                .thenReturn(Optional.of(school));

        SchoolDTO schoolDTO = schoolService.getSchool(schoolId);

        assertThat(schoolDTO.getId()).isEqualTo(school.getId());
    }
}