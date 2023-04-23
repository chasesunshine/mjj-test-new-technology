package com.example.log.collection.serive1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class Serive1Application {

    public static void main(String[] args) {
        SpringApplication.run(Serive1Application.class, args);
    }

}
