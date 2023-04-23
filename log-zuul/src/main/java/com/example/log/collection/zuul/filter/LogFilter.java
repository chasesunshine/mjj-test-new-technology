package com.example.log.collection.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.log.collection.core.LogCollectionConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;


@Component
@Slf4j
public class LogFilter extends ZuulFilter {

    public static final String START_TIME_KEY = "start_time";

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        try {
            HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
            RequestContext.getCurrentContext().set(START_TIME_KEY, System.currentTimeMillis());
            HttpEntity httpEntity = new HttpEntity();

            httpEntity.setMethod(request.getMethod());
            httpEntity.setUrl(request.getRequestURI());
            httpEntity.setIp(request.getRemoteAddr());
            HashMap<String, Object> parameter = showParams(request);
            httpEntity.setParameter(JSON.toJSONString(parameter));
            httpEntity.setUserAgent(request.getHeader("user-agent"));
            String body = "";
            InputStream stream = RequestContext.getCurrentContext().getResponseDataStream();
            byte[] bytes = StreamUtils.copyToByteArray(stream);
            body = new String(bytes, StandardCharsets.UTF_8);
            httpEntity.setResult(body);
            long startTime = (long) RequestContext.getCurrentContext().get(START_TIME_KEY);
            httpEntity.setLaunchTime(new Date(startTime));
            httpEntity.setDuration(System.currentTimeMillis() - startTime);
            httpEntity.setTraceId(RequestContext.getCurrentContext().getZuulRequestHeaders().get(LogCollectionConstants.traceId));
            log.info("接口统计 {}",JSON.toJSONString(httpEntity));
            RequestContext.getCurrentContext().setResponseBody(body);
        } catch (Exception e) {
            log.error("日志统计失败", e);
            return true;
        }
        return true;
    }

    public static HashMap<String, Object> showParams(HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length > 0) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }
        return map;
    }
}