package com.informatics.cscb869f2020week7.dto;

import com.informatics.cscb869f2020week7.data.entity.School;
import com.informatics.cscb869f2020week7.data.entity.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTeacherDTO {
    private String name;
    private Subject subject;
    private School school;
}
