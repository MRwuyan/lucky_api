package com.exhk.robot.order.bean;

import lombok.Data;

@Data
public class AppQuartz {

    private Integer quartzId;  //id  主键
    private String jobName;  //任务名称
    private String jobGroup;  //任务分组
    private String startTime;  //任务开始时间
    private String cronExpression;  //corn表达式
    private String invokeParam;//需要传递的参数



}
