package org.wanbang.study.filterAndInterceptor.filter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * https://www.cnblogs.com/gm007/p/4451371.html
 *
 * @Author mjj
 * @Date 16:42 2022/2/22
 * @Param
 * @return
 **/
@Slf4j
@Component
@AllArgsConstructor
@WebFilter(filterName = "authFilter", urlPatterns = "/**")
public class MyFilter implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("经过了 implements Filter 的过滤器");
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

