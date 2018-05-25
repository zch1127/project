package cn.csbe.web.cms.activities.mapper;

import java.util.List;

import cn.csbe.web.cms.activities.bean.RedPacket;

/**
 * @author: wffu
 * @date:2017-12-11 上午10:47:00
 * @version :
 * 
 */
public interface RedPacketMapper {
	//查询所有红包
	List<RedPacket> showAllRedPacket(Integer activityStatus);
	
	//添加红包
	int addRedPacket(RedPacket redPacket);
	
	//根据id删除红包
	int deleteRedPacket(int id);
	
	//根据id查找红包
	RedPacket selectById(int id);

	//修改红包
	int updateRedPacket(RedPacket redPacket);
	
	//修改红包活动状态
	List<RedPacket> selectStartEndDate();

	int changeRedPacketActivityStatus(int id, int activityStatus);
}
