package org.wanbang.study.redisLock.utils;


/**
 * @author cloudgc
 * @since 8/1/2020
 */
public class BaseRuntimeException extends RuntimeException implements ExceptionMessage {

    private static final long serialVersionUID = -8512829179333068821L;

    /**
     * 错误信息
     */
    private final MessageCode messageCode;

    @Override
    public MessageCode getMessageCode() {
        return this.messageCode;
    }

    public BaseRuntimeException(MessageCode messageCode) {
        super(messageCode.getMessage());
        this.messageCode = messageCode;

    }

    public BaseRuntimeException(MessageCode messageCode, Throwable cause) {
        super(messageCode.getMessage(), cause);
        this.messageCode = messageCode;
    }

    public BaseRuntimeException(MessageCode messageCode, String... sub) {
        super(messageCode.getSubMessage(sub));
        this.messageCode = messageCode;
    }

    public BaseRuntimeException(MessageCode messageCode, Throwable cause, String... sub) {
        super(messageCode.getSubMessage(sub), cause);
        this.messageCode = messageCode;
    }
}
