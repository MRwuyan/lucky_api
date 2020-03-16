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
 * 用户表
 * </p>
 *
 * @author ${author}
 * @since 2019-11-10
 */
@TableName("t_account")
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    /**
     * 手机号
     */
    private String mobile;

    private String city;
    /**
     * 小区名称
     */
    private String community;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 渠道
     */
    @TableField("utm_qudao")
    private String utmQudao;
    /**
     * 0.否
1.是
     */
    @TableField("is_lucky")
    private Integer isLucky;
    private String token;
    @TableField("utm_wuye")
    private String utmWuye;
    @TableField("utm_guanjia")
    private String utmGuanjia;


    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUtmQudao() {
        return utmQudao;
    }

    public void setUtmQudao(String utmQudao) {
        this.utmQudao = utmQudao;
    }

    public Integer getIsLucky() {
        return isLucky;
    }

    public void setIsLucky(Integer isLucky) {
        this.isLucky = isLucky;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUtmWuye() {
        return utmWuye;
    }

    public void setUtmWuye(String utmWuye) {
        this.utmWuye = utmWuye;
    }

    public String getUtmGuanjia() {
        return utmGuanjia;
    }

    public void setUtmGuanjia(String utmGuanjia) {
        this.utmGuanjia = utmGuanjia;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Account{" +
        ", id=" + id +
        ", name=" + name +
        ", mobile=" + mobile +
        ", community=" + community +
        ", createTime=" + createTime +
        ", utmQudao=" + utmQudao +
        ", isLucky=" + isLucky +
        ", token=" + token +
        ", utmWuye=" + utmWuye +
        ", utmGuanjia=" + utmGuanjia +
        "}";
    }
}
