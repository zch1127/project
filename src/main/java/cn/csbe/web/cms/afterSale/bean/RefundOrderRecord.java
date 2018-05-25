package cn.csbe.web.cms.afterSale.bean;

import java.io.Serializable;
import java.util.Date;

import cn.csbe.web.cms.common.constantUtils;

public class RefundOrderRecord implements Serializable {
	private Integer id;//退款记录日期
	private Integer refundId;//退款记录Id
	private Integer userId;//用户Id;
	private String userName;//卖家买家姓名
	private String refundRecord;//退款说明
	private Date createDate;//记录创建日期
	private String picture;//用户头像
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public RefundOrderRecord(Integer id, Integer refundId, Integer userId,
			String userName, String refundRecord, Date createDate,
			String picture) {
		super();
		this.id = id;
		this.refundId = refundId;
		this.userId = userId;
		this.userName = userName;
		this.refundRecord = refundRecord;
		this.createDate = createDate;
		this.picture = picture;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRefundRecord() {
		return refundRecord;
	}
	public void setRefundRecord(String refundRecord) {
		this.refundRecord = refundRecord;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getRefundId() {
		return refundId;
	}
	public void setRefundId(Integer refundId) {
		this.refundId = refundId;
	}
	public RefundOrderRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RefundOrderRecord(Integer id, String userName, String refundRecord,
			Date createDate, String picture) {
		super();
		this.id = id;
		this.userName = userName;
		this.refundRecord = refundRecord;
		this.createDate = createDate;
		this.picture = picture;
	}
	public RefundOrderRecord(Integer id, Integer refundId, String userName,
			String refundRecord, Date createDate, String picture) {
		super();
		this.id = id;
		this.refundId = refundId;
		this.userName = userName;
		this.refundRecord = refundRecord;
		this.createDate = createDate;
		this.picture = picture;
	}
	
	@Override
	public String toString() {
		return "RefundOrderRecord [id=" + id + ", refundId=" + refundId
				+ ", userId=" + userId + ", userName=" + userName
				+ ", refundRecord=" + refundRecord + ", createDate="
				+ createDate + ", picture=" + picture + "]";
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
}
