package cn.csbe.web.cms.temple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.temple.bean.TempleMode;

public interface TempleModeMapper {

	List<TempleMode> selectAllRelation(@Param("page")Integer page, @Param("rows")Integer rows);

	int selectCount();

	boolean addTempleRelation(TempleMode templeMode);

}
