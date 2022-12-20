package com.informatics.cscb869f2020week13.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name = "teacher")
public class Teacher extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
