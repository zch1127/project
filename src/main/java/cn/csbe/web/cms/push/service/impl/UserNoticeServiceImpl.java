package cn.csbe.web.cms.push.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.push.bean.UserNotice;
import cn.csbe.web.cms.push.mapper.UserNoticeMapper;
import cn.csbe.web.cms.push.service.UserNoticeService;
@Service
public class UserNoticeServiceImpl implements UserNoticeService {
	@Autowired
	private UserNoticeMapper userNoticeMapper;
	@Override
	public boolean addUserAndNoticeRelation(UserNotice userNotice) {
		
		return userNoticeMapper.addUserAndNoticeRelation(userNotice);
	}

}
