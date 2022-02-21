package org.wanbang.study.redisLock.utils;

import java.io.Serializable;

/**
 * @author cloudgc
 * @since 8/1/2020
 */
public class BusinessException extends BaseRuntimeException implements Serializable {

    private static final long serialVersionUID = 8985308314915338815L;

    public BusinessException(MessageCode messageCode) {
        super(messageCode);
    }

    public BusinessException(MessageCode messageCode, Throwable cause) {
        super(messageCode, cause);
    }

    public BusinessException(MessageCode messageCode, String... sub) {
        super(messageCode, sub);
    }

    public BusinessException(MessageCode messageCode, Throwable cause, String... sub) {
        super(messageCode, cause, sub);
    }
}
