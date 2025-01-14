package org.wanbang.redislock.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author
 */
@Data
public class SingleResponse<T> implements Serializable {

    public Integer code;
    public String msg;
    public T body;

    private SingleResponse() {
    }

    public SingleResponse(Integer code, String msg, T body) {
        this.code = code;
        this.msg = msg;
        this.body = body;
    }

    public static <T> SingleResponse<T> build(Integer code, String msg, T body) {
        return new SingleResponse(code, msg, body);
    }

    public static <T> SingleResponse<T> of(String msg, T body) {
        return build(BizCodeEnum.SUCCESS.getCode(), !StringUtils.isEmpty(msg) ? msg : BizCodeEnum.SUCCESS.getMessage(), body);
    }

    public static <T> SingleResponse<T> of(T body) {
        return build(BizCodeEnum.SUCCESS.getCode(), BizCodeEnum.SUCCESS.getMessage(), body);
    }

    public static <T> SingleResponse<T> okOfMsg(String msg) {
        return build(BizCodeEnum.SUCCESS.getCode(), !StringUtils.isEmpty(msg) ? msg : BizCodeEnum.SUCCESS.getMessage(), null);
    }

    public static <T> SingleResponse<T> ok() {
        return build(BizCodeEnum.SUCCESS.getCode(), BizCodeEnum.SUCCESS.getMessage(), null);
    }

    public static <T> SingleResponse<T> fail(String msg, T body) {
        return build(BizCodeEnum.FAIL.getCode(), !StringUtils.isEmpty(msg) ? msg : BizCodeEnum.FAIL.getMessage(), body);
    }

    public static <T> SingleResponse<T> fail(String msg) {
        return build(BizCodeEnum.FAIL.getCode(), !StringUtils.isEmpty(msg) ? msg : BizCodeEnum.FAIL.getMessage(), null);
    }

    public static <T> SingleResponse<T> fail() {
        return build(BizCodeEnum.FAIL.getCode(), BizCodeEnum.FAIL.getMessage(), null);
    }

    /**
     * 状态枚举
     *
     * @param tmallCodeEnum
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> SingleResponse<T> fail(BizCodeEnum tmallCodeEnum, String msg) {
        return build(tmallCodeEnum.getCode(), !StringUtils.isEmpty(msg) ? msg : tmallCodeEnum.getMessage(), null);
    }

    /**
     * 状态枚举
     *
     * @param tmallCodeEnum
     * @param <T>
     * @return
     */
    public static <T> SingleResponse<T> fail(BizCodeEnum tmallCodeEnum) {
        return build(tmallCodeEnum.getCode(), tmallCodeEnum.getMessage(), null);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return BizCodeEnum.SUCCESS.getCode().equals(this.code);
    }

    @JsonIgnore
    public static boolean isSucc(SingleResponse response) {
        return Objects.nonNull(response) && BizCodeEnum.SUCCESS.getCode().equals(response.getCode());
    }

}