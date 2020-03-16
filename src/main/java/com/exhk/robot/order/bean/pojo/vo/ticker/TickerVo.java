package com.exhk.robot.order.bean.pojo.vo.ticker;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TickerVo {
    /**
     * 最新价
     */
    BigDecimal newPrice;
    /**
     * 24小时开盘
     */
    BigDecimal open24h;
    /**
     * 24小时最高
     */
    BigDecimal high24h;
    /**
     * 24h最低
     */
    BigDecimal low24h;
    /**
     *  	24小时成交量，按交易货币统计
     */
    BigDecimal baseVolume24h;
    /**
     * 	24小时成交量，按计价货币统计
     */
    BigDecimal quoteVolume24h;
    BigDecimal cny;
    BigDecimal gains;

    Date createTime;
}
