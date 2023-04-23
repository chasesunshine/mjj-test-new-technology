package com.example.log.collection.serive1.api.service2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author :
 * @date :2021-02-08 10:38
 * @description :
 */
@FeignClient(value = "SPRING-CLOUD-SERVICE2")
public interface DemoApiClient {

    @GetMapping("/demo/getlist2")
    List<String> getlist2();
}