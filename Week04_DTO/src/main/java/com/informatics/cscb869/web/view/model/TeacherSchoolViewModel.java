package com.informatics.cscb869.web.view.model;

import com.informatics.cscb869.data.entity.Subject;
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
