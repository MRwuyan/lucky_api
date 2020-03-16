package com.exhk.robot.order.bean.pojo.dto;

import lombok.Data;

@Data
public class PrizePoolBean {
    /**
     * 数据库中真实奖品的ID
     */
    private Long id;
    /**
     * 奖品的开始池值
     */
    private int begin;
    /**
     * 奖品的结束池值
     */
    private int end;
}
