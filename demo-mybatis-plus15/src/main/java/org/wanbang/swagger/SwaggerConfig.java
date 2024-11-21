package org.wanbang.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket controllerApi(Environment environment){
        //这里有多个环境，布尔值flag表示是不是pre环境
        Profiles profiles = Profiles.of("pre");
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("默认接口")
                .enable(flag) //判断当前环境是不是 pre
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.wanbang.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("系统API文档")
//                .description("描述：XXXXXXX！")
//                .termsOfServiceUrl("http://www.xtsz.com/")
//                .contact(new Contact("marquis","http://www.XXXXXX.com/","XXXXXXX@qq.com"))
//                .version("版本号:1.0.0")
                .build();

    }
}
