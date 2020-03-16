package com.exhk.robot.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//开启异步调用功能
@EnableAsync
@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
@EnableScheduling
@ServletComponentScan
@ComponentScan(basePackages = {"com.exhk.robot"})
@EnableSwagger2
@EnableTransactionManagement
//实用aop
//@EnableAspectJAutoProxy(exposeProxy = true)
public class Robot3KlineApp {
	public static void main(String[] args) {
		SpringApplication.run(Robot3KlineApp.class, args);

	}
}