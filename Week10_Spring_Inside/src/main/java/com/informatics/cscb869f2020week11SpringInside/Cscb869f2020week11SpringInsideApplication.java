package com.informatics.cscb869f2020week11SpringInside;

import application.Principal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.informatics.cscb869f2020week11SpringInside", "application"})
public class Cscb869f2020week11SpringInsideApplication {

    private static Employee employee;

    public Cscb869f2020week11SpringInsideApplication(@Qualifier("Teacher") Employee employee) {
        this.employee = employee;
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext
                = SpringApplication.run(Cscb869f2020week11SpringInsideApplication.class, args);

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

//         Principal principal1 = new Principal();
        Principal principal1 = applicationContext.getBean(Principal.class);
        principal1.setExperience(5);
        System.out.println("Principal 1 " + principal1.toString());

        Principal principal2 = applicationContext.getBean(Principal.class);
        principal2.setExperience(10);
        System.out.println("Principal 1 " + principal1.toString());
        System.out.println("Principal 2 " + principal2.toString());


        Employee employee1 = applicationContext.getBean(Employee.class);
        employee1 = employee;
        System.out.println(employee1.toString());

    }

}
