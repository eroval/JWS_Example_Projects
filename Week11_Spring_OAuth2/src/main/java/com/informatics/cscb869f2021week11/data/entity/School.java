package com.informatics.cscb869f2021week11.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="school")
public class School extends BaseEntity{

    private String name;

    private int maxNumberOfStudents;
}
