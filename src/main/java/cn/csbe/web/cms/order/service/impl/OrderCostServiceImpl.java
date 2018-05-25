package cn.csbe.web.cms.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.order.bean.OrderCostTime;
import cn.csbe.web.cms.order.mapper.OrderCostMapper;
import cn.csbe.web.cms.order.service.OrderCostService;
@Service
public class OrderCostServiceImpl implements OrderCostService {
	@Autowired
	private OrderCostMapper orderCostMapper;
	@Override
	public boolean updateTime(OrderCostTime orderCostTime) {
		// TODO Auto-generated method stub
		return orderCostMapper.updateTime(orderCostTime);
	}
	@Override
	public OrderCostTime selectById(int id) {
		// TODO Auto-generated method stub
		return orderCostMapper.selectById(id);
	}

}
