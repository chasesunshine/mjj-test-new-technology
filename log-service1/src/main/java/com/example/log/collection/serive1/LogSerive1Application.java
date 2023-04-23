package com.example.log.collection.serive1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class LogSerive1Application {

    public static void main(String[] args) {
        SpringApplication.run(LogSerive1Application.class, args);
    }

}
