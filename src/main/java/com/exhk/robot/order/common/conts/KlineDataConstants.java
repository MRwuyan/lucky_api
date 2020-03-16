package com.exhk.robot.order.common.conts;

import lombok.Getter;

public interface KlineDataConstants {

      @Getter
      enum K线类型 {
        _1m("1m",60),
        _3m("3m",180 ),
        _5m("5m",300 ),
        _15m("15m",900 ),
        _30m("30m",1800 ),
        _1h("1h",3600 ),
        _2h("2h",7200 ),
        _4h("4h",14400 ),
        _6h("6h",21600 ),
        _12h("12h",43200 ),
        _1d("1d",86400 ),
        _1W("1W",604800);

        String key;

        Integer num;
        K线类型(  String key,Integer num) {
            this.key = key;
            this.num=num;
        }


      public static KlineDataConstants.K线类型 getEnumByKey(String key){
          KlineDataConstants.K线类型[] enums= KlineDataConstants.K线类型.values();
        for (int i = 0; i < enums.length; i++) {
          if (enums[i].getKey() .equals(key)){
            return  enums[i];
          }
        }
        return null;
      }
    }
}
