package com.exhk.robot.order.common.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by Barry on 2018/7/18.
 */
@Aspect
@Slf4j
@Component
@Profile({"dev","test"})//只在开发和测试环境开启
public class HttpAspect {

    @Pointcut("execution( public  * net.bit1.api.controller..*Controller .*(..))")
    public void log(){
    }

    @After("log()")
    public void doAfter(){

    }

    @AfterReturning(pointcut = "log()",returning = "object")
    public void afterReturning(Object object){


    }
   // @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        log.info("1");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录请求路径url
        log.error("url={}",request.getRequestURL());

        //记录请求方式method
        log.error("method={}",request.getMethod());

        Enumeration<String> enumeration= request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String header=enumeration.nextElement();
            log.error("header:"+ header+"  value:"+request.getHeader(header));
        }


        //记录访问者ip
        log.error("ip={}",request.getRemoteAddr());

        //记录访问的类方法
        log.error("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //记录传递的参数
        try {
            log.error("args:"+ JSON.toJSONString(joinPoint.getArgs()));
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
