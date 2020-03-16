package com.exhk.robot.order.controller;

import com.exhk.robot.order.bean.exception.AccountStatusException;
import com.exhk.robot.order.bean.pojo.common.JsonResult;
import com.exhk.robot.order.bean.pojo.dto.account.RegistDto;
import com.exhk.robot.order.common.security.annotation.IgnoreUserToken;
import com.exhk.robot.order.service.AccountService;
import com.exhk.robot.order.utils.SzhbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * 下单
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @IgnoreUserToken
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public JsonResult regist(@RequestBody @Valid RegistDto dto, BindingResult bindingResult) throws AccountStatusException {
        SzhbUtil.checkValid(bindingResult);
        return  accountService.regist(dto);

    }

}
