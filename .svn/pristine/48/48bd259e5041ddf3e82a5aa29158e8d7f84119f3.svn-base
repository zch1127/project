package cn.csbe.web.cms.activities.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author: wffu
 * @date:2017-12-11 上午10:40:14
 * @version :
 * 
 */
public class RedPacketReceive implements Serializable {
	private Integer id;//红包领用id
	private Integer userId;//所属用户
	private String userName;//用户姓名
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp receiveTime;//领用时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp useTime;//使用时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp remitTime;//使用时间
	public Timestamp getRemitTime() {
		return remitTime;
	}
	public void setRemitTime(Timestamp remitTime) {
		this.remitTime = remitTime;
	}
	private BigDecimal getFaceValue;//获取金额大小
	private Integer useType;//使用方式   1.提现，2.其他
	private Integer useStatus;//使用状态  0.未使用，1.已使用，2.已失效
	private String withDrawAccount;//账户名
	private Integer accountType;//账户类型  1.支付宝，2.微信,3.其他
	private Integer isRemit;//是否已打款给用户0,否，1，是
	public RedPacketReceive(Integer id, Integer userId, String userName,
			Timestamp receiveTime, Timestamp useTime, BigDecimal getFaceValue,
			Integer useType, Integer useStatus, String withDrawAccount,
			Integer accountType, Integer isRemit) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.receiveTime = receiveTime;
		this.useTime = useTime;
		this.getFaceValue = getFaceValue;
		this.useType = useType;
		this.useStatus = useStatus;
		this.withDrawAccount = withDrawAccount;
		this.accountType = accountType;
		this.isRemit = isRemit;
	}
	public Integer getIsRemit() {
		return isRemit;
	}
	public void setIsRemit(Integer isRemit) {
		this.isRemit = isRemit;
	}
	@Override
	public String toString() {
		return "RedPacketReceive [id=" + id + ", userId=" + userId
				+ ", userName=" + userName + ", receiveTime=" + receiveTime
				+ ", useTime=" + useTime + ", remitTime=" + remitTime
				+ ", getFaceValue=" + getFaceValue + ", useType=" + useType
				+ ", useStatus=" + useStatus + ", withDrawAccount="
				+ withDrawAccount + ", accountType=" + accountType
				+ ", isRemit=" + isRemit + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Timestamp getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Timestamp getUseTime() {
		return useTime;
	}
	public void setUseTime(Timestamp useTime) {
		this.useTime = useTime;
	}
	public BigDecimal getGetFaceValue() {
		return getFaceValue;
	}
	public void setGetFaceValue(BigDecimal getFaceValue) {
		this.getFaceValue = getFaceValue;
	}
	public Integer getUseType() {
		return useType;
	}
	public void setUseType(Integer useType) {
		this.useType = useType;
	}
	public Integer getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}
	public String getWithDrawAccount() {
		return withDrawAccount;
	}
	public void setWithDrawAccount(String withDrawAccount) {
		this.withDrawAccount = withDrawAccount;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public RedPacketReceive() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RedPacketReceive(Integer id, Integer userId, String userName,
			Timestamp receiveTime, Timestamp useTime, Timestamp remitTime,
			BigDecimal getFaceValue, Integer useType, Integer useStatus,
			String withDrawAccount, Integer accountType, Integer isRemit) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.receiveTime = receiveTime;
		this.useTime = useTime;
		this.remitTime = remitTime;
		this.getFaceValue = getFaceValue;
		this.useType = useType;
		this.useStatus = useStatus;
		this.withDrawAccount = withDrawAccount;
		this.accountType = accountType;
		this.isRemit = isRemit;
	}
}
