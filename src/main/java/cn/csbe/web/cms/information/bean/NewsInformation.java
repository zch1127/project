package cn.csbe.web.cms.information.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * @author sxzhang
 *
 */
public class NewsInformation implements Serializable{
	
	private Integer infoId;
	private Integer type;
	private int previewTotal;
	private Integer status;
	private String infoName;
	private String infoContent;
	private String infoImg;
	private String htmlUrl;
	@JsonFormat(pattern="yyyy-MM-dd")
	private String createTime;
	private String param;//临时参数，存原来htmlurl
	private Integer templeId;
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public int getPreviewTotal() {
		return previewTotal;
	}
	public void setPreviewTotal(int previewTotal) {
		this.previewTotal = previewTotal;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getInfoName() {
		return infoName;
	}
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	public String getInfoImg() {
		return infoImg;
	}
	public void setInfoImg(String infoImg) {
		this.infoImg = infoImg;
	}
	public String getHtmlUrl() {
		return htmlUrl;
	}
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public Integer getTempleId() {
		return templeId;
	}
	public void setTempleId(Integer templeId) {
		this.templeId = templeId;
	}
	
	
}	
