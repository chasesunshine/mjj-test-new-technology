package org.wanbang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@MapperScan("org.wanbang.mapper")	//程序会自动为mybatis创建代理对象
public class Application_Mybatis {
	
	//定义主启动类
	public static void main(String[] args) {
		//启动SpringBoot程序
		SpringApplication.run(Application_Mybatis.class, args);
	}
}
