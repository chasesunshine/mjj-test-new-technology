package org.dongfu.dto.response;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/23 11:36
* @version 1.0
*/

import lombok.Data;

@Data
public class ResponseData<T> {
    private Boolean success;
    private Integer code;
    private String message;
    private String traceId;
    private T data;

    public static <T> ResponseData<T> success(T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setSuccess(true);
        responseData.setData(data);
        responseData.setCode(ResponseCode.OK.getCode());
        responseData.setMessage(ResponseCode.OK.getMessage());
        return responseData;
    }

    public static <T> ResponseData<T> failure(ResponseCode code, String message, T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setSuccess(false);
        message = (message == null || "".equals(message)) ? code.getMessage() : message;
        responseData.setMessage(message);
        responseData.setData(data);
        responseData.setCode(code.getCode());
        return responseData;
    }

    public static <T> ResponseData<T> failure(ResponseCode code, String message) {
        return failure(code, message, null);
    }

    public static <T> ResponseData<T> failure(ResponseCode code) {
        return failure(code, null, null);
    }
}
