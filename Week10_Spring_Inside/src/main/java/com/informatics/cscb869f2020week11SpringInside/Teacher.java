package com.informatics.cscb869f2020week11SpringInside;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Component("Teacher")
//@Primary
public class Teacher extends Employee {
    private String subject;
}
