package cn.csbe.web.cms.order.bean;
/*
 * 物流公司信息
 */
public class DeliveryCorp {
	
	private Integer id;
	private String logisticsName;
	private String corpCode;
	private String corpWebUrl;
	private Integer orderList;
	private Integer enableStatus;
	private String createDate;
	private String modifyDate;
	@Override
	public String toString() {
		return "DeliveryCorp [id=" + id + ", logisticsName=" + logisticsName
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
	public DeliveryCorp(Integer id, String logisticsName, String corpCode,
			String corpWebUrl, Integer orderList, Integer enableStatus,
			String createDate, String modifyDate) {
		super();
		this.id = id;
		this.logisticsName = logisticsName;
		this.corpCode = corpCode;
		this.corpWebUrl = corpWebUrl;
		this.orderList = orderList;
		this.enableStatus = enableStatus;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	public DeliveryCorp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
