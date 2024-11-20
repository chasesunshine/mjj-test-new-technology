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

1.什么是swagger
Swagger是一个规范和完整的框架，用于生成、描述、调用和可视化RESTful风格的Web服务。简单来说，Swagger是一个功能强大的接口管理工具，并且提供了多种编程语言的前后端分离解决方案。
Swagger有大致有3个优点：
1.Swagger可以整合到代码中，在开发时通过注解，编写注释，自动生成API文档。
2.将前端后台分开，不会有过分的依赖。
3.界面清晰，无论是editor的实时展示还是ui的展示都十分人性化，如果自己仅仅用markdown来编写，又要纠结该如何展现，十分痛苦。

2.swagger注解
swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。

@Api：修饰整个类，描述Controller的作用 
@ApiOperation：描述一个类的一个方法，或者说一个接口 
@ApiParam：单个参数描述 
@ApiModel：用对象来接收参数 
@ApiProperty：用对象接收参数时，描述对象的一个字段 
@ApiResponse：HTTP响应其中1个描述 
@ApiResponses：HTTP响应整体描述 
@ApiIgnore：使用该注解忽略这个API 
@ApiError ：发生错误返回的信息 
@ApiImplicitParam：一个请求参数 
@ApiImplicitParams：多个请求参数
