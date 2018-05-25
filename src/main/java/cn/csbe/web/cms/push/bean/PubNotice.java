package cn.csbe.web.cms.push.bean;

import java.io.Serializable;

import cn.csbe.web.cms.common.bean.Page;
/**
 * 推送活动
 * Title: PushActivity  
 * @author sxzhang 
 * @date 上午11:58:42
 */
public class PubNotice extends Page implements Serializable{
	private String noticeId;
	private Integer type;
	private String title;
	private String introduction;
	private String htmlUrl;
	private Integer twoType;
	private String picture;
	private String createDate;
	private String modifyDate;
	private Integer status;
	private Integer infoType;
	private String leftIcon;
	private String spareField;
	private Integer templeId;
	private String payNoticeDetailTitle;
	
	public String getPayNoticeDetailTitle() {
		return payNoticeDetailTitle;
	}

	public void setPayNoticeDetailTitle(String payNoticeDetailTitle) {
		this.payNoticeDetailTitle = payNoticeDetailTitle;
	}

	public Integer getTempleId() {
		return templeId;
	}

	public void setTempleId(Integer templeId) {
		this.templeId = templeId;
	}
	
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getHtmlUrl() {
		return htmlUrl;
	}
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}
	public Integer getTwoType() {
		return twoType;
	}
	public void setTwoType(Integer twoType) {
		this.twoType = twoType;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getInfoType() {
		return infoType;
	}
	public void setInfoType(Integer infoType) {
		this.infoType = infoType;
	}
	public String getLeftIcon() {
		return leftIcon;
	}
	public void setLeftIcon(String leftIcon) {
		this.leftIcon = leftIcon;
	}
	public String getSpareField() {
		return spareField;
	}
	public void setSpareField(String spareField) {
		this.spareField = spareField;
	}
	 
	@Override
	public String toString() {
		return "PubNotice [noticeId=" + noticeId + ", type=" + type
				+ ", title=" + title + ", introduction=" + introduction
				+ ", htmlUrl=" + htmlUrl + ", twoType=" + twoType
				+ ", picture=" + picture + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", status=" + status
				+ ", infoType=" + infoType + ", leftIcon=" + leftIcon
				+ ", spareField=" + spareField + ", templeId=" + templeId
				+ ", payNoticeDetailTitle=" + payNoticeDetailTitle + "]";
	}

	public PubNotice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PubNotice(String noticeId, Integer type, String title,
			String introduction, String htmlUrl, Integer twoType,
			String picture, String createDate, String modifyDate,
			Integer status, Integer infoType, String leftIcon,
			String spareField, Integer templeId, String payNoticeDetailTitle) {
		super();
		this.noticeId = noticeId;
		this.type = type;
		this.title = title;
		this.introduction = introduction;
		this.htmlUrl = htmlUrl;
		this.twoType = twoType;
		this.picture = picture;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.infoType = infoType;
		this.leftIcon = leftIcon;
		this.spareField = spareField;
		this.templeId = templeId;
		this.payNoticeDetailTitle = payNoticeDetailTitle;
	};
	
}
