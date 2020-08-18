package com.hc.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    REGISTER_ERROR(0, "注册失败"),
    ORDER_ERROR(1, "订单异常"),
    CART_ERROR(2, "添加购物车异常"),
    NOT_LOGIN(3, "未登录");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
