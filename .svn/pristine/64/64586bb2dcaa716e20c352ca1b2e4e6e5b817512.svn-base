package cn.csbe.web.cms.activities.service;

import java.util.List;

import cn.csbe.web.cms.activities.bean.RedPacket;

public interface RedPacketService {
	//根据活动状态查看红包信息
	List<RedPacket> showAllRedPacket(Integer activityStatus);

	//添加红包
	boolean addRedPacket(RedPacket redPacket);
	
	//批量删除红包
	boolean deleteRedPacket(int id);
	
	//到编辑红包页面
	RedPacket toUpdateRedPacket(int id);
	//编辑红包
	boolean updateRedPacket(RedPacket redPacket);
	
	//定时改变红包活动状态
	List<RedPacket> selectStartEndDate();

	boolean changeRedPacketActivityStatus(int id, int activityStatus);
	

}
