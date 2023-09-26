package org.wanbang.test1.eduorder.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 财务系统 - 订单表(EduOrder)实体类
 *
 * @author makejava
 * @since 2022-04-28 20:02:51
 */
public class EduOrder implements Serializable {
    private static final long serialVersionUID = 806424961057951105L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 平台id
    */
    private String platformId;
    /**
    * 平台名称
    */
    private String platformName;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 用户名称
    */
    private String userName;
    /**
    * 送货地址
    */
    private String deliveryAddress;
    /**
    * 订单号
    */
    private String orderNo;
    /**
    * 外部订单号
    */
    private String outOrderNo;
    /**
    * 订单状态（1：…）
    */
    private Object status;
    /**
    * 送货状态（1：…）
    */
    private Object deliveryStatus;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 创建人
    */
    private String creator;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Object deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

}