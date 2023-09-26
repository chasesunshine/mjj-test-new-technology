package org.wanbang.filter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@AllArgsConstructor
@WebFilter(filterName = "FilterUtil", urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "name", value = "xc"),
        @WebInitParam(name = "like", value = "java") })
public class FilterUtil implements Filter {

    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    public static final List<String> IGNORE_URI_PATTERN = Arrays.asList("/devops/**", "/oss/**","/api/wms/dubhe/**","/api/erp/**");

    /*
     * 过滤器初始化
     *
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----FilterDemo02过滤器初始化----");

        // <filter>
        // <filter-name>FilterDemo02</filter-name>
        // <filter-class>me.gacl.web.filter.FilterDemo02</filter-class>
        // <!--配置FilterDemo02过滤器的初始化参数-->
        // <init-param>
        // <description>配置FilterDemo02过滤器的初始化参数</description>
        // <param-name>name</param-name>
        // <param-value>gacl</param-value>
        // </init-param>
        // <init-param>
        // <description>配置FilterDemo02过滤器的初始化参数</description>
        // <param-name>like</param-name>
        // <param-value>java</param-value>
        // </init-param>
        // </filter>
        //
        // <filter-mapping>
        // <filter-name>FilterDemo02</filter-name>
        // <!--“/*”表示拦截所有的请求 -->
        // <url-pattern>/*</url-pattern>
        // </filter-mapping>

        // 得到过滤器的名字
        String filterName = filterConfig.getFilterName();
        // 得到在web.xml文件中配置的初始化参数
        String initParam1 = filterConfig.getInitParameter("name");
        String initParam2 = filterConfig.getInitParameter("like");
        // 返回过滤器的所有初始化参数的名字的枚举集合。
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();

        System.out.println(filterName);
        System.out.println(initParam1);
        System.out.println(initParam2);
        while (initParameterNames.hasMoreElements()) {
            String paramName = (String) initParameterNames.nextElement();
            System.out.println(paramName);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String requestUrl = httpServletRequest.getRequestURI();
        String contextPath = httpServletRequest.getContextPath();

        // new AntPathMatcher()
        // 在做uri匹配规则发现这个类，根据源码对该类进行分析，它主要用来做类URLs字符串匹配
        boolean match = ANT_PATH_MATCHER.match(contextPath, requestUrl);
        boolean isIgnore = IGNORE_URI_PATTERN.stream().anyMatch(uri -> ANT_PATH_MATCHER.match(contextPath + uri, requestUrl));


        System.out.println(isIgnore);
        System.out.println("FilterDemo02执行前！！！");
        chain.doFilter(request, response); // 让目标资源执行，放行
        System.out.println("FilterDemo02执行后！！！");
    }

    @Override
    public void destroy() {
        System.out.println("----过滤器销毁----");
    }
}