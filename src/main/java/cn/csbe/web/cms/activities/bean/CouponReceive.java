package cn.csbe.web.cms.activities.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author: wffu
 * @date:2017-12-11 上午10:37:19
 * @version :
 * 
 */  
public class CouponReceive implements Serializable {
	private Integer id;//优惠券领用id
	private Integer userId;//所属用户
	private String userName;//用户姓名
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp receivedTime;//领用时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp useTime;//使用时间
	private Integer useType;//使用方式   1.提现，2.其他
	private Integer useStatus;//使用状态  0.未使用，1.已使用，2.已失效
	private Integer couponId;//所属优惠券Id
	private Integer orderId;//所属订单id
	@Override
	public String toString() {
		return "CouponReceive [id=" + id + ", userId=" + userId + ", userName="
				+ userName + ", receivedTime=" + receivedTime + ", useTime="
				+ useTime + ", useType=" + useType + ", useStatus=" + useStatus
				+ ", couponId=" + couponId + ", orderId=" + orderId + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getReceivedTime() {
		return receivedTime;
	}
	public void setReceivedTime(Timestamp receivedTime) {
		this.receivedTime = receivedTime;
	}
	public Timestamp getUseTime() {
		return useTime;
	}
	public void setUseTime(Timestamp useTime) {
		this.useTime = useTime;
	}
	public Integer getUseType() {
		return useType;
	}
	public void setUseType(Integer useType) {
		this.useType = useType;
	}
	public Integer getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public CouponReceive(Integer id, Integer userId, String userName,
			Timestamp receivedTime, Timestamp useTime, Integer useType,
			Integer useStatus, Integer couponId, Integer orderId) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.receivedTime = receivedTime;
		this.useTime = useTime;
		this.useType = useType;
		this.useStatus = useStatus;
		this.couponId = couponId;
		this.orderId = orderId;
	}
	public CouponReceive() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
