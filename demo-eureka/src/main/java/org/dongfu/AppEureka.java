package org.dongfu;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 13:25
* @version 1.0
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka注册中心
 */
@SpringBootApplication
@EnableEurekaServer //申明这是一个Eureka服务
public class AppEureka {

    public static void main(String[] args) {
        SpringApplication.run(AppEureka.class, args);
    }
}