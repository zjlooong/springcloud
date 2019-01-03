package com.zjl.order.enums;

public enum ExceptionCode {
    PARAM_ERROR(1,"参数错误"),
    ORDER_EMPTY(2,"购物车为空"),
    ;
    private Integer code;
    private String message;

    ExceptionCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
