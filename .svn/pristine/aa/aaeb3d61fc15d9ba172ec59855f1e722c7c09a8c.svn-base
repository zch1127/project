package cn.csbe.web.cms.temple.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.temple.bean.TempleMode;
import cn.csbe.web.cms.temple.mapper.TempleModeMapper;
import cn.csbe.web.cms.temple.service.TempleModeService;
@Service
public class TempleModeServiceImpl implements TempleModeService {
	@Autowired
	private TempleModeMapper templeModeMapper;
	@Override
	public Map<String, Object> selectAllRelation(Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<String,Object>();
		page =(page-1)*rows;
		List<TempleMode> list = templeModeMapper.selectAllRelation(page,rows);
		int total = templeModeMapper.selectCount();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	@Override
	public boolean addTempleRelation(TempleMode templeMode) {
		// TODO Auto-generated method stub
		return templeModeMapper.addTempleRelation(templeMode);
	}

}
