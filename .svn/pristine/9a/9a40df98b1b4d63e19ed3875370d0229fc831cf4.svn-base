package cn.csbe.web.cms.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.order.bean.OrderDelivery;
import cn.csbe.web.cms.order.mapper.OrderDeliveryMapper;
import cn.csbe.web.cms.order.service.OrderDeliveryService;
@Service
public class OrderDeliveryServiceImpl implements OrderDeliveryService {
	@Autowired
	private OrderDeliveryMapper orderDeliveryMapper;
	@Override
	public boolean addOrderDelivery(OrderDelivery orderDelivery) {
		// TODO Auto-generated method stub
		return orderDeliveryMapper.addOrderDelivery(orderDelivery);
	}
	@Override
	public OrderDelivery selectByOrderId(Integer id) {
		// TODO Auto-generated method stub
		return orderDeliveryMapper.selectByOrderId(id);
	}
	@Override
	public OrderDelivery validationOrderNum(String logisticsNumber) {
		// TODO Auto-generated method stub
		return orderDeliveryMapper.validationOrderNum(logisticsNumber);
	}

}
