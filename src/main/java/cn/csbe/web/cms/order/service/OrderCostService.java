package cn.csbe.web.cms.order.service;

import cn.csbe.web.cms.order.bean.OrderCostTime;

public interface OrderCostService {
	//设置订单时长限制
	public boolean updateTime(OrderCostTime orderCostTime);

	public OrderCostTime selectById(int id);
	
}
