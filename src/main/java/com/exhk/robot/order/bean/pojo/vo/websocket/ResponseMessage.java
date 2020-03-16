package com.exhk.robot.order.bean.pojo.vo.websocket;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Barry on 2018/9/28.
 */
@Getter
@Setter
public class ResponseMessage<T> implements Serializable {

    //一个是事件
    String event;

    /* 数据对象 */
    private T data = null;
}
