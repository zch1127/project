package cn.csbe.web.cms.temple.mapper;

import java.util.List;

import cn.csbe.web.cms.temple.bean.Abbot;

public interface AbbotMapper {
	//查询住持信息
	List<Abbot> selectAbbot();

	Abbot selectAbbotById(Integer abbotId);

}
