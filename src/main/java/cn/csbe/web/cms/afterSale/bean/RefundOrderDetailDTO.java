package cn.csbe.web.cms.afterSale.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import cn.csbe.web.cms.common.constantUtils;

public class RefundOrderDetailDTO implements Serializable {
	private Integer id;//退款订单详情Id
	private	String orderSn;//订单编号
	private	String refundNo;//订单编号
	private Integer productId;//商品id
	private String productName;//商品名字
	private String titleImg;//商品图片
	private String createDate;//申请时间
	private Integer userId;
	private String userName;//申请人姓名
	private Integer refundType;//退款类型
	private String contentDesc;//退款原因
	private double productSubtotal;//订单金额
	private BigDecimal refundAmount;//退款金额
	private List<RefundOrderRecord> list;//退款记录
	
	
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getTitleImg() {
		return constantUtils.ImgHtmlPath+titleImg;
	}
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
	public Integer getRefundType() {
		return refundType;
	}
	public void setRefundType(Integer refundType) {
		this.refundType = refundType;
	}
	public String getContentDesc() {
		return contentDesc;
	}
	public void setContentDesc(String contentDesc) {
		this.contentDesc = contentDesc;
	}
	public double getProductSubtotal() {
		return productSubtotal;
	}
	public void setProductSubtotal(double productSubtotal) {
		this.productSubtotal = productSubtotal;
	}
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	public List<RefundOrderRecord> getList() {
		return list;
	}
	public void setList(List<RefundOrderRecord> list) {
		this.list = list;
	}
	
	public String getRefundNo() {
		return refundNo;
	}
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	public RefundOrderDetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RefundOrderDetailDTO [id=" + id + ", orderSn=" + orderSn
				+ ", refundNo=" + refundNo + ", productId=" + productId
				+ ", productName=" + productName + ", titleImg=" + titleImg
				+ ", createDate=" + createDate + ", userId=" + userId
				+ ", userName=" + userName + ", refundType=" + refundType
				+ ", contentDesc=" + contentDesc + ", productSubtotal="
				+ productSubtotal + ", refundAmount=" + refundAmount
				+ ", list=" + list + "]";
	}
	public RefundOrderDetailDTO(Integer id, String orderSn, String refundNo,
			Integer productId, String productName, String titleImg,
			String createDate, Integer userId, String userName,
			Integer refundType, String contentDesc, double productSubtotal,
			BigDecimal refundAmount, List<RefundOrderRecord> list) {
		super();
		this.id = id;
		this.orderSn = orderSn;
		this.refundNo = refundNo;
		this.productId = productId;
		this.productName = productName;
		this.titleImg = titleImg;
		this.createDate = createDate;
		this.userId = userId;
		this.userName = userName;
		this.refundType = refundType;
		this.contentDesc = contentDesc;
		this.productSubtotal = productSubtotal;
		this.refundAmount = refundAmount;
		this.list = list;
	}
	
	

}
