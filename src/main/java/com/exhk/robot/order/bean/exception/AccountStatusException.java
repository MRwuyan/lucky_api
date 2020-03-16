package com.exhk.robot.order.bean.exception;


/**
 * 账户状态的异常
 */
public class AccountStatusException extends CommonException{

    public AccountStatusException(Integer code, String message) {
        super(code, message);
    }
    //错误抛出，处理业务不同的错误

}
