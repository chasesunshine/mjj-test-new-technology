springcloud2 gateway 之一：简单样例
https://blog.csdn.net/haveqing/article/details/88424598?spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-3-88424598-blog-134069767.235%5Ev43%5Epc_blog_bottom_relevance_base9&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-3-88424598-blog-134069767.235%5Ev43%5Epc_blog_bottom_relevance_base9&utm_relevant_index=4

# 项目：springcloud-gateway 、 springboot-demo
# 访问：
    网关： http://localhost:8666/app1/demo/test1
    项目： http://localhost:8555/demo/test1

    总结：
        把以/app1开头的请求，转发到http://localhost:8081
        
        predicates是谓词，
        
        Spring会根据名称去查找对应的FilterFactory，目前支持的名称有：After、Before、Between、Cookie、Header、Host、Method、Path、Query、RemoteAddr。
        
        Spring-Cloud-Gateway之RoutePredicate
        https://www.jianshu.com/p/03d42105f81f
        
        008-spring cloud gateway-路由谓词RoutePredicate、RoutePredicateFactory
        https://www.cnblogs.com/bjlhx/p/9785926.html
    
    
        ————————————————
        
                                    版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
        ****
        原文链接：https://blog.csdn.net/haveqing/article/details/88424598

# springboot项目配置只能通过gateway访问其他服务  通义千问
    在Spring Boot微服务架构中，通常会使用API Gateway（如Spring Cloud Gateway）作为系统的入口，以实现请求路由、负载均衡、安全认证等功能。这样做的好处包括但不限于提高系统的可维护性、安全性以及解耦各个微服务之间的直接依赖。

    配置Spring Cloud Gateway作为唯一入口
    要配置你的Spring Boot项目使其只能通过Gateway访问其他服务，你可以按照以下步骤操作：

## 引入依赖
    首先，在你的网关项目的pom.xml或build.gradle文件中引入Spring Cloud Gateway的依赖。例如，对于Maven项目，可以在pom.xml中添加如下依赖：
       <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-gateway</artifactId>
       </dependency>
## 配置路由规则
    在网关项目的application.yml或application.properties文件中配置路由规则，指定哪些请求应该转发到哪个微服务。例如：
    spring:
        cloud:
            gateway:
                routes:
                  - id: user_service
                    uri: lb://user-service # 这里的user-service是你的微服务名称
                    predicates:
                      - Path=/users/**
## 安全配置
    为了确保所有的服务调用都必须通过Gateway进行，你需要在每个微服务的安全配置中禁用直接访问。这可以通过配置Spring Security来实现，例如：
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .anyRequest().denyAll() // 拒绝所有未经网关的请求
                .and()
                .csrf().disable(); // 如果不需要CSRF保护，可以禁用
        }
    }
    上述配置将拒绝所有未经网关的请求。但是，如果你希望通过网关进行某些特定路径的访问，你可以调整.anyRequest().denyAll()为更具体的规则，比如允许某些路径的访问。

## 内部服务通信
    对于微服务之间的内部通信，推荐使用Feign、Ribbon等客户端负载均衡工具，并且在配置时指定服务名而非具体地址，这样即使服务实例发生变化，也不会影响到服务间的调用。同时，确保这些内部请求也通过网关进行，或者在安全策略中适当放行这些请求。

    通过以上配置，你可以确保你的Spring Boot项目中的服务只能通过Gateway进行访问，从而增强了系统的安全性和可管理性。