package cn.csbe.web.cms.temple.service;

import java.util.Map;

import cn.csbe.web.cms.temple.bean.Temple;
import cn.csbe.web.cms.temple.bean.TemplePalace;

public interface TemplePalaceService {

	Map<String, Object> selectAllPalace(Integer page, Integer rows);

	boolean deletePalace(Integer[] ids);

	boolean addTemplePalace(TemplePalace palace);

	boolean updateTemplePalace(TemplePalace palace);

	TemplePalace queryPalaceByPid(Integer palaceId);

}
