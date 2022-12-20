package com.informatics.cscb869f2020week4.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Where(clause = "deleted = 0")
@Table(name = "school")
public class School extends BaseEntity {

    private String name;

    private int maxNumberOfStudents;

    private boolean isHighSchool;

    @OneToMany(mappedBy = "school")
    @JsonIgnoreProperties("school")
    private List<Teacher> teachers;

    private int deleted = 0;

}