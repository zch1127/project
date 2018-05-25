package cn.csbe.web.cms.activities.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.activities.bean.RedPacketReceive;
import cn.csbe.web.cms.activities.mapper.RedPacketReceiveMapper;
import cn.csbe.web.cms.activities.service.RedPacketReceiveService;
@Service
public class RedPacketReceiveServiceImpl implements RedPacketReceiveService {

	@Autowired
	private RedPacketReceiveMapper redPacketReceiveMapper;
	
	@Override
	public Map<String,Object> selectAllRedPacketReceive(Integer page, Integer rows,Integer activityStatus,Integer redPacketId,Integer isRemit) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		int start=(page-1)*rows;
		List<RedPacketReceive> list = redPacketReceiveMapper.selectAllRedPacketReceive(start,rows, activityStatus,redPacketId,isRemit);
		int total = redPacketReceiveMapper.countAllRedPacketReceive(activityStatus,redPacketId,isRemit);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	@Override
	public boolean changeRedPacketReceiveUseStatus(Integer redPacketId) {
		int i = redPacketReceiveMapper.changeRedPacketReceiveUseStatus(redPacketId);
		return i>0;
	}
	@Override
	public boolean changeRemitStatus(Integer[] ids) {
		int i =redPacketReceiveMapper.changeRemitStatus(ids);
		return i>0;
	}
	
	
}
