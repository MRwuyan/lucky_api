package com.exhk.robot.order.dao.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 抽奖概率限制表
 * </p>
 *
 * @author ${author}
 * @since 2019-11-09
 */
@TableName("points_luck_draw_probability")
public class PointsLuckDrawProbability extends Model<PointsLuckDrawProbability> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 奖品ID
     */
    @TableField("points_prize_id")
    private Long pointsPrizeId;
    /**
     * 奖品期数
     */
    @TableField("points_prize_phase")
    private Integer pointsPrizePhase;
    /**
     * 概率
     */
    private Float probability;
    /**
     * 商品抽中后的冷冻次数
     */
    private Integer frozen;
    /**
     * 该商品平台每天最多抽中的次数
     */
    @TableField("prize_day_max_times")
    private Integer prizeDayMaxTimes;
    /**
     * 每位用户每月最多抽中该商品的次数
     */
    @TableField("user_prize_month_max_times")
    private Integer userPrizeMonthMaxTimes;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPointsPrizeId() {
        return pointsPrizeId;
    }

    public void setPointsPrizeId(Long pointsPrizeId) {
        this.pointsPrizeId = pointsPrizeId;
    }

    public Integer getPointsPrizePhase() {
        return pointsPrizePhase;
    }

    public void setPointsPrizePhase(Integer pointsPrizePhase) {
        this.pointsPrizePhase = pointsPrizePhase;
    }

    public Float getProbability() {
        return probability;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }

    public Integer getFrozen() {
        return frozen;
    }

    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }

    public Integer getPrizeDayMaxTimes() {
        return prizeDayMaxTimes;
    }

    public void setPrizeDayMaxTimes(Integer prizeDayMaxTimes) {
        this.prizeDayMaxTimes = prizeDayMaxTimes;
    }

    public Integer getUserPrizeMonthMaxTimes() {
        return userPrizeMonthMaxTimes;
    }

    public void setUserPrizeMonthMaxTimes(Integer userPrizeMonthMaxTimes) {
        this.userPrizeMonthMaxTimes = userPrizeMonthMaxTimes;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "PointsLuckDrawProbability{" +
        ", id=" + id +
        ", pointsPrizeId=" + pointsPrizeId +
        ", pointsPrizePhase=" + pointsPrizePhase +
        ", probability=" + probability +
        ", frozen=" + frozen +
        ", prizeDayMaxTimes=" + prizeDayMaxTimes +
        ", userPrizeMonthMaxTimes=" + userPrizeMonthMaxTimes +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
