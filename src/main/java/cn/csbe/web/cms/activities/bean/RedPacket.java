package cn.csbe.web.cms.activities.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author: wffu
 * @date:2017-12-11 上午10:38:56
 * @version :
 * 
 */
public class RedPacket implements Serializable {
	private Integer id;//红包id
	private String redPacketName;//红包名称
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp startTime;//开始时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp endTime;//结束时间
	private BigDecimal maxFaceValue;//红包最大面额
	private BigDecimal minFaceValue;//红包最小面额
	private BigDecimal predictAmount;//预发放金额
	private BigDecimal receiveAmount;//已领取总金额
	private Integer receivePeoples;;//领取人数
	private Integer withDrawPeoples;//使用人数
	private Integer status;//是否启用 0 不启用   1启用
	private Integer activityStatus;//活动状态: 0.未开始 1.已开始 2.已结束
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRedPacketName() {
		return redPacketName;
	}
	public void setRedPacketName(String redPacketName) {
		this.redPacketName = redPacketName;
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
	public BigDecimal getMaxFaceValue() {
		return maxFaceValue;
	}
	public void setMaxFaceValue(BigDecimal maxFaceValue) {
		this.maxFaceValue = maxFaceValue;
	}
	public BigDecimal getMinFaceValue() {
		return minFaceValue;
	}
	public void setMinFaceValue(BigDecimal minFaceValue) {
		this.minFaceValue = minFaceValue;
	}
	public BigDecimal getPredictAmount() {
		return predictAmount;
	}
	public void setPredictAmount(BigDecimal predictAmount) {
		this.predictAmount = predictAmount;
	}
	public BigDecimal getReceiveAmount() {
		return receiveAmount;
	}
	public void setReceiveAmount(BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}
	public Integer getReceivePeoples() {
		return receivePeoples;
	}
	public void setReceivePeoples(Integer receivePeoples) {
		this.receivePeoples = receivePeoples;
	}
	public Integer getWithDrawPeoples() {
		return withDrawPeoples;
	}
	public void setWithDrawPeoples(Integer withDrawPeoples) {
		this.withDrawPeoples = withDrawPeoples;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(Integer activityStatus) {
		this.activityStatus = activityStatus;
	}
	@Override
	public String toString() {
		return "RedPacket [id=" + id + ", redPacketName=" + redPacketName
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", maxFaceValue=" + maxFaceValue + ", minFaceValue="
				+ minFaceValue + ", predictAmount=" + predictAmount
				+ ", receiveAmount=" + receiveAmount + ", receivePeoples="
				+ receivePeoples + ", withDrawPeoples=" + withDrawPeoples
				+ ", status=" + status + ", activityStatus=" + activityStatus
				+ "]";
	}
	public RedPacket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RedPacket(Integer id, String redPacketName, Timestamp startTime,
			Timestamp endTime, BigDecimal maxFaceValue,
			BigDecimal minFaceValue, BigDecimal predictAmount,
			BigDecimal receiveAmount, Integer receivePeoples,
			Integer withDrawPeoples, Integer status, Integer activityStatus) {
		super();
		this.id = id;
		this.redPacketName = redPacketName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.maxFaceValue = maxFaceValue;
		this.minFaceValue = minFaceValue;
		this.predictAmount = predictAmount;
		this.receiveAmount = receiveAmount;
		this.receivePeoples = receivePeoples;
		this.withDrawPeoples = withDrawPeoples;
		this.status = status;
		this.activityStatus = activityStatus;
	}
}
