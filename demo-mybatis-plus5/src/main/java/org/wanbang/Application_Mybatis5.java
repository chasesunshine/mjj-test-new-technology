package org.wanbang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan("org.wanbang.dao")	//程序会自动为mybatis创建代理对象
public class Application_Mybatis5 {
	
	//定义主启动类
	public static void main(String[] args) {
		//启动SpringBoot程序
		SpringApplication.run(Application_Mybatis5.class, args);
	}
}
