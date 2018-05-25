package cn.csbe.web.cms.news.service;

import java.util.List;
import java.util.Map;

import cn.csbe.web.cms.common.service.IBaseService;
import cn.csbe.web.cms.news.bean.Area;
import cn.csbe.web.cms.news.bean.PubNews;

public interface IPubNewsService extends IBaseService {
	boolean insert(PubNews pubNews);

	Integer findMaxId();

	List<Area> selectArea();

	PubNews queryById(Integer newsid);
	
	boolean updateNews(PubNews news);
	
	//修改新闻状态
	boolean updateNewsStatusByNewsid(PubNews news);
	//根据状态去查询新闻信息
	Map<String, Object> queryByStatus(Integer status, Integer page, Integer rows);
}
