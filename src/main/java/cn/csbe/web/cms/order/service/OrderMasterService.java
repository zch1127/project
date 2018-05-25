package cn.csbe.web.cms.order.service;

import java.util.List;

import cn.csbe.web.cms.order.bean.OrderDelivery;
import cn.csbe.web.cms.order.bean.OrderMaster;

public interface OrderMasterService {
	//查询所有订单
	public List<OrderMaster> selectAllOrder();
	//根据状态查询订单
	public List<OrderMaster> selectAllOrder(Integer stateValue);
	//根据订单编号去查询
	public OrderMaster selectAllOrder(String orderSn);
	//根据主订单编号去修改订单状态
	public boolean updateById(OrderDelivery orderDelivery,Integer id);
	//定时根据状态查询订单
	public List<OrderMaster> selectByStatus(int orderStatus);
	//根据id去修改订单状态
	public boolean updateOrderStatusById(int id);
	//自动收货  status = 3
	public boolean updateOrderStatusByMasterId(int id);
	//自动好评  status = 4
	public boolean updateFinishStatus(int id);
	
	


}
