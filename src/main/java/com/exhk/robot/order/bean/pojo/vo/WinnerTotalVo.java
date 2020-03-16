package com.exhk.robot.order.bean.pojo.vo;

import lombok.Data;

import java.util.List;

@Data
public class WinnerTotalVo {
    Long total;
    List<WinneringVo> list;
}
