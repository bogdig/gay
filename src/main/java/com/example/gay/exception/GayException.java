package com.example.gay.exception;

import com.example.gay.enums.ResultEnum;

public class GayException extends RuntimeException {

    private Integer code;

    public GayException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
