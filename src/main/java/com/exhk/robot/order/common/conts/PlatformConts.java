package com.exhk.robot.order.common.conts;

import lombok.Getter;

public interface PlatformConts {
    @Getter
    public enum  交易所{
        OKEX(1,"OKEX"),
        HUOBI(2,"HUOBI"),
        BAN(3,"BAN");
        Integer key;String titleName;
        交易所(Integer key,String titleName){
            this.key=key;
            this.titleName=titleName;
        }

        public static 交易所 getEnumByKey(Integer key){
            交易所[] enums= 交易所.values();
            for (int i = 0; i < enums.length; i++) {
                if (enums[i].getKey() .equals(key)){
                    return  enums[i];
                }
            }
            return null;
        }
    }
}
