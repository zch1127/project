package cn.csbe.web.cms.logistics.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.logistics.bean.Logistics;
import cn.csbe.web.cms.logistics.mapper.LogisticsMapper;
import cn.csbe.web.cms.logistics.service.LogisticsService;
@Service
public class LogisticsServiceImpl implements LogisticsService {
	@Autowired
	private LogisticsMapper logisticsMapper;

	@Override
	public List<Logistics> selectAllLogistics() {
		// TODO Auto-generated method stub
		return logisticsMapper.selectAllLogistics();
	}

	@Override
	public Map<String, Logistics> selectByid(Integer id) {
		Map<String, Logistics> map = new HashMap<String, Logistics>();
		Logistics log = logisticsMapper.selectByid(id);
		map.put("logistics", log);
		// TODO Auto-generated method stub
		return map;
	}
	
	
}
