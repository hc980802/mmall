package com.hc.exception;

import com.hc.enums.ResultEnum;

public class MallException extends RuntimeException {
    public MallException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }
}
