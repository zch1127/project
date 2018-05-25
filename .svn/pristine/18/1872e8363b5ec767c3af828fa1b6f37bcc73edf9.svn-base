package cn.csbe.web.cms.user.mapper;

import java.util.List;

import cn.csbe.web.cms.common.mapper.IBaseMapper;
import cn.csbe.web.cms.push.bean.PubNotice;
import cn.csbe.web.cms.user.bean.Notice;
import cn.csbe.web.cms.user.bean.PubUser;
import cn.csbe.web.cms.user.bean.WithDrawals;

public interface IUserMapper extends IBaseMapper {
	
	int insertNoticeUser(Notice obj);
	int insertNotice(Notice obj);
	//提现审核列表
	List findWithDrawals(WithDrawals withDrawals);
	
	Long findWithDrawalsCount(WithDrawals withDrawals);
	
	WithDrawals findWithDrawalsById(Integer id);
	
	int updateWithDrawals(WithDrawals withDrawals);
	//其他付费用户
	List<PubUser> findUserByPayLog(PubNotice pubNotice);
	//吉庆寺付费用户
	List<PubUser> findUserByTempleLog(PubNotice pubNotice);
	//点灯付费用户
	List<PubUser> findUserByLightPayLog(PubNotice pubNotice);
}
