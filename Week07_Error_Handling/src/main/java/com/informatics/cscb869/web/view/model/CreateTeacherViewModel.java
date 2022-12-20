package com.informatics.cscb869.web.view.model;

import com.informatics.cscb869.data.entity.School;
import com.informatics.cscb869.data.entity.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class CreateTeacherViewModel {
    @NotBlank
    @Size(min = 5, max=30)
    private String name;

    private Subject subject;

    private School school;
}
