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
 * 抽奖记录表
 * </p>
 *
 * @author ${author}
 * @since 2019-11-09
 */
@TableName("points_luck_draw_record")
public class PointsLuckDrawRecord extends Model<PointsLuckDrawRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户ID
     */
    @TableField("member_id")
    private Long memberId;
    /**
     * 中奖用户手机号
     */
    @TableField("member_mobile")
    private String memberMobile;
    /**
     * 消耗积分
     */
    private Integer points;
    /**
     * 奖品ID
     */
    @TableField("prize_id")
    private Long prizeId;
    /**
     * 1:中奖 2:未中奖
     */
    private Integer result;
    /**
     * 中奖月份
     */
    private String month;
    /**
     * 中奖日期（不包括时间）
     */
    private Date daily;
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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Date getDaily() {
        return daily;
    }

    public void setDaily(Date daily) {
        this.daily = daily;
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
        return "PointsLuckDrawRecord{" +
        ", id=" + id +
        ", memberId=" + memberId +
        ", memberMobile=" + memberMobile +
        ", points=" + points +
        ", prizeId=" + prizeId +
        ", result=" + result +
        ", month=" + month +
        ", daily=" + daily +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
