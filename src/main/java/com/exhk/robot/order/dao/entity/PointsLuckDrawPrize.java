package com.exhk.robot.order.dao.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 奖品表
 * </p>
 *
 * @author ${author}
 * @since 2019-11-09
 */
@TableName("points_luck_draw_prize")
public class PointsLuckDrawPrize extends Model<PointsLuckDrawPrize> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 
     * 类型
     * 1:净水机         (每周一个)
     * 2.物业费1000     (0个)
     * 3.购车抵扣卷2000 (0个)
     * 4.299 犀牛卡    (无数个 98%)
     * 5.橄榄油5个        (随机)
     * 6.谢谢参与

     */
    private String name;
    /**
     * 图片地址
     */
    private String url;
    private String value;
    /**
     * 类型1:红包2:积分3:体验金4:谢谢惠顾5:自定义
     */
    private Integer type;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 是否删除
     */
    @TableField("is_del")
    private Integer isDel;
    /**
     * 位置
     */
    private Integer position;
    /**
     * 期数
     */
    private Integer phase;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    /**
     * 概率
     */
    private BigDecimal probability;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getProbability() {
        return probability;
    }

    public void setProbability(BigDecimal probability) {
        this.probability = probability;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "PointsLuckDrawPrize{" +
        ", id=" + id +
        ", name=" + name +
        ", url=" + url +
        ", value=" + value +
        ", type=" + type +
        ", status=" + status +
        ", isDel=" + isDel +
        ", position=" + position +
        ", phase=" + phase +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", probability=" + probability +
        "}";
    }
}
