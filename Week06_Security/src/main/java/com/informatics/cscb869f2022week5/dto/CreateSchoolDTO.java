package com.informatics.cscb869f2022week5.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateSchoolDTO {
    private String name;
    private int maxNumberOfStudents;
    private LocalDate foundationDate;
}
