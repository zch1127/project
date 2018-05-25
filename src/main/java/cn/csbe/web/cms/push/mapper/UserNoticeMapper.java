package cn.csbe.web.cms.push.mapper;

import cn.csbe.web.cms.push.bean.UserNotice;

public interface UserNoticeMapper {

	boolean addUserAndNoticeRelation(UserNotice userNotice);

}
