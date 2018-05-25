package cn.csbe.web.cms.activities.service;

import java.util.Map;

public interface RedPacketReceiveService {



	Map<String, Object> selectAllRedPacketReceive(Integer page, Integer rows,Integer activityStatus,Integer redPacketId,Integer isRemit);

	boolean changeRedPacketReceiveUseStatus(Integer redPacketId);
	
	//打款给提现用户
	boolean changeRemitStatus(Integer[] ids);

	
}
