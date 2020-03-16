package com.exhk.robot.order.bean.pojo.dto;

import lombok.Data;

import java.util.List;

@Data
public class PrizePool {
    /**
     * 总池值
     */
    private int total;
    /**
     * 池中的奖品
     */
    private List<PrizePoolBean> poolBeanList;
}
