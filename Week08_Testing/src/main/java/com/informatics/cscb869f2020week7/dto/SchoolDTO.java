package com.informatics.cscb869f2020week7.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SchoolDTO {
    private long id;
    private String name;
    private int maxNumberOfStudents;
    private LocalDate foundationDate;
    private boolean isHighSchool;
}
