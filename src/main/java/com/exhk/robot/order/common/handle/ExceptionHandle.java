package com.exhk.robot.order.common.handle;

import com.exhk.robot.order.bean.exception.CommonException;
import com.exhk.robot.order.bean.exception.TestException;
import com.exhk.robot.order.bean.pojo.common.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Barry on 2018/7/18.
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    //统一处理了，所有Ctroller 的异常都在这里处理
    @ExceptionHandler(value = TestException.class)
    @ResponseBody
    public JsonResult handle(Exception e){
        return JsonResult.createFalied(e.hashCode());
    }


    //统一处理了，所有Ctroller 的异常都在这里处理
    @ExceptionHandler(value = CommonException.class)
    @ResponseBody
    public JsonResult handle3(CommonException e){
        return JsonResult.createFalied(e.getCode(),e.getMessage() );
    }



    @ExceptionHandler(value =  Exception.class)
    @ResponseBody
    public JsonResult handle2(Exception e){
        log.error(e.getMessage(),e);
        return JsonResult.createFalied( e.getMessage() );
    }

}
