package cn.csbe.web.cms.afterSale.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import cn.csbe.web.cms.common.constantUtils;

public class RefundOrderDTO implements Serializable {
	private Integer id;//退款ID
	private String batchNo;//退款批次号
	private String refundNo;//退款编号
	private Integer refundType;//0 退货退款   1仅退款
	private Integer userId;//用户主 键Id
	private BigDecimal refundAmount;//应退款金额
	private String contentDesc;//退款说明描述
	private String evidenceImgPath;//凭证图片路径
	private Integer approveStatus;//审批状态 0.申请退款 1.商家审批通过 2.退款关闭(取消退款/商家拒绝) 3.退款成功
	private Integer status;//使用状态 0.停用 1.启用  删除时停用
	private Timestamp finishDate;//退款完成时间
	private Timestamp createDate;//退款创建时间
	private Timestamp modifyDate;//修改时间
	private String orderSn;//订单编号
	private BigDecimal productSubtotal;//小计金额
	private BigDecimal productPrice;//商品单价
	private Integer productNum;//商品数量
	private String receiptPersonMobile;//收件人电话
	private String receiptPersonName;//收件人姓名
	private String receiptDetailedAddress;//收件人地址
	private String imgUrl;//图片路径
	private String productName;//商品名称
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
	public Timestamp getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Timestamp finishDate) {
		this.finishDate = finishDate;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public BigDecimal getProductSubtotal() {
		return productSubtotal;
	}
	public void setProductSubtotal(BigDecimal productSubtotal) {
		this.productSubtotal = productSubtotal;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductNum() {
		return productNum;
	}
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}
	public String getReceiptPersonMobile() {
		return receiptPersonMobile;
	}
	public void setReceiptPersonMobile(String receiptPersonMobile) {
		this.receiptPersonMobile = receiptPersonMobile;
	}
	public String getReceiptPersonName() {
		return receiptPersonName;
	}
	public void setReceiptPersonName(String receiptPersonName) {
		this.receiptPersonName = receiptPersonName;
	}
	public String getReceiptDetailedAddress() {
		return receiptDetailedAddress;
	}
	public void setReceiptDetailedAddress(String receiptDetailedAddress) {
		this.receiptDetailedAddress = receiptDetailedAddress;
	}
	public String getImgUrl() {
		//return imgUrl;
		if(StringUtils.isEmpty(imgUrl)){
			return imgUrl;
		}else{
			return constantUtils.ImgHtmlPath+"images/"+imgUrl;
			//return "http://60.205.152.224:8091/buddha-img/images/"+imgUrl;
		}
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "RefundOrderDTO [id=" + id + ", batchNo=" + batchNo
				+ ", refundNo=" + refundNo + ", refundType=" + refundType
				+ ", userId=" + userId + ", refundAmount=" + refundAmount
				+ ", contentDesc=" + contentDesc + ", evidenceImgPath="
				+ evidenceImgPath + ", approveStatus=" + approveStatus
				+ ", status=" + status + ", finishDate=" + finishDate
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ ", orderSn=" + orderSn + ", productSubtotal="
				+ productSubtotal + ", productPrice=" + productPrice
				+ ", productNum=" + productNum + ", receiptPersonMobile="
				+ receiptPersonMobile + ", receiptPersonName="
				+ receiptPersonName + ", receiptDetailedAddress="
				+ receiptDetailedAddress + ", imgUrl=" + imgUrl
				+ ", productName=" + productName + "]";
	}
	public RefundOrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RefundOrderDTO(Integer id, String batchNo, String refundNo,
			Integer refundType, Integer userId, BigDecimal refundAmount,
			String contentDesc, String evidenceImgPath, Integer approveStatus,
			Integer status, Timestamp finishDate, Timestamp createDate,
			Timestamp modifyDate, String orderSn, BigDecimal productSubtotal,
			BigDecimal productPrice, Integer productNum,
			String receiptPersonMobile, String receiptPersonName,
			String receiptDetailedAddress, String imgUrl, String productName) {
		super();
		this.id = id;
		this.batchNo = batchNo;
		this.refundNo = refundNo;
		this.refundType = refundType;
		this.userId = userId;
		this.refundAmount = refundAmount;
		this.contentDesc = contentDesc;
		this.evidenceImgPath = evidenceImgPath;
		this.approveStatus = approveStatus;
		this.status = status;
		this.finishDate = finishDate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.orderSn = orderSn;
		this.productSubtotal = productSubtotal;
		this.productPrice = productPrice;
		this.productNum = productNum;
		this.receiptPersonMobile = receiptPersonMobile;
		this.receiptPersonName = receiptPersonName;
		this.receiptDetailedAddress = receiptDetailedAddress;
		this.imgUrl = imgUrl;
		this.productName = productName;
	}
	
	
}
