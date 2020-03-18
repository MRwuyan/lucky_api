package com.exhk.robot.order.controller;

import com.exhk.robot.order.common.security.annotation.IgnoreUserToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/zuulTest")
public class ZuulTestController {

    @IgnoreUserToken
    @RequestMapping("a")
    @ResponseBody
    private String getString(){
        log.error("ssssssssssssssss");
        return "sssss";
    }
}
