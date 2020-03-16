package com.exhk.robot.order.common.mybatis;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class CustomMetaObjectHandler extends MetaObjectHandler {

    private static final String createTimeStr="createTime";
    private static final String modifyTimeStr="modifyTime";

    /**
     * 新建时自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {

        Object createTime =getFieldValByName(createTimeStr,metaObject);
        Object modifyTime =getFieldValByName(modifyTimeStr,metaObject);
        if (createTime==null) {
            setFieldValByName(createTimeStr, new Date(),metaObject);
        }
        if (modifyTime==null) {
            setFieldValByName(modifyTimeStr,  new Date(),metaObject);
        }
    }

    //修改时候自动填充
    @Override
    public void updateFill(MetaObject metaObject) {
        Object modifyTime =getFieldValByName(modifyTimeStr,metaObject);
        if (modifyTime==null) {
            setFieldValByName(modifyTimeStr,  new Date(),metaObject);
        }
    }

    //开启自动填充
    @Override
    public boolean openUpdateFill() {
        return true;
    }
}
