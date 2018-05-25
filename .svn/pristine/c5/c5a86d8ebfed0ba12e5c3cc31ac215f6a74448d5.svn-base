package cn.csbe.web.cms.temple.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.temple.bean.Temple;
import cn.csbe.web.cms.temple.bean.TemplePalace;
import cn.csbe.web.cms.temple.mapper.TemplePalaceMapper;
import cn.csbe.web.cms.temple.service.TemplePalaceService;
@Service
public class TemplePalaceServiceImpl implements TemplePalaceService {
	@Autowired
	private  TemplePalaceMapper palaceMapper;

	@Override
	public Map<String, Object> selectAllPalace(Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		page = (page-1)*rows;
		List<TemplePalace> list= palaceMapper.selectAllPalace(page,rows);
		int total = palaceMapper.queryCount();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	@Override
	public boolean deletePalace(Integer[] ids) {
		// TODO Auto-generated method stub
		return palaceMapper.deletePalace(ids);
	}
	@Override
	public boolean addTemplePalace(TemplePalace palace) {
		// TODO Auto-generated method stub
		return palaceMapper.addTemplePalace(palace);
	}
	@Override
	public boolean updateTemplePalace(TemplePalace palace) {
		// TODO Auto-generated method stub
		return palaceMapper.updateTemplePalace(palace);
	}
	@Override
	public TemplePalace queryPalaceByPid(Integer palaceId) {
		// TODO Auto-generated method stub
		return palaceMapper.queryPalaceByPid(palaceId);
	}
	

}
