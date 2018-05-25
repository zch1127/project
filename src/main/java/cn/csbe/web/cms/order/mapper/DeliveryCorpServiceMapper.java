package cn.csbe.web.cms.order.mapper;

import cn.csbe.web.cms.order.bean.DeliveryCorp;

public interface DeliveryCorpServiceMapper {
	//根据物流公司id查询物流公司
	DeliveryCorp selectCorpByid(Integer id);

}
