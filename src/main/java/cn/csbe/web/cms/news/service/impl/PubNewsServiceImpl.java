package cn.csbe.web.cms.news.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.common.service.impl.BaseService;
import cn.csbe.web.cms.news.bean.Area;
import cn.csbe.web.cms.news.bean.PubNews;
import cn.csbe.web.cms.news.mapper.AreaMapper;
import cn.csbe.web.cms.news.mapper.IPubNewsMapper;
import cn.csbe.web.cms.news.service.IPubNewsService;

@Service
public class PubNewsServiceImpl extends BaseService implements IPubNewsService {

	private IPubNewsMapper mapper;
	@Autowired
	private AreaMapper amapper;
	
	@Autowired
	public void setMapper(IPubNewsMapper mapper) {
		this.mapper = mapper;
		super.setMapper(mapper);
	}
	
	@Override
	public boolean insert(PubNews pubNews) {
		// TODO Auto-generated method stub
		return this.mapper.insert(pubNews) > 0;
	}

	@Override
	public Integer findMaxId() {
		// TODO Auto-generated method stub
		return this.mapper.findMaxId();
	}

	@Override
	public List<Area> selectArea() {
		
		List<Area> list = new ArrayList<Area>();
		list = amapper.selectArea();
		
		return list;
	}

	@Override
	public PubNews queryById(Integer newsid) {
		// TODO Auto-generated method stub
		return mapper.queryById(newsid);
	}

	@Override
	public boolean updateNews(PubNews news) {
		// TODO Auto-generated method stub
		return mapper.updateNews(news);
	}
	@Override
	public boolean updateNewsStatusByNewsid(PubNews news) {
		System.out.println();
		return mapper.updateNewsStatusByNewsid(news);
	}

	@Override
	public Map<String, Object> queryByStatus(Integer status, Integer page,
			Integer rows) {
		Map<String, Object> map = new HashMap<String,Object>();
		page = (page-1)*rows;
		List<PubNews> list = mapper.queryByStatus(status,page,rows);
		int total = mapper.findCountByStatus(status);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}


	
	
}
