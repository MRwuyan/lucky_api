package com.exhk.robot.order.bean.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class RatePrice {

    String url;

    static BigDecimal rate105 = new BigDecimal(1.05);
    static BigDecimal rate110 = new BigDecimal(1.1);
    static BigDecimal rate120 = new BigDecimal(1.20);

    static BigDecimal rate095 = new BigDecimal(0.95);
    static BigDecimal rate090 = new BigDecimal(0.9);
    static BigDecimal rate080 = new BigDecimal(0.80);

    BigDecimal basePrice;

    String coinName;

    Integer 小数位数;




    public RatePrice(BigDecimal basePrice, String coinName ,Integer 小数位数) {
        this.basePrice = basePrice;
        this.coinName = coinName;
        this.小数位数=小数位数;
    }


    public BigDecimal get105() {
        return basePrice.multiply(rate105).setScale(小数位数,BigDecimal.ROUND_HALF_UP);
    }


    public BigDecimal get110() {
        return basePrice.multiply(rate110).setScale(小数位数,BigDecimal.ROUND_HALF_UP);
    }


    public BigDecimal get120() {
        return basePrice.multiply(rate120).setScale(小数位数,BigDecimal.ROUND_HALF_UP);
    }


    public BigDecimal get095() {
        return basePrice.multiply(rate095).setScale(小数位数,BigDecimal.ROUND_HALF_UP);
    }


    public BigDecimal get090() {
        return basePrice.multiply(rate090).setScale(小数位数,BigDecimal.ROUND_HALF_UP);
    }


    public BigDecimal get080() {
        return basePrice.multiply(rate080).setScale(小数位数,BigDecimal.ROUND_HALF_UP);
    }

}
