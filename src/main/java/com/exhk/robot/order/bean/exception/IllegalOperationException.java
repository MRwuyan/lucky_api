package com.exhk.robot.order.bean.exception;




public class IllegalOperationException extends CommonException{


    public IllegalOperationException(Integer code, String message) {
        super(code, message);
    }
}
