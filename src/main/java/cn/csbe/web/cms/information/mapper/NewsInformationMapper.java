package cn.csbe.web.cms.information.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.information.bean.NewsInformation;

public interface NewsInformationMapper {

	List<NewsInformation> selectAllInformation(@Param("page")Integer page, @Param("rows")Integer rows);

	int selectCount();

	boolean addInformation(NewsInformation newsInformation);

	boolean deleteInformation(Integer[] infoId);

	boolean updateInformation(NewsInformation newsInformation);

	NewsInformation findById(Integer infoId);

	NewsInformation queryBigPreviewTotal(Integer type);

}
