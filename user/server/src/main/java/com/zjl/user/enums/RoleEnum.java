package com.zjl.user.enums;

public enum RoleEnum {
    BUYER(0, "买家"),
    SALER(1, "卖家"),
    ;
    private Integer code;
    private String message;

    RoleEnum(Integer code, String message){
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
