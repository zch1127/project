package cn.csbe.web.cms.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.order.bean.OrderDetail;
import cn.csbe.web.cms.order.mapper.OrderDetailMapper;
import cn.csbe.web.cms.order.service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	@Override
	public List<OrderDetail> selectAllDetailOrderByOrderSn(String num) {
		// TODO Auto-generated method stub
		return orderDetailMapper.selectAllDetailOrderByOrderSn(num);
	}
	
	@Override
	public List<OrderDetail> searchOrderByConditions(OrderDetail order) {
		// TODO Auto-generated method stub
		return orderDetailMapper.searchOrderByConditions(order);
	}

}
