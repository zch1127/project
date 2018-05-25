package cn.csbe.web.cms.activities.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.activities.bean.RedPacketReceive;

/**
 * @author: wffu
 * @date:2017-12-11 上午10:48:06
 * @version :
 * 
 */
public interface RedPacketReceiveMapper {
	List<RedPacketReceive> selectAllRedPacketReceive(@Param("start")int start, @Param("rows")int rows,@Param("activityStatus")int activityStatus,@Param("redPacketId")int redPacketId,@Param("isRemit")Integer isRemit);

	int countAllRedPacketReceive(@Param("activityStatus")int activityStatus,@Param("redPacketId")int redPacketId,@Param("isRemit")Integer isRemit);

	int changeRedPacketReceiveUseStatus(Integer redPacketId);

	int changeRemitStatus(@Param("ids")Integer[] ids);
	
	//查询领取红包个数
	Integer countReceivePeoples(Integer redPacketId);
	
	//查询提现红包个数
	Integer countWithDrawPeoples(Integer redPacketId);
}
