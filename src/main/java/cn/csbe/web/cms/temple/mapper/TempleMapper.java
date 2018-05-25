package cn.csbe.web.cms.temple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.temple.bean.Temple;

public interface TempleMapper {

	List<Temple> selectTempleByAbbotId(Integer id);

	List<Temple> selectAllTemple(@Param("page")Integer page,@Param("rows")Integer rows);

	int selectCount();

	boolean deleteTemple(Integer[] ids);

	boolean addTemple(Temple temple);

	Temple selectTempleById(Integer templeId);

	List<Temple> queryAllTemple();

	boolean updateTemple(Temple temple);

}
