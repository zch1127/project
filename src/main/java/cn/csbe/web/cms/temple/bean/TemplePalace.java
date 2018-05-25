package cn.csbe.web.cms.temple.bean;
/**
 * Title: TemplePalace  
 * @author sxzhang 
 * @date 下午3:18:29
 */

public class TemplePalace {
	private Integer palaceId;
	private Integer templeId;
	private Integer orderList;
	private String palaceName;
	private String imgUrl;
	private String backgroundImgUrl;
	private String content;
	private Integer status;
	public Integer getPalaceId() {
		return palaceId;
	}
	public void setPalaceId(Integer palaceId) {
		this.palaceId = palaceId;
	}
	public Integer getTempleId() {
		return templeId;
	}
	public void setTempleId(Integer templeId) {
		this.templeId = templeId;
	}
	public Integer getOrderList() {
		return orderList;
	}
	public void setOrderList(Integer orderList) {
		this.orderList = orderList;
	}
	public String getPalaceName() {
		return palaceName;
	}
	public void setPalaceName(String palaceName) {
		this.palaceName = palaceName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getBackgroundImgUrl() {
		return backgroundImgUrl;
	}
	public void setBackgroundImgUrl(String backgroundImgUrl) {
		this.backgroundImgUrl = backgroundImgUrl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
