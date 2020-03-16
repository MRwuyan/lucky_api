package com.exhk.robot.order.bean.pojo.to;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class SymbolTo {
    private Tick tick;
    @Setter
    @Getter
    class Tick {
        List<Data> data;
        @Setter
        @Getter
        class Data {
            private BigDecimal price;
        }
    }
}
