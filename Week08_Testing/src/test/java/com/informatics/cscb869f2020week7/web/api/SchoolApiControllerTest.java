package com.informatics.cscb869f2020week7.web.api;

import com.informatics.cscb869f2020week7.data.entity.School;
import com.informatics.cscb869f2020week7.dto.SchoolDTO;
import com.informatics.cscb869f2020week7.services.SchoolService;
import com.informatics.cscb869f2020week7.web.view.controllers.SchoolController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.scheduling.config.ScheduledTaskHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@ExtendWith(SpringExtension.class)
@WebMvcTest(SchoolApiController.class)
class SchoolApiControllerTest {

    @MockBean
    private SchoolService schoolService;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getSchoolById() throws Exception {
        long schoolId = 1;
        SchoolDTO school = new SchoolDTO();
        school.setId(schoolId);
        school.setName("Hristo Botev");
        school.setMaxNumberOfStudents(1200);
        school.setFoundationDate(LocalDate.of(2000,10,20));

        when(schoolService.getSchool(schoolId)).thenReturn(school);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/schools/" + schoolId))
                .andDo(print())
                .andExpect(status().isOk());
    }
}