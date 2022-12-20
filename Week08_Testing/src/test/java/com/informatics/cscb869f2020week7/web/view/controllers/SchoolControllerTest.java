package com.informatics.cscb869f2020week7.web.view.controllers;

import com.informatics.cscb869f2020week7.data.entity.School;
import com.informatics.cscb869f2020week7.data.repository.SchoolRepository;
import com.informatics.cscb869f2020week7.dto.SchoolDTO;
import com.informatics.cscb869f2020week7.services.SchoolService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SchoolController.class)
class SchoolControllerTest {

    @MockBean
    private SchoolService schoolService;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void searchSchools() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/schools/search-schools/"))
                .andExpect(status().isOk())
                .andExpect(view().name("/schools/search-schools"));
    }

}