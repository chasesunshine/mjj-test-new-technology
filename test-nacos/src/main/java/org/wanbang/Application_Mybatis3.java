package org.wanbang;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "mjj", autoRefreshed = true)
public class Application_Mybatis3 {
	
	//定义主启动类
	public static void main(String[] args) {
		//启动SpringBoot程序
		SpringApplication.run(Application_Mybatis3.class, args);
	}
}
