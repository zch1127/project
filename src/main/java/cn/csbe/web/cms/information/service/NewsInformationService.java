package cn.csbe.web.cms.information.service;

import java.util.Map;

import cn.csbe.web.cms.information.bean.NewsInformation;

public interface NewsInformationService {

	Map<String, Object> selectAllInformation(Integer page, Integer rows);

	boolean addInformation(NewsInformation newsInformation);

	boolean deleteInformation(Integer[] infoId);

	boolean updateInformation(NewsInformation newsInformation);

	NewsInformation findById(Integer infoId);
	
	NewsInformation queryBigPreviewTotal(Integer type);

}
