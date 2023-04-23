package org.dongfu.common;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 14:38
* @version 1.0
*/

import lombok.Getter;

@Getter
public enum  ResCode {
    OK(0,"ok"),
    E_500(500,"500的异常"),
    E_1000(1000,"1000的异常"),
    E_1001(1001,"1001的异常"),
    ;
    private int code;

    private String msg;

    ResCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResCode ofCode(int code){
        ResCode[] values = ResCode.values();
        for (ResCode resCode : values){
            if (code == resCode.code){
                return resCode;
            }
        }
        return ResCode.E_500;
    }
}