package com.informatics.cscb869f2020week9_school_consuming_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SchoolDTO {
    private long id;
    private String name;
    private int maxNumberOfStudents;
}
