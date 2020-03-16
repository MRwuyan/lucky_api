package com.exhk.robot.order.controller;

import com.exhk.robot.order.bean.exception.AccountStatusException;
import com.exhk.robot.order.bean.pojo.common.JsonResult;
import com.exhk.robot.order.bean.pojo.dto.DoLuckyDto;
import com.exhk.robot.order.bean.pojo.dto.GetLuckyListDto;
import com.exhk.robot.order.bean.pojo.dto.account.RegistDto;
import com.exhk.robot.order.common.security.annotation.IgnoreUserToken;
import com.exhk.robot.order.service.LuckyService;
import com.exhk.robot.order.utils.SzhbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/lucky")
public class LuckyController {
    @Autowired
    LuckyService luckyService;


    @IgnoreUserToken
    @RequestMapping(value = "/doLucky", method = RequestMethod.POST)
    public JsonResult doLucky(@RequestBody @Valid DoLuckyDto dto, BindingResult bindingResult) throws AccountStatusException {
        SzhbUtil.checkValid(bindingResult);
        return  luckyService.doLucky(dto);

    }
    @IgnoreUserToken
    @RequestMapping(value = "/getLuckyList", method = RequestMethod.POST)
    public JsonResult getLuckyList(@RequestBody @Valid GetLuckyListDto dto, BindingResult bindingResult) throws AccountStatusException {
        SzhbUtil.checkValid(bindingResult);
        return  luckyService.getLuckyList(dto);

    }





}
