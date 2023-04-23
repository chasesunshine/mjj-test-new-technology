package com.example.log.collection.zuul.filter;

import com.log.collection.core.LogCollectionConstants;
import com.log.collection.core.LogHelper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author :XXX
 * @date :2021-02-07 15:55
 * @description :
 */
@Component
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
        return null;
    }
}