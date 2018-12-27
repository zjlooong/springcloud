package com.zjl.product.enums;

public enum ResultEnum {
    PRODUCT_NOT_EXIST(0, "商品不存在"),
    PRODUCT_STOCK_ERROR(0, "库存有误"),
            ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
