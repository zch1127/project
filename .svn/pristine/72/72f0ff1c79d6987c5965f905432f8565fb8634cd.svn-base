package cn.csbe.web.cms.news.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.common.bean.QueryResult;
import cn.csbe.web.cms.common.mapper.IBaseMapper;
import cn.csbe.web.cms.news.bean.PubNews;

public interface IPubNewsMapper extends IBaseMapper {
	Integer insert(PubNews pubNews);

	Integer findMaxId();

	PubNews queryById(Integer newsid);

	QueryResult queryNewsByStatus(PubNews news);

	boolean updateNews(PubNews news);
	//上架
	boolean releaseNews(PubNews news);

	boolean updateNewsStatusByNewsid(PubNews news);
	
	List<PubNews> queryByStatus(@Param("status")Integer status,@Param("page")Integer page,@Param("rows")Integer rows);

	int findCountByStatus(Integer status);
}
