package com.exhk.robot.order.bean.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author ${author}
 * @since 2019-03-26
 */
@Data
public class OrderVo {

    private  Integer  id;
    /**
     * 交易货币
     */
    private Integer symbolDefineId;
    /**
     * 币种
     */
    private Integer coinDefineId;
    /**
     * 基础币种
     */
    private Integer baseCoinDefineId;
    /**
     * 类型
1.买入
2.卖出
     */
    private Integer type;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 数量
     */
    private BigDecimal volume;
    /**
     * 剩余数量
     */
    private BigDecimal remainVolume;
    /**
     * 成交数量
     */
    private BigDecimal dealVolume ;
    /**
     * __，成交价格，已废弃
     */
    private BigDecimal dealPrice;
    /**
     * 成交金额，订单总金额
     */
    private BigDecimal amount;
    /**
     * 状态
1.待成交
2.部分成交
3.全部成交
4.未成交撤单
5.部分成交撤单
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;

    private String createTimeStr;
    /**
     * 更新时间
     */
    private Date updateTime;

    String updateTimeStr;

    /**
     * 交易对名称
     */
    private String symbolDefineName;
    /**
     * 已成交的总价
     */
    private BigDecimal dealAmount;

}
