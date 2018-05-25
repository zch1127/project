package cn.csbe.web.cms.order.bean;

/*
 * 订单详情
 */
public class OrderDetail {
	private Integer id;
	private Integer productId;//商品id
	private String productName;//商品名字
	private double productPrice;//商品价格
	private Integer productNum;//商品数量
	private double productSubtotal;//小计金额  单个商品的总价
	private Integer orderMasterId;//主订单id
	private Integer userId;//下单用户id
	private Integer commentStatus; //评论状态
	private String modifyDate;
	private String createDate;
	private String orderSn;//主订单编号
	private String imgUrl;
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", productId=" + productId
				+ ", productName=" + productName + ", productPrice="
				+ productPrice + ", productNum=" + productNum
				+ ", productSubtotal=" + productSubtotal + ", orderMasterId="
				+ orderMasterId + ", userId=" + userId + ", commentStatus="
				+ commentStatus + ", modifyDate=" + modifyDate
				+ ", createDate=" + createDate + ", orderSn=" + orderSn + "]";
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
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductNum() {
		return productNum;
	}
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}
	public double getProductSubtotal() {
		return productSubtotal;
	}
	public void setProductSubtotal(double productSubtotal) {
		this.productSubtotal = productSubtotal;
	}
	public Integer getOrderMasterId() {
		return orderMasterId;
	}
	public void setOrderMasterId(Integer orderMasterId) {
		this.orderMasterId = orderMasterId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(Integer commentStatus) {
		this.commentStatus = commentStatus;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
} 
