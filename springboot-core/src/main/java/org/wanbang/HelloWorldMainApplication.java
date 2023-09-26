package org.wanbang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
  *  @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
  */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class HelloWorldMainApplication {

	public static void main(String[] args){
		// Spring应用启动起来
		SpringApplication.run(HelloWorldMainApplication.class,args);
	}
}
