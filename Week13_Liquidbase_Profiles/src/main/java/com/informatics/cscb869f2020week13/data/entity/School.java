package com.informatics.cscb869f2020week13.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "school")
public class School extends BaseEntity {

    private String name;

    private boolean isHighschool;

//    private int maxNumberOfStudents;

}