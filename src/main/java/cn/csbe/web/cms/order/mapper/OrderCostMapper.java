package cn.csbe.web.cms.order.mapper;

import cn.csbe.web.cms.order.bean.OrderCostTime;

public interface OrderCostMapper {
	//设置订单时长限制
	boolean updateTime(OrderCostTime orderCostTime);

	OrderCostTime selectById(int id);

}
