package cn.csbe.web.cms.push.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.push.bean.PubNotice;
import cn.csbe.web.cms.push.bean.PubUser;
import cn.csbe.web.cms.push.mapper.PubNoticeMapper;
import cn.csbe.web.cms.push.service.PubNoticeService;
@Service
public class PubNoticeServiceImpl implements PubNoticeService {
	@Autowired
	private PubNoticeMapper pubNoticeServiceMapper;
	@Override
	public Map<String, Object> queryAllPush(Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		page = (page-1)*rows;
		List<PubNotice> list = pubNoticeServiceMapper.queryAllPush(page,rows);
		int total = pubNoticeServiceMapper.queryCount();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	@Override
	public boolean addNotice(PubNotice pubNotice) {
		// TODO Auto-generated method stub
		return pubNoticeServiceMapper.addNotice(pubNotice);
	}
	@Override
	public boolean deleteNotice(String[] noticeId) {
		// TODO Auto-generated method stub
		return pubNoticeServiceMapper.deleteNotice(noticeId);
	}
	@Override
	public List<PubUser> queryAllUser() {
		// TODO Auto-generated method stub
		return pubNoticeServiceMapper.queryAllUser();
	}
	
	@Override
	public PubNotice queryByTime(String time) {
		// TODO Auto-generated method stub
		return pubNoticeServiceMapper.queryByTime(time);
	}
	@Override
	public List<PubNotice> queryByTwoType() {
		// TODO Auto-generated method stub
		
		return pubNoticeServiceMapper.queryByTwoType(3);
	}
	@Override
	public PubNotice findById(String noticeId) {
		// TODO Auto-generated method stub
		return pubNoticeServiceMapper.findById(noticeId);
	}
	@Override
	public boolean editNotice(PubNotice pubNotice) {
		// TODO Auto-generated method stub
		return pubNoticeServiceMapper.editNotice(pubNotice);
	}
	@Override
	public boolean editPayNotice(PubNotice pubNotice) {
		// TODO Auto-generated method stub
		return pubNoticeServiceMapper.editPayNotice(pubNotice);
	}
}
