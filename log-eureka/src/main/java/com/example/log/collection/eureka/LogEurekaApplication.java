package com.example.log.collection.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LogEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogEurekaApplication.class, args);
    }

}
