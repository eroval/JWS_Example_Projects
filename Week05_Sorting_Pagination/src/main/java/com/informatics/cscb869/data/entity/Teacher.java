package com.informatics.cscb869.data.entity;

import com.informatics.cscb869.data.entity.School;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity {

    private String name;

    @Enumerated
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
