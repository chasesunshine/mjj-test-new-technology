package org.wanbang.common.entity;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private int status;
    private String message;
    private T data;
    private String traceId;
    private String errMsg;

    public static Result of(Result result) {
        return new Result(result.getStatus(), result.getMessage(), result.getData(), result.getTraceId());
    }

    public boolean rsIsOk() {
        return status == 200;
    }

    public static <T>Result success(T data,String traceId) {
        return new Result(200, "OK", data,traceId);
    }

    public static Result success() {
        return new Result(200, "OK");
    }


    public static Result success(int code, String message) {
        return new Result(code, message);
    }

    public static <T> Result success(T data) {
        return new Result(200, "OK", data);
    }

    public static <T> Result success(int code, String message, T data) {
        return new Result(code, message, data);
    }


    public static Result error() {
        return new Result(500, "System error");
    }

    public static Result error(int code, String message) {
        return new Result(code, message);
    }

    public static Result error(String message) {
        return new Result(500, message);
    }

    public static <T> Result error(String message, T data) {
        return new Result(500, message, data);
    }

    public static <T> Result error(int code, String message, T data) {
        return new Result(code, message, data);
    }


    public Result() {
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(int status, String message, String traceId) {
        this.status = status;
        this.message = message;
        this.traceId = traceId;
    }

    public Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Result(int status, String message, T data, String traceId) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.traceId = traceId;
    }

    public Result errorReturn(String message) {
        this.setStatus(500);
        this.setMessage(message);
        return this;
    }

    public Result errorReturn(int status, String message) {
        this.setStatus(status);
        this.setMessage(message);
        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", traceId='" + traceId + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
