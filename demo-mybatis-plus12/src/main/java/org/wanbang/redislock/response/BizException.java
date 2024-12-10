package org.wanbang.redislock.response;

import lombok.Data;


@Data
public class BizException extends RuntimeException {

    private BizCodeEnum errCode;

    public BizException() {
        super();
        this.errCode = BizCodeEnum.FAIL;
    }

    public BizException(String s) {
        super(s);
        this.errCode = BizCodeEnum.FAIL;
    }

    public BizException(BizCodeEnum errCode, String s) {
        super(s);
        this.errCode = errCode;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.errCode = BizCodeEnum.SYSTEM_ERROR;
    }

    public BizException(Throwable cause) {
        super(cause);
        this.errCode = BizCodeEnum.SYSTEM_ERROR;
    }
}
