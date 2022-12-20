package com.informatics.cscb869f2022week5.web.view.model;

import com.informatics.cscb869f2022week5.data.entity.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SchoolViewModel {
    private long id;
    private String name;
    private int maxNumberOfStudents;
    private LocalDate foundationDate;
    private boolean isHighSchool;
//    private List<Teacher> teachers;
}
