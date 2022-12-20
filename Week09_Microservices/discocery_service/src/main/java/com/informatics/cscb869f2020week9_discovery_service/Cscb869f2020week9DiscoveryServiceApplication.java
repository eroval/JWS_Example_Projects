package com.informatics.cscb869f2020week9_discovery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Cscb869f2020week9DiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cscb869f2020week9DiscoveryServiceApplication.class, args);
    }

}
