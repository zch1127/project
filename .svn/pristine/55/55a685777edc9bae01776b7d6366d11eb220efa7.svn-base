package cn.csbe.web.cms.push.service;

import java.util.List;
import java.util.Map;

import cn.csbe.web.cms.push.bean.PubNotice;
import cn.csbe.web.cms.push.bean.PubUser;

public interface PubNoticeService {

	Map<String, Object> queryAllPush(Integer page, Integer rows);

	boolean addNotice(PubNotice pubNotice);

	boolean deleteNotice(String[] noticeId);

	List<PubUser> queryAllUser();
	
	public PubNotice queryByTime(String dateTimeStr);

	List<PubNotice> queryByTwoType();

	PubNotice findById(String noticeId);

	boolean editNotice(PubNotice pubNotice);

	boolean editPayNotice(PubNotice pubNotice);
}
