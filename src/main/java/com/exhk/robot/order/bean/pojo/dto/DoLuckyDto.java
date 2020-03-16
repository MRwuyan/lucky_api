package com.exhk.robot.order.bean.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DoLuckyDto {

    @NotEmpty(message = "手机号不能为空")
    private String token;
}
