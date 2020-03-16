package com.exhk.robot.order.utils;

import java.math.BigDecimal;

public class ComRobotUtil {

    //计算费率

    public static BigDecimal getPowPrice(BigDecimal subSim, BigDecimal setp, Integer num){

          BigDecimal one= BigDecimal.ONE;
          one=   one.add(setp);
          one=one.pow(num);

          BigDecimal sum=subSim.multiply(one);
          return  sum;
    }


    public static void main(String[] args) {
        BigDecimal ss=new BigDecimal("1");
        ss= getPowPrice(ss,new BigDecimal("0.00002"),5);
        System.out.println(ss);

        BigDecimal sssss=new BigDecimal("1.00002");
        System.out.println(sssss.pow(5));

    }


    /**
     *
     *
     *
     *
     */

}
