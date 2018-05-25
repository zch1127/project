package cn.csbe.web.cms.afterSale.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.afterSale.bean.RefundOrderDTO;
import cn.csbe.web.cms.afterSale.bean.RefundOrderDetailDTO;
import cn.csbe.web.cms.afterSale.bean.RefundOrderRecord;
import cn.csbe.web.cms.afterSale.bean.RefundSearchObj;

public interface RefundOrderMapper {
	//根据售后订单状态去查询售后订单信息
	//查询全部
	public List<RefundOrderDTO> selectRefundOrderByStatus1(Integer approveStatus);
	//根据环节查询
	public List<RefundOrderDTO> selectRefundOrderByStatus2(Integer approveStatus);
	
	//根据查询条件查询售后订单信息
	public List<RefundOrderDTO> selectRefundOrderByCon(RefundSearchObj rso);
	
	//查询退款详情
	public RefundOrderDetailDTO selectRefundItemById(Integer id);
	
	//查询退款记录
	public List<RefundOrderRecord> selectRefundItemByRefundId(Integer refundId);
	//更新退款状态
	public int updateRefund(@Param("id")Integer id,@Param("approveStatus")Integer approveStatus, @Param("modifyDate")Date modifyDate);
	//添加退款记录
	public int addRefundRecord(RefundOrderRecord ror);
	//根据退款id查询主订单号
	public int selectOrderMasterIdById(Integer id);

}
