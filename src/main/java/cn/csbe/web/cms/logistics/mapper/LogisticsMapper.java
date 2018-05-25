package cn.csbe.web.cms.logistics.mapper;

import java.util.List;

import cn.csbe.web.cms.logistics.bean.Logistics;

public interface LogisticsMapper {
	//查询所有的快递公司的信息
	List<Logistics> selectAllLogistics();
	//根据id查询
	Logistics selectByid(Integer id);

}
