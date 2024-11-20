# Swagger�򵥰���
    https://www.cnblogs.com/Src-z/p/16034771.html

    ## 1������������ע��springboot��swagger���������⣬������springboot�汾 2.1.3.RELEASE��
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

    ## 2����дSwaggerConfig.java
            @Configuration
            @EnableSwagger2
            public class SwaggerConfig {

                @Bean
                public Docket controllerApi(Environment environment){
            ������������������������//�����ж������������ֵflag��ʾ�ǲ���pre����
                    Profiles profiles = Profiles.of("pre");
                    boolean flag = environment.acceptsProfiles(profiles);

                    return new Docket(DocumentationType.SWAGGER_2)
                            .apiInfo(apiInfo())
                            .groupName("Ĭ�Ͻӿ�")
                            .enable(flag) //�жϵ�ǰ�����ǲ��� pre
                            .select()
                            .apis(RequestHandlerSelectors.basePackage("com.zhangcl.swagger"))
                            .paths(PathSelectors.any())
                            .build();
                }

                private ApiInfo apiInfo(){
                    return new ApiInfoBuilder()
                            .title("ϵͳAPI�ĵ�")
            //                .description("������XXXXXXX��")
            //                .termsOfServiceUrl("http://www.xtsz.com/")
            //                .contact(new Contact("marquis","http://www.XXXXXX.com/","XXXXXXX@qq.com"))
            //                .version("�汾��:1.0.0")
                            .build();

                }
            }

    ## 3,Controller��
            @RestController
            @RequestMapping(value="/swaggerTest")
            @Api("����swagger")

            public class HelloController {


            //    @RequestMapping("/hello")
                @ApiOperation("����hello")
                @GetMapping(value="/hello")
                public String hello(){
                    return "hello";
                }
            }

    ## 4,�������
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

    �����http://localhost:7799/swagger-ui.html��