package com.informatics.cscb869f2022week5.dto;

import com.informatics.cscb869f2022week5.data.entity.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SchoolTeachersDTO {
    private String name;
    private int maxNumberOfStudents;
    private LocalDate foundationDate;
    private List<Teacher> teachers;
}
