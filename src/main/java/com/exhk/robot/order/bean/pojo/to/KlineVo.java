package com.exhk.robot.order.bean.pojo.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class KlineVo {

    private String symbolName;
    /**
     * 开始时间
     */
    private Date time;
    /**
     * 开盘价格
     */
    private BigDecimal open;
    /**
     * 最高价
     */
    private BigDecimal high;
    /**
     * 最低价
     */
    private BigDecimal low;
    /**
     * 收盘价
     */
    private BigDecimal close;
    /**
     * 交易量
     */
    private BigDecimal volume;
}
