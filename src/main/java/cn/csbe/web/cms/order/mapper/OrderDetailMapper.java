package cn.csbe.web.cms.order.mapper;

import java.util.List;

import cn.csbe.web.cms.order.bean.OrderDetail;

public interface OrderDetailMapper {
	//根据订单编号去查询子订单信息
	List<OrderDetail> selectAllDetailOrderByOrderSn(String num);
	//多条件查询
	List<OrderDetail> searchOrderByConditions(OrderDetail order);
}
