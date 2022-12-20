package com.informatics.cscb869f2020week7.web.view.model;

import com.informatics.cscb869f2020week7.data.entity.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeacherSchoolViewModel {
    private String teacherName;
    private Subject subject;
    private String schoolName;
    private boolean isHighSchool;
}
