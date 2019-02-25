package com.zjl.order.enums;

public enum ExceptionCode {
    PARAM_ERROR(1,"参数错误"),
    ORDER_EMPTY(2,"购物车为空"),
    ORDER_NOT_EXIST(3,"订单不存在"),
    ORDER_STATUS_ERROR(4,"订单状态异常"),
    ORDER_DETAIL_NOT_EXIST(5,"订单详情不存在"),
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
