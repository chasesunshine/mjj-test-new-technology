package com.example.log.collection.zuul.filter;

import com.log.collection.core.LogCollectionConstants;
import com.log.collection.core.LogHelper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author :XXX
 * @date :2021-02-07 15:55
 * @description : 生成traceId，将traceId加入到RequestHeader中，带入到下游请求中。
 */
@Component
@Slf4j
public class TracePreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        String traceIdVal = LogHelper.getTraceId();
        MDC.put(LogCollectionConstants.traceId, traceIdVal);
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(LogCollectionConstants.traceId, traceIdVal);
        log.info("生成traceId，将traceId加入到RequestHeader中，带入到下游请求中。");
        return null;
    }
}