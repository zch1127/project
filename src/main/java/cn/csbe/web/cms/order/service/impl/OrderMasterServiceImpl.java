package cn.csbe.web.cms.order.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.common.DateUtils;
import cn.csbe.web.cms.common.constantUtils;
import cn.csbe.web.cms.order.bean.DeliveryCorp;
import cn.csbe.web.cms.order.bean.OrderDelivery;
import cn.csbe.web.cms.order.bean.OrderMaster;
import cn.csbe.web.cms.order.mapper.DeliveryCorpServiceMapper;
import cn.csbe.web.cms.order.mapper.OrderMasterMapper;
import cn.csbe.web.cms.order.service.OrderMasterService;
import cn.csbe.web.cms.user.bean.Notice;
import cn.csbe.web.cms.user.mapper.IUserMapper;
@Service
public class OrderMasterServiceImpl implements OrderMasterService {
	@Autowired
	private OrderMasterMapper orderMasterMapper;
	@Autowired
	private DeliveryCorpServiceMapper deliveryCorpMapper;
	@Autowired
	private IUserMapper userMapper;
	
	//查询所有订单
	@Override
	public List<OrderMaster> selectAllOrder() {
		// TODO Auto-generated method stub
		return orderMasterMapper.selectAllOrder();
	}
	//根据订单状态查询订单
	@Override
	public List<OrderMaster> selectAllOrder(Integer stateValue) {
		// TODO Auto-generated method stub
		return orderMasterMapper.selectOrderByState(stateValue);
	}
	@Override
	public OrderMaster selectAllOrder(String orderSn) {
		// TODO Auto-generated method stub
		return orderMasterMapper.selectAllOrderBySn(orderSn);
	}
	@Override
	public boolean updateById(OrderDelivery orderDelivery,Integer id) {
		boolean flag=orderMasterMapper.updateById(id);
		if(flag==true && orderDelivery.getLogisticsId()!=null){
			//发货成功，记录通知
			 //2.添加转发通知
			//根据物流公司id查询物流公司
			DeliveryCorp corp=deliveryCorpMapper.selectCorpByid(orderDelivery.getLogisticsId());
			if(corp!=null && StringUtils.isNotEmpty(corp.getCorpCode())){
				Notice no=new Notice();
				no.setNoticeId(constantUtils.get_id());
				no.setTitle("订单已发货");
				no.setType(1);//物流
				no.setSpareField(corp.getCorpCode()+"_"+orderDelivery.getLogisticsNumber());
				no.setCreateDate(DateUtils.getDateTimeStr(new Date()));
				no.setLeftIcon(constantUtils.logisticsleftIcon);
				no.setIntroduction(orderDelivery.getProductName());
				no.setUserId(orderDelivery.getUserId());
				this.userMapper.insertNotice(no);
				this.userMapper.insertNoticeUser(no);
			}
		}
		
		
		
		return flag;
	}
	@Override
	public List<OrderMaster> selectByStatus(int orderStatus) {
		// TODO Auto-generated method stub
		return orderMasterMapper.selectByStatus(orderStatus);
	}
	@Override
	public boolean updateOrderStatusById(int id) {
		// TODO Auto-generated method stub
		return orderMasterMapper.updateOrderStatusById(id);
	}
	@Override
	public boolean updateOrderStatusByMasterId(int id) {
		// TODO Auto-generated method stub
		return orderMasterMapper.updateOrderStatusByMasterId(id);
	}
	@Override
	public boolean updateFinishStatus(int id) {
		// TODO Auto-generated method stub
		return orderMasterMapper.updateFinishStatus(id);
	}
}
