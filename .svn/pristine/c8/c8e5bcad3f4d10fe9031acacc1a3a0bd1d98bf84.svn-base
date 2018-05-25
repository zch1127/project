package cn.csbe.web.cms.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.order.bean.DeliveryCorp;
import cn.csbe.web.cms.order.mapper.DeliveryCorpServiceMapper;
import cn.csbe.web.cms.order.service.DeliveryCorpService;
@Service
public class DeliveryCorpServiceImpl implements DeliveryCorpService {
	@Autowired
	private DeliveryCorpServiceMapper deliveryCorpServiceMapper;
	@Override
	public DeliveryCorp selectCorpByid(Integer id) {
		// TODO Auto-generated method stub
		return deliveryCorpServiceMapper.selectCorpByid(id);
	}

}
