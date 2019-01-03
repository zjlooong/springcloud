package com.zjl.order.request;

import javax.validation.constraints.NotEmpty;

public class OrderRequest {

    @NotEmpty(message = "姓名")
    private String name;

    @NotEmpty(message = "手机")
    private String phone;

    @NotEmpty(message = "地址")
    private String address;

    @NotEmpty(message = "openid")
    private String openid;

    @NotEmpty(message = "购物车")
    private String items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
