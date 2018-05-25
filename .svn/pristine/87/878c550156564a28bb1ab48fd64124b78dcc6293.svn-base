package cn.csbe.web.cms.order.mapper;

import java.util.List;

import cn.csbe.web.cms.order.bean.OrderMaster;

public interface OrderMasterMapper {
	//查询所有订单信息
	List<OrderMaster> selectAllOrder();
	//根据订单状态去查询
	List<OrderMaster> selectOrderByState(Integer stateValue);
	//根据订单编号查询
	OrderMaster selectAllOrderBySn(String orderSn);
	//
	boolean updateById(Integer id);
	//定时根据状态去查询订单信息
	List<OrderMaster> selectByStatus(int orderStatus);
	//清理未付款订单
	boolean updateOrderStatusById(int id);
	//自动收货
	boolean updateOrderStatusByMasterId(int id);
	//自动好评 订单完成
	boolean updateFinishStatus(int id);
	//售后完成关闭订单
	int updateRefundOrderStatusByOrderSn(int orderMasterId);

}
