package cn.csbe.web.cms.logistics.bean;
/*
 * 物流公司实体类
 * @author sxzhang
 */
public class Logistics {
	private Integer id;
	private String logisticsName;//快递公司名字
	private String corpCode;//快递公司代码
	private String corpWebUrl;//快递公司url
	private Integer orderList;//排序
	private Integer enableStatus;
	private String createDate;
	private String modifyDate;
	@Override
	public String toString() {
		return "Logistics [id=" + id + ", logisticsName=" + logisticsName
				+ ", corpCode=" + corpCode + ", corpWebUrl=" + corpWebUrl
				+ ", orderList=" + orderList + ", enableStatus=" + enableStatus
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogisticsName() {
		return logisticsName;
	}
	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getCorpWebUrl() {
		return corpWebUrl;
	}
	public void setCorpWebUrl(String corpWebUrl) {
		this.corpWebUrl = corpWebUrl;
	}
	public Integer getOrderList() {
		return orderList;
	}
	public void setOrderList(Integer orderList) {
		this.orderList = orderList;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
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
	
}
