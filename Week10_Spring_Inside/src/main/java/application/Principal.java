package application;

import com.informatics.cscb869f2020week11SpringInside.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Component("Principal")
//@Scope(value="prototype")
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Primary
public class Principal extends Employee {
    private int experience;
}
