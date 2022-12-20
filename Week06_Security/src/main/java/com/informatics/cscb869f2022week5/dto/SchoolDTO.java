package com.informatics.cscb869f2022week5.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informatics.cscb869f2022week5.data.entity.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SchoolDTO {
    private long id;
    private String name;
    private int maxNumberOfStudents;
    private LocalDate foundationDate;
    private boolean isHighSchool;
    private List<Teacher> teachers;
}
