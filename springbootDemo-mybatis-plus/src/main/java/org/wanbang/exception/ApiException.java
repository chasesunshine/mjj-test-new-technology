package org.wanbang.exception;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiException {

    /**
     * 捕捉全局所有的异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String,Object> errorHandler(Exception e) {
        System.out.println(e);
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",1);
        result.put("msg",e.getMessage());
        return result;
    }

    /**
     * 仅仅捕捉校验所产生的异常
     * @param exception
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String,Object> errorHandler(MethodArgumentNotValidException exception) {
        System.out.println(exception);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        // 对校验异常返回的格式做出想要的返回结果
        FieldError fieldError = exception.getBindingResult().getFieldError();
        resultMap.put("code",1);
        resultMap.put("msg",fieldError.getDefaultMessage());
        return resultMap;
    }
}
