# java 过滤器和拦截器和RequestBodyAdvice 和 ResponseBodyAdvice(通义千问)
    在Java Web开发中，过滤器（Filter）和拦截器（Interceptor）都是用来对请求进行预处理和后处理的机制，但它们的作用范围和使用场景有所不同。
下面分别介绍这两种机制的实现原理和使用方法。

## 过滤器（Filter）
     定义
         过滤器是Servlet规范的一部分，用于在请求到达Servlet之前或响应返回客户端之前对请求和响应进行处理。过滤器可以实现多种功能，如日志记录、权限检查、编码转换等。

     实现
         1. 创建过滤器类：实现 javax.servlet.Filter 接口，并重写 doFilter 方法。
         2. 配置过滤器：在 web.xml 文件中配置过滤器，指定其拦截的URL模式。

     示例代码
         import javax.servlet.*;
         import java.io.IOException;

         public class MyFilter implements Filter {
             @Override
             public void init(FilterConfig filterConfig) throws ServletException {
                 // 初始化过滤器
             }

             @Override
             public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
                 // 在请求到达Servlet之前执行的代码
                 System.out.println("Before request processing");

                 // 将请求传递给下一个过滤器或目标资源
                 chain.doFilter(request, response);

                 // 在响应返回客户端之前执行的代码
                 System.out.println("After request processing");
             }

             @Override
             public void destroy() {
                 // 销毁过滤器
             }
         }

     配置文件（web.xml）
         <filter>
             <filter-name>myFilter</filter-name>
             <filter-class>com.example.MyFilter</filter-class>
         </filter>
         <filter-mapping>
             <filter-name>myFilter</filter-name>
             <url-pattern>/*</url-pattern>
         </filter-mapping>

## 拦截器（Interceptor）
     定义
         拦截器是Spring框架提供的一个功能，用于在控制器方法执行前后进行拦截处理。拦截器可以实现更细粒度的控制，如权限验证、日志记录等。

     实现
         1. 创建拦截器类：实现 org.springframework.web.servlet.HandlerInterceptor 接口，并重写相关方法。
         2. 配置拦截器：在Spring MVC配置文件中注册拦截器，并指定其拦截的路径。

     示例代码
         import org.springframework.stereotype.Component;
         import org.springframework.web.servlet.HandlerInterceptor;
         import org.springframework.web.servlet.ModelAndView;

         import javax.servlet.http.HttpServletRequest;
         import javax.servlet.http.HttpServletResponse;

         @Component
         public class MyInterceptor implements HandlerInterceptor {

             @Override
             public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                 // 在控制器方法执行之前执行的代码
                 System.out.println("Before controller method execution");
                 return true; // 返回true表示继续执行后续操作，返回false表示中断请求处理
             }

             @Override
             public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                 // 在控制器方法执行之后，视图渲染之前执行的代码
                 System.out.println("After controller method execution, before view rendering");
             }

             @Override
             public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                 // 在视图渲染之后执行的代码
                 System.out.println("After view rendering");
             }
         }

     配置文件（Spring MVC配置）
         import org.springframework.context.annotation.Configuration;
         import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
         import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

         @Configuration
         public class WebConfig implements WebMvcConfigurer {

             @Override
             public void addInterceptors(InterceptorRegistry registry) {
                 registry.addInterceptor(new MyInterceptor())
                         .addPathPatterns("/**") // 指定拦截的路径
                         .excludePathPatterns("/login", "/logout"); // 排除某些路径
             }
         }

# RequestBodyAdvice 和 ResponseBodyAdvice
## RequestBodyAdvice
    RequestBodyAdvice 是Spring MVC提供的一个接口，用于在请求体被绑定到控制器方法参数之前进行预处理。这在需要对请求体进行全局性修改或验证时非常有用。

    实现
        1. 创建 RequestBodyAdvice 类：实现 RequestBodyAdvice 接口，并重写相关方法。
        2. 注册 RequestBodyAdvice：通过 @ControllerAdvice 注解将其实例注册为全局处理器。

    示例代码
        import org.springframework.core.MethodParameter;
        import org.springframework.http.converter.HttpMessageConverter;
        import org.springframework.web.bind.support.WebDataBinderFactory;
        import org.springframework.web.context.request.NativeWebRequest;
        import org.springframework.web.method.support.HandlerMethodArgumentResolver;
        import org.springframework.web.method.support.ModelAndViewContainer;
        import org.springframework.web.bind.annotation.ControllerAdvice;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RestControllerAdvice;

        @ControllerAdvice
        public class MyRequestBodyAdvice implements RequestBodyAdvice {

            @Override
            public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
                // 判断是否需要处理
                return methodParameter.hasParameterAnnotation(RequestBody.class);
            }

            @Override
            public Object handleEmptyBody(Object body, MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType, NativeWebRequest webRequest) {
                // 处理空请求体
                return body;
            }

            @Override
            public Object beforeBodyRead(Object body, MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType, NativeWebRequest webRequest) throws IOException {
                // 在请求体被读取之前执行的代码
                System.out.println("Before body read: " + body);
                return body;
            }

            @Override
            public Object afterBodyRead(Object body, MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType, NativeWebRequest webRequest) {
                // 在请求体被读取之后执行的代码
                System.out.println("After body read: " + body);
                return body;
            }
        }
## ResponseBodyAdvice
        ResponseBodyAdvice 是Spring MVC提供的一个接口，用于在响应体被写回客户端之前进行预处理。这在需要对响应体进行全局性修改或格式化时非常有用。

    实现
        1. 创建 ResponseBodyAdvice 类：实现 ResponseBodyAdvice 接口，并重写相关方法。
        2. 注册 ResponseBodyAdvice：通过 @ControllerAdvice 注解将其实例注册为全局处理器。

    示例代码
        import org.springframework.core.MethodParameter;
        import org.springframework.http.MediaType;
        import org.springframework.http.converter.HttpMessageConverter;
        import org.springframework.http.server.ServerHttpRequest;
        import org.springframework.http.server.ServerHttpResponse;
        import org.springframework.web.bind.annotation.ControllerAdvice;
        import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

        @ControllerAdvice
        public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {

            @Override
            public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
                // 判断是否需要处理
                return true;
            }

            @Override
            public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
                // 在响应体被写回客户端之前执行的代码
                System.out.println("Before body write: " + body);
                return body;
            }
        }


## 总结
     过滤器：是Servlet规范的一部分，作用于整个Web应用，可以在请求到达Servlet之前或响应返回客户端之前进行处理。
     拦截器：是Spring框架的一部分，作用于Spring MVC的控制器方法，可以在控制器方法执行前后进行更细粒度的控制。
     RequestBodyAdvice：用于在请求体被绑定到控制器方法参数之前进行预处理。
     ResponseBodyAdvice：用于在响应体被写回客户端之前进行预处理

    选择使用哪种机制取决于具体的需求和应用场景。对于需要在整个Web应用层面进行处理的场景，通常使用过滤器；对于需要在控制器方法层面进行更细粒度控制的场景，通常使用拦截器；
    对于需要对请求体或响应体进行全局性处理的场景，通常使用 RequestBodyAdvice 和 ResponseBodyAdvice。


# java 过滤器 和 拦截器 和 RequestBodyAdvice、ResponseBodyAdvice各适用于哪种业务场景(通义千问)
# 过滤器（Filter）
    适用场景
        编码转换：确保所有请求和响应使用统一的字符编码。
        日志记录：记录请求和响应的信息，用于审计或调试。
        权限检查：在请求到达Servlet之前进行基本的权限验证。
        安全过滤：防止SQL注入、XSS攻击等安全问题。
        性能监控：记录请求的处理时间，用于性能分析。
    优势
        全局性：作用于整个Web应用，可以对所有请求和响应进行统一处理。
        标准化：是Servlet规范的一部分，支持跨框架使用。

# 拦截器（Interceptor）
    适用场景
        权限验证：在控制器方法执行前进行细粒度的权限检查。
        日志记录：记录特定控制器方法的调用信息。
        数据预处理：在控制器方法执行前对请求参数进行预处理。
        数据后处理：在控制器方法执行后对返回结果进行后处理。
        事务管理：在控制器方法执行前后管理事务。
    优势
        细粒度：作用于Spring MVC的控制器方法，可以针对特定的URL路径或控制器方法进行处理。
        灵活配置：可以通过配置文件灵活地添加和移除拦截器。

# RequestBodyAdvice
    适用场景
        请求体验证：在请求体被绑定到控制器方法参数之前进行验证。
        数据转换：在请求体被绑定到控制器方法参数之前进行数据格式转换。
        默认值设置：为请求体中的某些字段设置默认值。
        日志记录：记录请求体的内容，用于调试或审计。
    优势
        细粒度：作用于请求体的处理过程，可以针对特定的请求体进行处理。
        全局性：通过 @ControllerAdvice 注解可以全局生效，减少重复代码。

# ResponseBodyAdvice
    适用场景
        响应体格式化：在响应体被写回客户端之前进行格式化，如添加统一的响应头。
        数据转换：在响应体被写回客户端之前进行数据格式转换。
        日志记录：记录响应体的内容，用于调试或审计。
        错误处理：在响应体被写回客户端之前处理异常，返回友好的错误信息。
    优势
        细粒度：作用于响应体的处理过程，可以针对特定的响应体进行处理。
        全局性：通过 @ControllerAdvice 注解可以全局生效，减少重复代码。
            
# 总结
    过滤器（Filter）：适用于需要在整个Web应用层面进行统一处理的场景，如编码转换、日志记录、权限检查等。
    拦截器（Interceptor）：适用于需要在控制器方法层面进行细粒度控制的场景，如权限验证、日志记录、数据预处理和后处理等。
    RequestBodyAdvice：适用于需要在请求体被绑定到控制器方法参数之前进行处理的场景，如请求体验证、数据转换、默认值设置等。
    ResponseBodyAdvice：适用于需要在响应体被写回客户端之前进行处理的场景，如响应体格式化、数据转换、日志记录、错误处理等。



# JAVA过滤器
    https://www.cnblogs.com/gm007/p/4451371.html
    对于get请求和post请求全局过滤：

## 自己创建一个类，实现 HttpServletRequestWrapper 接口
    public class FilterSetRequest extends HttpServletRequestWrapper {
        public FilterSetRequest(HttpServletRequest request){
            super(request);
        }
        @Override
        public String getParameter(String name){
            String value = super.getParameter(name);
            //判断是否是使用get请求
            if(getMethod().equalsIgnoreCase("GET")){
            try
            {
                value = new String(value.getBytes("iso-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            }
            return value;
        }
    }

## 在Filter类中使用自己定义的reqest
    public class MyFilter implements Filter {

        public void destroy() {
            // TODO Auto-generated method stub

        }

        public void doFilter(ServletRequest request,
                ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            //掉包的request

            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");

            FilterSetRequest req = new FilterSetRequest((HttpServletRequest)request);
            chain.doFilter(req, response);
        }

        public void init(FilterConfig arg0)
                throws ServletException {

        }

    }

# 轻松实现java拦截器+自定义注解
    https://www.cnblogs.com/nihilwater/p/13447023.html
    内容：拦截器的使用很简单，定义一个自己的拦截器，向配置中添加一下就可以使用。为了方便，之后又引入了注解。本文就将用简洁的代码构建一个springboot的拦截器。
    假设需求：访问项目的controller是都要进行"token验证"，除了某些像登录之类的方法。
