package cn.csbe.web.cms.afterSale.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.csbe.web.cms.common.constantUtils;

public class RefundOrder implements Serializable {
	private Integer id;//退款ID
	private String batchNo;//退款批次号
	private String refundNo;//退款编号，用于支付接口回调
	private Integer refundType;//0 退货退款   1仅退款
	private Integer orderMasterId;//主订单ID,对应于主订单order_master_info的Id
	private String orderMasterSn;//主订单编号
	private Integer orderDetailsId;//订单详情Id,对应于订单详情表order_details的Id
	private Integer userId;//用户主 键Id
	private BigDecimal refundAmount;//应退款金额
	private String contentDesc;//退款说明描述
	private String refundReason;//退款原因
	private String evidenceImgPath;//凭证图片路径
	private Integer approveStatus;//审批状态 0.申请退款 1.商家审批通过 2.退款关闭(取消退款/商家拒绝) 3.退款成功
	private Integer status;//使用状态 0.停用 1.启用  删除时停用
	private Date finishDate;//退款完成时间
	private Date createDate;//退款创建时间
	private Date modifyDate;//修改时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getRefundNo() {
		return refundNo;
	}
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	public Integer getRefundType() {
		return refundType;
	}
	public void setRefundType(Integer refundType) {
		this.refundType = refundType;
	}
	public Integer getOrderMasterId() {
		return orderMasterId;
	}
	public void setOrderMasterId(Integer orderMasterId) {
		this.orderMasterId = orderMasterId;
	}
	public String getOrderMasterSn() {
		return orderMasterSn;
	}
	public void setOrderMasterSn(String orderMasterSn) {
		this.orderMasterSn = orderMasterSn;
	}
	public Integer getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(Integer orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getContentDesc() {
		return contentDesc;
	}
	public void setContentDesc(String contentDesc) {
		this.contentDesc = contentDesc;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public String getEvidenceImgPath() {
		return constantUtils.ImgHtmlPath+evidenceImgPath;
	}
	public void setEvidenceImgPath(String evidenceImgPath) {
		this.evidenceImgPath = evidenceImgPath;
	}
	public Integer getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(Integer approveStatus) {
		this.approveStatus = approveStatus;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "RefundOrder [id=" + id + ", batchNo=" + batchNo + ", refundNo="
				+ refundNo + ", refundType=" + refundType + ", orderMasterId="
				+ orderMasterId + ", orderMasterSn=" + orderMasterSn
				+ ", orderDetailsId=" + orderDetailsId + ", userId=" + userId
				+ ", refundAmount=" + refundAmount + ", contentDesc="
				+ contentDesc + ", refundReason=" + refundReason
				+ ", evidenceImgPath=" + evidenceImgPath + ", approveStatus="
				+ approveStatus + ", status=" + status + ", finishDate="
				+ finishDate + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + "]";
	}
	public RefundOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RefundOrder(Integer id, String batchNo, String refundNo,
			Integer refundType, Integer orderMasterId, String orderMasterSn,
			Integer orderDetailsId, Integer userId, BigDecimal refundAmount,
			String contentDesc, String refundReason, String evidenceImgPath,
			Integer approveStatus, Integer status, Date finishDate,
			Date createDate, Date modifyDate) {
		super();
		this.id = id;
		this.batchNo = batchNo;
		this.refundNo = refundNo;
		this.refundType = refundType;
		this.orderMasterId = orderMasterId;
		this.orderMasterSn = orderMasterSn;
		this.orderDetailsId = orderDetailsId;
		this.userId = userId;
		this.refundAmount = refundAmount;
		this.contentDesc = contentDesc;
		this.refundReason = refundReason;
		this.evidenceImgPath = evidenceImgPath;
		this.approveStatus = approveStatus;
		this.status = status;
		this.finishDate = finishDate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	
}
