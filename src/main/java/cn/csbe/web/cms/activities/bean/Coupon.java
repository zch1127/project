package cn.csbe.web.cms.activities.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author: wffu
 * @date:2017-12-11 上午10:35:57
 * @version :
 * 
 */
public class Coupon implements Serializable{
	private Integer id ;//优惠券id
	private String couponName;//优惠券名称
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp startTime;//活动开始时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp endTime;//活动结束时间
	private BigDecimal faceValue;//优惠券面值
	private Integer grantNum; //发放数量
	private Integer limitNum; //每人限领张数
	private Integer usingThreshold;//使用门槛
	private BigDecimal fullAmountReduction;//满减总金额
	private Integer receiveNum;//优惠券领取数量
	private Integer useNum;//优惠券使用数量
	private Integer status;//是否启用 0 不启用   1启用
	private Integer remind;//是否到期提醒
	private Integer activityStatus;//活动状态: 0.未开始 1.已开始 2.已结束
	private Integer userType;//活动状态: 0.未开始 1.已开始 2.已结束
	private String createDate;//活动状态: 0.未开始 1.已开始 2.已结束
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", couponName=" + couponName
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", faceValue=" + faceValue + ", grantNum=" + grantNum
				+ ", limitNum=" + limitNum + ", usingThreshold="
				+ usingThreshold + ", fullAmountReduction="
				+ fullAmountReduction + ", receiveNum=" + receiveNum
				+ ", useNum=" + useNum + ", status=" + status + ", remind="
				+ remind + ", activityStatus=" + activityStatus + ", userType="
				+ userType + ", createDate=" + createDate + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public BigDecimal getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(BigDecimal faceValue) {
		this.faceValue = faceValue;
	}
	public Integer getGrantNum() {
		return grantNum;
	}
	public void setGrantNum(Integer grantNum) {
		this.grantNum = grantNum;
	}
	public Integer getLimitNum() {
		return limitNum;
	}
	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}
	public Integer getUsingThreshold() {
		return usingThreshold;
	}
	public void setUsingThreshold(Integer usingThreshold) {
		this.usingThreshold = usingThreshold;
	}
	public BigDecimal getFullAmountReduction() {
		return fullAmountReduction;
	}
	public void setFullAmountReduction(BigDecimal fullAmountReduction) {
		this.fullAmountReduction = fullAmountReduction;
	}
	public Integer getReceiveNum() {
		return receiveNum;
	}
	public void setReceiveNum(Integer receiveNum) {
		this.receiveNum = receiveNum;
	}
	public Integer getUseNum() {
		return useNum;
	}
	public void setUseNum(Integer useNum) {
		this.useNum = useNum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRemind() {
		return remind;
	}
	public void setRemind(Integer remind) {
		this.remind = remind;
	}
	public Integer getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(Integer activityStatus) {
		this.activityStatus = activityStatus;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Coupon(Integer id, String couponName, Timestamp startTime,
			Timestamp endTime, BigDecimal faceValue, Integer grantNum,
			Integer limitNum, Integer usingThreshold,
			BigDecimal fullAmountReduction, Integer receiveNum, Integer useNum,
			Integer status, Integer remind, Integer activityStatus,
			Integer userType, String createDate) {
		super();
		this.id = id;
		this.couponName = couponName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.faceValue = faceValue;
		this.grantNum = grantNum;
		this.limitNum = limitNum;
		this.usingThreshold = usingThreshold;
		this.fullAmountReduction = fullAmountReduction;
		this.receiveNum = receiveNum;
		this.useNum = useNum;
		this.status = status;
		this.remind = remind;
		this.activityStatus = activityStatus;
		this.userType = userType;
		this.createDate = createDate;
	}
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
