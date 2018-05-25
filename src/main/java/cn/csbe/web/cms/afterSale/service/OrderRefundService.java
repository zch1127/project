package cn.csbe.web.cms.afterSale.service;

import java.util.List;

import cn.csbe.web.cms.afterSale.bean.RefundOrderDTO;
import cn.csbe.web.cms.afterSale.bean.RefundOrderDetailDTO;
import cn.csbe.web.cms.afterSale.bean.RefundOrderRecord;
import cn.csbe.web.cms.afterSale.bean.RefundSearchObj;

public interface OrderRefundService {
	//根据订单状态查询
	List<RefundOrderDTO> selectAllOrderRefundByStatus(Integer approveStatus);
	
	//根据条件查询
	List<RefundOrderDTO> selectRefundOrderByCon(RefundSearchObj rso);
	
	//查询退款详情
	public RefundOrderDetailDTO selectRefundItemById(Integer id);

	boolean addRecordAndUpdateRefund(Integer id,Integer approveStatus,RefundOrderRecord ror);
	
	


}
