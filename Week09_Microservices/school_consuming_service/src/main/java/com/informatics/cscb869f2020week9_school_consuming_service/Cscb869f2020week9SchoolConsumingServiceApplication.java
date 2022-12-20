package com.informatics.cscb869f2020week9_school_consuming_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class Cscb869f2020week9SchoolConsumingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Cscb869f2020week9SchoolConsumingServiceApplication.class, args);
    }
}
