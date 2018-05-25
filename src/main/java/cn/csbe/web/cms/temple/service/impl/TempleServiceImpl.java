package cn.csbe.web.cms.temple.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.temple.bean.Temple;
import cn.csbe.web.cms.temple.mapper.TempleMapper;
import cn.csbe.web.cms.temple.service.TempleService;
@Service
public class TempleServiceImpl implements TempleService {
	@Autowired
	private TempleMapper templeMapper;
	@Override
	public List<Temple> selectTempleByAbbotId(Integer id) {
		// TODO Auto-generated method stub
		return templeMapper.selectTempleByAbbotId(id);
	}
	@Override
	public Map<String, Object> selectAllTemple(Integer page,Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		page = (page-1)*rows;
		List<Temple> list = templeMapper.selectAllTemple(page,rows);
		int total = templeMapper.selectCount();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	@Override
	public boolean deleteTemple(Integer[] ids) {
		// TODO Auto-generated method stub
		return templeMapper.deleteTemple(ids);
	}
	@Override
	public boolean addTemple(Temple temple) {
		
		return templeMapper.addTemple(temple);
	}
	@Override
	public Map<String, Object> selectTempleById(Integer templeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Temple temple = templeMapper.selectTempleById(templeId);
		map.put("temple", temple);
		return map;
	}
	@Override
	public List<Temple> queryAllTemple() {
		
		return templeMapper.queryAllTemple();
	}
	@Override
	public boolean updateTemple(Temple temple) {
		// TODO Auto-generated method stub
		return templeMapper.updateTemple(temple);
	}

}
