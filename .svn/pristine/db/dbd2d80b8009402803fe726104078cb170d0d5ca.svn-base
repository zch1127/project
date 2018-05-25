package cn.csbe.web.cms.push.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.push.bean.PubNotice;
import cn.csbe.web.cms.push.bean.PubUser;

public interface PubNoticeMapper {

	List<PubNotice> queryAllPush(@Param("page")Integer page, @Param("rows")Integer rows);

	int queryCount();

	boolean addNotice(PubNotice pubNotice);

	boolean deleteNotice(String[] noticeId);

	List<PubUser> queryAllUser();
	
	PubNotice queryByTime(String time);

	//查询所有付费消息
	List<PubNotice> queryByTwoType(int twoType);

	PubNotice findById(String noticeId);

	boolean editNotice(PubNotice pubNotice);
	//编辑付费通知信息
	boolean editPayNotice(PubNotice pubNotice);

}
