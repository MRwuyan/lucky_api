package com.exhk.robot.order.bean.exception;

import lombok.Data;

@Data
public class CommonException extends Exception {

    public Integer code;
    public String message;

    public CommonException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
