package org.wanbang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Application_Mybatis3 {
	
	//定义主启动类
	public static void main(String[] args) {
		//启动SpringBoot程序
		SpringApplication.run(Application_Mybatis3.class, args);
	}
}
