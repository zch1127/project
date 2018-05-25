package cn.csbe.web.cms.push.bean;
/**
 * 用户和推送活动关系
 * Title: UserNotice  
 * @author sxzhang 
 * @date 上午11:06:36
 */

public class UserNotice {
	private Integer userId;
	private Integer isRead;
	private String createDate;
	private String modifyDate;
	private String noticeId;
	private String payDate;
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getIsRead() {
		return isRead;
	}
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
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
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public UserNotice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserNotice(Integer userId, Integer isRead, String createDate,
			String modifyDate, String noticeId, String payDate) {
		super();
		this.userId = userId;
		this.isRead = isRead;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.noticeId = noticeId;
		this.payDate = payDate;
	}
	@Override
	public String toString() {
		return "UserNotice [userId=" + userId + ", isRead=" + isRead
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ ", noticeId=" + noticeId + ", payDate=" + payDate + "]";
	}
	
	
	
}
