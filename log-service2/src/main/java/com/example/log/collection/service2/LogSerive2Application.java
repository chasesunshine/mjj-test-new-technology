package com.example.log.collection.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LogSerive2Application {

    public static void main(String[] args) {
        SpringApplication.run(LogSerive2Application.class, args);
    }

}
