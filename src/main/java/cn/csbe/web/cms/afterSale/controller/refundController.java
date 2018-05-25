package cn.csbe.web.cms.afterSale.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.csbe.web.cms.afterSale.bean.RefundOrderDTO;
import cn.csbe.web.cms.afterSale.bean.RefundOrderDetailDTO;
import cn.csbe.web.cms.afterSale.bean.RefundOrderRecord;
import cn.csbe.web.cms.afterSale.bean.RefundSearchObj;
import cn.csbe.web.cms.afterSale.service.OrderRefundService;

/*
 * 订单
 * @author 
 */
@RequestMapping("/refund")
@Controller
public class refundController {

	@Autowired
	private OrderRefundService orderRefundService;
	/*
	 * selectByStatus 
	 * 跳转到售后订单展示页面
	 * 根据售后订单状态加载所有售后订单信息
	 */
	//根据状态查询售后订单
	@RequestMapping("/selectAllOrderRefundByStatus")
	public ModelAndView selectAllOrderRefundByStatus(Integer approveStatus){
		ModelAndView model = new ModelAndView("afterSale/refundOrder");
		List<RefundOrderDTO> list =orderRefundService.selectAllOrderRefundByStatus(approveStatus);
		System.out.println(list+"****");
		model.addObject("list", list);
		model.addObject("approveStatus",approveStatus);
		return model;
	}
	/**
	 * selectByStatus
	 *
	 * 根据条件查询
	 * 跳转到售后订单展示页面
	 * @param rso
	 * @return
	 * @throws ParseException 
	 */
	//多条件查询售后订单
	@RequestMapping("/selectRefundOrderByCon")
	public ModelAndView selectRefundOrderByCon(RefundSearchObj rso,String startCreateDate,String endCreateDate,HttpServletRequest request) throws ParseException{
		System.out.println(rso);
		System.out.println(rso+startCreateDate+endCreateDate+"****");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//对日期字符串做非空判断
		if(startCreateDate!=null&&startCreateDate!=""){
			Date startDate1 = sdf.parse(startCreateDate);
			java.sql.Date startDate = new java.sql.Date(startDate1.getTime());
			rso.setPayStartDate(startDate);
		}
		if(endCreateDate!=null&&endCreateDate!=""){
			Date endDate1 = sdf.parse(endCreateDate);
			java.sql.Date endDate = new java.sql.Date(endDate1.getTime());
			rso.setPayEndDate(endDate);
		}
		
		ModelAndView model = new ModelAndView("afterSale/refundOrder");
		List<RefundOrderDTO> list =orderRefundService.selectRefundOrderByCon(rso);
		System.out.println(list);
		model.addObject("list", list);
		model.addObject("approveStatus",4);
		return model;
	}
	//查询订单记录和订单详情 
	@RequestMapping("/selectRefundItemById")
	public ModelAndView selectRefundItemById(Integer id){
		ModelAndView model = new ModelAndView("afterSale/refundOrderRecord");
		RefundOrderDetailDTO rodd =orderRefundService.selectRefundItemById(id);
		System.out.println(rodd+"****");
		model.addObject("rodd", rodd);
		return model;
	}
	
	
	//卖家操作，点击退款，增加退款记录，改变退款详情状态
	
	@RequestMapping("/addRecordAndUpdateRefund")
	public String addRecordAndUpdateRefund(Integer id,Integer approveStatus){
		//针对单个卖家时，后期多个卖家需要维护
		int userId = 1;
		
		RefundOrderRecord ror=new RefundOrderRecord();
		ror.setRefundId(id);
		ror.setUserId(userId);
		
		boolean i =orderRefundService.addRecordAndUpdateRefund(id,approveStatus,ror);
		System.out.println(i+"****");
		
		return "redirect:selectAllOrderRefundByStatus?approveStatus=4";
	}
	
}
