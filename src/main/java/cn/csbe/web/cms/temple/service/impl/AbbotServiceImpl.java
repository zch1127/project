package cn.csbe.web.cms.temple.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.temple.bean.Abbot;
import cn.csbe.web.cms.temple.mapper.AbbotMapper;
import cn.csbe.web.cms.temple.service.AbbotService;
@Service
public class AbbotServiceImpl implements AbbotService {
	@Autowired
	private AbbotMapper abbotMapper;
	
	@Override
	public List<Abbot> selectAbbot() {
		// TODO Auto-generated method stub
		return abbotMapper.selectAbbot();
	}

	@Override
	public Map<String, Object> selectAbbotById(Integer abbotId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Abbot abbot = abbotMapper.selectAbbotById(abbotId);
		map.put("abbot", abbot);
		return map;
	}

}
