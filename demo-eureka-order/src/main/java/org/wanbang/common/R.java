package org.wanbang.common;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 14:43
* @version 1.0
*/

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class R<T> {
    private int code;

    private String msg;

    private T data;

    private boolean ok;


    private R(int code, String msg, T data, boolean ok) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }


    public static <T> R<T> ok(T t) {
        return new R(ResCode.OK.getCode(), ResCode.OK.getMsg(), t, true);
    }


    public static <T> R<T> error(ResCode resCode) {
        return new R(resCode.getCode(), resCode.getMsg(), null, false);
    }
}