package com.exhk.robot.order.bean.pojo.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrderTotalVo {
    long total;
    List<OrderVo> list;
}
