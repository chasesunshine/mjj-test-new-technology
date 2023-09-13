package org.dongfu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.wanbang.dao")	//程序会自动为mybatis创建代理对象
public class ApplicationSpringStudy {
	
	//定义主启动类
	public static void main(String[] args) {
		//启动SpringBoot程序
		SpringApplication.run(ApplicationSpringStudy.class, args);
	}
}
