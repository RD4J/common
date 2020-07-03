package com.rd4j.common.pojo;


import com.rd4j.common.annotation.Description;
import com.rd4j.common.enums.ResultCode;
import com.rd4j.common.exception.IllegalCodeException;
import com.rd4j.common.util.Formatter;

import java.io.Serializable;

/**
 * 标准结果
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class Result implements Serializable {
    /**
     * 错误码
     */
    @Description({"错误码"})
    protected int code = ResultCode.FAIL.code();

    /**
     * 消息
     */
    @Description({"错误消息"})
    protected String message = ResultCode.FAIL.describe();

    public Result() {
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public static Result create() {
        return new Result();
    }

    public static Result createSuccessful() {
        return new Result(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.describe());
    }

    public static Result createSuccessful(String message, Object... formatArg) {
        return new Result(ResultCode.SUCCESS.code(), Formatter.message(message, formatArg));
    }

    public static Result createFailed(String message, Object... formatArg) {
        return new Result(ResultCode.FAIL.code(), Formatter.message(message, formatArg));
    }

    public static Result createFailed(int code, String message, Object... formatArg) {
        return new Result(code, Formatter.message(message, formatArg));
    }

    public boolean isSuccessful() {
        return getCode() == ResultCode.SUCCESS.code();
    }

    public <R> R setSuccessful() {
        return set(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.describe());
    }

    public <R> R setSuccessful(String message, Object... formatArg) {
        return set(ResultCode.SUCCESS.code(), message, formatArg);
    }

    public <R> R setFailed() {
        return setFailed(ResultCode.FAIL.code(), ResultCode.FAIL.describe());
    }

    public <R> R setFailed(String message, Object... formatArg) {
        return setFailed(ResultCode.FAIL.code(), message, formatArg);
    }

    public <R> R setFailed(int code, String message, Object... formatArg) {
        if (code == ResultCode.SUCCESS.code()) {
            throw new IllegalCodeException("失败code参数不能设置0");
        }
        return set(code, message, formatArg);
    }


    public <R> R set(int code, String message, Object... formatArg) {
        this.setCode(code);
        this.setMessage(Formatter.message(message, formatArg));
        return (R) this;
    }


    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
