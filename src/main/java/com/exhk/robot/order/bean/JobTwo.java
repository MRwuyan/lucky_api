//package com.exhk.robot.order.bean;
//
//import org.quartz.*;
//import org.springframework.stereotype.Component;
//
//@PersistJobDataAfterExecution
//@DisallowConcurrentExecution
//@Component
//public class JobTwo implements Job{
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        JobDataMap data=context.getTrigger().getJobDataMap();
//        String invokeParam =(String) data.get("invokeParam");
//        //在这里实现业务逻辑
//    }
//}