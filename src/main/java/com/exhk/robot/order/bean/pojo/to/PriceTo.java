package com.exhk.robot.order.bean.pojo.to;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceTo {
    private BigDecimal cny;
    private BigDecimal usd;
    private BigDecimal rate;
}
