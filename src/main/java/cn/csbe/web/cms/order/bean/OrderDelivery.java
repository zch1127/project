package cn.csbe.web.cms.order.bean;
/*
 * 发货订单
 */
public class OrderDelivery {
	private Integer id;
	private Integer orderMasterId;//主订单编号
	private Integer logisticsId;//物流公司名字
	private String logisticsNumber;//物流单号
	private String remark;
	private String createDate;
	private String modifyDate;
	
	private Integer userId;//用户id，用于添加通知信息表
	private String productName;//商品名称，用于添加通知信息表
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderMasterId() {
		return orderMasterId;
	}
	public void setOrderMasterId(Integer orderMasterId) {
		this.orderMasterId = orderMasterId;
	}
	public Integer getLogisticsId() {
		return logisticsId;
	}
	public void setLogisticsId(Integer logisticsId) {
		this.logisticsId = logisticsId;
	}
	public String getLogisticsNumber() {
		return logisticsNumber;
	}
	public void setLogisticsNumber(String logisticsNumber) {
		this.logisticsNumber = logisticsNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "OrderDelivery [id=" + id + ", orderMasterId=" + orderMasterId
				+ ", logisticsId=" + logisticsId + ", logisticsNumber="
				+ logisticsNumber + ", remark=" + remark + ", createDate="
				+ createDate + ", modifyDate=" + modifyDate + "]";
	}
	
	
}
