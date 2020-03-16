package com.exhk.robot.order.bean.pojo.dto.account;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RegistDto {
    @NotEmpty(message = "name不能为空")
    String name;
    /**
     * 手机号
     */
    @NotEmpty(message = "手机号不能为空")
    String  mobile;
    /**
     * 小区名称
     */
    @NotEmpty(message = "小区名称不能为空")
    String community;


    @NotEmpty(message = "城市名称不能为空")
    String city;
    /**
     *
     */
//    String utmQudao;
//    String utmWuye;
//    String utmGuanjia;

    String utm_qudao;
    String utm_wuye;
    String utm_guanjia;



}
