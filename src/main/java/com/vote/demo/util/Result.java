package com.vote.demo.util;

import java.io.Serializable;

/**
 * @author LH-Yu
 * @date 2019-07-27
 */
public class Result<T> implements Serializable {

    public enum CodeEnum {
        SUCCESS(0),
        重复投票(100001),
        FAIL(999999),
        DEFAULT(900000);

        private final int value;

        CodeEnum(int value) {
            this.value = value;
        }

        private int getValue() {
            return value;
        }
    }

    private String msg;
    private CodeEnum code;
    private T result;

    public Result() {
    }

    ;

    private Result(CodeEnum code) {
        this.code = code;
        this.result = null;
    }

    private Result(String msg, CodeEnum code) {
        this.msg = msg;
        this.code = code;
        this.result = null;
    }

//    private Result(String msg, CodeEnum code, Object obj) {
//        this.msg = msg;
//        this.code = code;
//        this.obj = obj;
//    }

    private Result(String msg, CodeEnum code, T result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }

    public static Result defaultResult() {
        return new Result(CodeEnum.DEFAULT);
    }


    public Result<T> success(T result) {
        return new Result<T>("请求成功", CodeEnum.SUCCESS, result);
    }


    public static Result fail(String msg) {
        return new Result(msg, CodeEnum.FAIL);
    }

    /*支持自定义错误码*/
    public static Result fail(String msg, CodeEnum code) {
        return new Result(msg, code);
    }


    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code.getValue();
    }

    public T getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

}
