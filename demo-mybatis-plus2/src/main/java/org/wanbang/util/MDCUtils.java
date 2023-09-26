package org.wanbang.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class MDCUtils {

    /**
     * [获取 traceId]
     * @return java.lang.String
     **/
    public static String mdc(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        String traceId;
        String traceIdKey = "traceId";
        if (request.getHeader(traceIdKey) == null) {
            traceId = UUID.randomUUID().toString();
        } else {
            traceId = request.getHeader(traceIdKey);
        }
        return traceId;
    }

}