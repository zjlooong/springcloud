package com.zjl.order.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class InvokeResult<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg = "";
    private T data;
    private Boolean success;

    /**
     *
     * @param data 数据
     * @param msg  説明
     * @return
     */
    public static InvokeResult success(Object data, String msg) {
        InvokeResult result = new InvokeResult();
        result.data = data;
        result.code = 200;
        result.msg = msg;
        result.success = true;
        return result;
    }

    public static InvokeResult success(Object data) {
        InvokeResult result = new InvokeResult();
        result.data = data;
        result.code = 200;
        result.success = true;
        return result;
    }

    public static InvokeResult success() {
        InvokeResult result = new InvokeResult();
        result.code = 200;
        result.success = true;
        return result;
    }

    public static InvokeResult failure(String msg) {
        return failure(-1, msg);
    }

    public static InvokeResult failure(int code, String msg) {
        InvokeResult result = new InvokeResult();
        result.msg = msg;
        result.code = code;
        result.success = false;
        return result;
    }

//    public static InvokeResult failure(SystemCode systemCode) {
//        InvokeResult result = new InvokeResult();
//        result.msg = systemCode.getMessage();
//        result.code = systemCode.getCode();
//        result.success=false;
//        return result;
//    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getsuccess() {
        return success;
    }

    public void setsuccess(Boolean success) {
        this.success = success;
    }

    // 构建函数，异常捕捉用
    public InvokeResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public InvokeResult() {

    }
}
