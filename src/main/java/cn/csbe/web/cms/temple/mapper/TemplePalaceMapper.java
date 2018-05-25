package cn.csbe.web.cms.temple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.temple.bean.Temple;
import cn.csbe.web.cms.temple.bean.TemplePalace;

public interface TemplePalaceMapper {

	List<TemplePalace> selectAllPalace(@Param("page")Integer page, @Param("rows")Integer rows);

	int queryCount();

	boolean addTemplePalace(TemplePalace palace);

	boolean deletePalace(Integer[] ids);

	boolean updateTemplePalace(TemplePalace palace);

	TemplePalace queryPalaceByPid(Integer palaceId);

}
