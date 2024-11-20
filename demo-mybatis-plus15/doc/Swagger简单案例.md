# Swagger简单案例
    https://www.cnblogs.com/Src-z/p/16034771.html

    ## 1，引入依赖（注意springboot与swagger兼容性问题，测试用springboot版本 2.1.3.RELEASE）
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger2</artifactId>
                <version>2.9.2</version>
            </dependency>

            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger-ui</artifactId>
                <version>2.9.2</version>
            </dependency>

    ## 2，编写SwaggerConfig.java
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
                            .apis(RequestHandlerSelectors.basePackage("com.zhangcl.swagger"))
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

    ## 3,Controller层
            @RestController
            @RequestMapping(value="/swaggerTest")
            @Api("测试swagger")

            public class HelloController {


            //    @RequestMapping("/hello")
                @ApiOperation("测试hello")
                @GetMapping(value="/hello")
                public String hello(){
                    return "hello";
                }
            }

    ## 4,多个环境
            application.yml

            server:
              port: 7788
            spring:
              profiles:
                active: pre
            application-dev.yml

            server:
              port: 6688
            application-pre.yml

            server:
              port: 7799

    结果（http://localhost:7799/swagger-ui.html）