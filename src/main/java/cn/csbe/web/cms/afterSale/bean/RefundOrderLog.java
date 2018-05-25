package cn.csbe.web.cms.afterSale.bean;

import java.io.Serializable;
import java.util.Date;
	
public class RefundOrderLog implements Serializable{
	private Integer id;//退款记录Id
	private Integer refundId;//退款主键id
	private Integer userId;//用户Id
	private String refundRecord;//退款说明
	private Date createDate;//创建时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRefundId() {
		return refundId;
	}
	public void setRefundId(Integer refundId) {
		this.refundId = refundId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	@Override
	public String toString() {
		return "RefundOrderLog [id=" + id + ", refundId=" + refundId
				+ ", userId=" + userId + ", refundRecord=" + refundRecord
				+ ", createDate=" + createDate + "]";
	}
	public RefundOrderLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RefundOrderLog(Integer id, Integer refundId, Integer userId,
			String refundRecord, Date createDate) {
		super();
		this.id = id;
		this.refundId = refundId;
		this.userId = userId;
		this.refundRecord = refundRecord;
		this.createDate = createDate;
	}
	
}
