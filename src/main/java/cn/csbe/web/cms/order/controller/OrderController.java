package cn.csbe.web.cms.order.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.csbe.web.cms.common.HttpRequest;
import cn.csbe.web.cms.common.constantUtils;
import cn.csbe.web.cms.order.bean.DeliveryCorp;
import cn.csbe.web.cms.order.bean.OrderCostTime;
import cn.csbe.web.cms.order.bean.OrderDelivery;
import cn.csbe.web.cms.order.bean.OrderDetail;
import cn.csbe.web.cms.order.bean.OrderMaster;
import cn.csbe.web.cms.order.service.DeliveryCorpService;
import cn.csbe.web.cms.order.service.OrderCostService;
import cn.csbe.web.cms.order.service.OrderDeliveryService;
import cn.csbe.web.cms.order.service.OrderDetailService;
import cn.csbe.web.cms.order.service.OrderMasterService;
import cn.csbe.web.cms.product.bean.Product;
import cn.csbe.web.cms.product.service.ProductService;



/*
 * 订单
 * @author sxzhang
 */
@RequestMapping("/order")
@Controller
public class OrderController {
	@Autowired
	private OrderMasterService orderMasterService;
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderDeliveryService orderDeliveryService;
	@Autowired
	private OrderCostService orderCostService;
	@Autowired
	private DeliveryCorpService deliveryCorpService;
	/*
	 * 设置订单时长信息
	 * toSetOrder
	 */
	@RequestMapping("/toSetOrder")
	public Object toSetOrder(){
		return "/order/setOrderCostTime";
	}
	/*	设置退货地址
	 * toSetAddress
	 */
	@RequestMapping("/toSetAddress")
	public Object toSetAddress(){
		return "/order/setOrderAddress";
	}
	
	/*
	 * toOrder 
	 * 跳转到订单展示页面
	 * 加载所有订单信息
	 */
	@RequestMapping("/toOrder")
	@ResponseBody
	public ModelAndView toOrder(){
		ModelAndView model = new ModelAndView("order/showAllOrder");
		List<OrderMaster> list =orderMasterService.selectAllOrder();
		if(list.size()>0){
			for (OrderMaster orderMaster : list) {
				String num = orderMaster.getOrderSn();//获取订单编号
				List<OrderDetail> list1 = orderDetailService.selectAllDetailOrderByOrderSn(num);
				if(list1.size()>0){
					for (OrderDetail orderDetail : list1) {
						Integer productId = orderDetail.getProductId();
						Product pro = productService.selectById(productId);
						if(pro !=null && StringUtils.isNotEmpty(pro.getTitleImg())){
							orderDetail.setImgUrl(constantUtils.ImgHtmlPath+"images/"+pro.getTitleImg());
						}
					}
				}
				orderMaster.setOrderDetail(list1);
			}
		}

		model.addObject("list", list);
		return model;
	}
	/*
	 * 根据状态查询订单
	 * @param stateValue
	 */
	@RequestMapping("/selectAllOrder")
	@ResponseBody
	public ModelAndView  selectAllOrder(Integer stateValue){
		ModelAndView model = new ModelAndView("order/showAllOrder");
		List<OrderMaster> list = null;
		if(stateValue==6){//查询全部订单信息
			list =orderMasterService.selectAllOrder();
			if(list.size()>0){
				for (OrderMaster orderMaster : list) {
					String num = orderMaster.getOrderSn();//获取订单编号
					List<OrderDetail> list1 = orderDetailService.selectAllDetailOrderByOrderSn(num);
					//获取到子订单商品的id  根据商品id 查询商品标题图片
					if(list1.size()>0){
						for (OrderDetail orderDetail : list1) {
							Integer productId = orderDetail.getProductId();
							Product pro = productService.selectById(productId);
							if(StringUtils.isNotEmpty(pro.getTitleImg())){
							     orderDetail.setImgUrl(constantUtils.ImgHtmlPath+"images/"+pro.getTitleImg());
							}
						}
					}
					orderMaster.setOrderDetail(list1);
				}
			}
			
		}else{//根据订单状态去查询
			list =orderMasterService.selectAllOrder(stateValue);
			if(list.size()>0){
				for (OrderMaster orderMaster : list) {
					String num = orderMaster.getOrderSn();//获取订单编号
					List<OrderDetail> list1 = orderDetailService.selectAllDetailOrderByOrderSn(num);
					if(list1.size()>0){
						for (OrderDetail orderDetail : list1) {
							Integer productId = orderDetail.getProductId();
							Product pro = productService.selectById(productId);
							if(StringUtils.isNotEmpty(pro.getTitleImg())){
								orderDetail.setImgUrl(constantUtils.ImgHtmlPath+"images/"+pro.getTitleImg());
							}
						}
					}
					orderMaster.setOrderDetail(list1);
				}
			}
		}
		model.addObject("status", stateValue);
		model.addObject("list", list);
		return model;
	}
	/* @searchOrderByConditions
	 * 根据条件去查询详情订单
	 * @Param orderDetail
	 */
	@RequestMapping("/searchOrderByConditions")
	@ResponseBody
	public ModelAndView searchOrderByConditions(OrderDetail order,HttpServletRequest request){
		//根据订单编号查询出总订单和子订单(list) 把子订单赋值给总订单  根据子订单查询出商品id,根据id查询出商品对应的图片
		String productName= order.getProductName();
		String orderSn = order.getOrderSn();
		if(orderSn==""&&productName!=""){
			ModelAndView model = new ModelAndView("order/showAllOrder");
			List<OrderMaster> list = new ArrayList<OrderMaster>();
			List<OrderDetail> list1= new ArrayList<OrderDetail>();
			List<OrderDetail> list2= new ArrayList<OrderDetail>();
			Set<String> set = new HashSet<String>();
			//OrderMaster orderMaster = null;
			OrderDetail orderDetail=null;
			list1 =orderDetailService.searchOrderByConditions(order);//查询出来的详情订单的信息
			//根据商品名字去查询出子订单的订单编号 根据订单编号去查询出总订单信息以及子订单信息,
			//把所有的总订单信息添加进list集合 ，把子订单添加进list1
			if(list1.size()!=0){
				for (OrderDetail orderDetail1 : list1) {
					//根据名字查询出订单信息  名字可能会重复 同一个订单编号也会出现多次  ，把查询出来的订单编号添加到set集合里(去重) 遍历set集合，去获取到主订单的集合信息
					String sn = orderDetail1.getOrderSn();
					set.add(sn);
				}
				for (String string : set) {
					OrderMaster orderMaster = orderMasterService.selectAllOrder(string);
					if(orderMaster == null){
						continue;
					}else{
						list2 = orderDetailService.selectAllDetailOrderByOrderSn(string);//订单编号查子订单List
						if(list2.size()>0){
							for (OrderDetail orderDetail2 : list2) {
								Integer productId = orderDetail2.getProductId();
								Product pro = productService.selectById(productId);
								if(StringUtils.isNotEmpty(pro.getTitleImg())){
									orderDetail2.setImgUrl(constantUtils.ImgHtmlPath+"images/"+pro.getTitleImg());
								}
							}
						}
						orderMaster.setOrderDetail(list2);
						list.add(orderMaster);
					}
				}
			}
			if(list.size()==0){//判断查询出来数据的长度
				ModelAndView model1 = new ModelAndView("order/showNullOrder");
				return model1;
			}
			model.addObject("list", list);
			return model;
		}else{
			ModelAndView model = new ModelAndView("order/showAllOrder");
			List<OrderMaster> list = new ArrayList<OrderMaster>();
			List<OrderDetail> list1= new ArrayList<OrderDetail>();
			OrderMaster orderMaster= orderMasterService.selectAllOrder(orderSn);
			if(orderMaster == null){
				ModelAndView model1 = new ModelAndView("order/showNullOrder");
				return model1;
			}else{
				list1= orderDetailService.searchOrderByConditions(order);
				//获取到子订单商品的id  根据商品id 查询商品标题图片
				if(list1.size()>0){
					for (OrderDetail orderDetail : list1) {
						Integer productId = orderDetail.getProductId();
						Product pro = productService.selectById(productId);
						if(StringUtils.isNotEmpty(pro.getTitleImg())){
							orderDetail.setImgUrl(constantUtils.ImgHtmlPath+"images/"+pro.getTitleImg());
						}
					}
					orderMaster.setOrderDetail(list1);
					list.add(orderMaster);
				}else{//判断查询出来数据的长度
					ModelAndView model1 = new ModelAndView("order/showNullOrder");
					return model1;
				}
			}	
			model.addObject("list", list);
			return model;
		}
	}
	/*
	 * @Param orderSn
	 */
	@RequestMapping("/searchDetailOrderByOrderSn")
	@ResponseBody
	public ModelAndView searchDetailOrderByOrderSn(String orderSn){
		//根据订单编号查询出总订单和子订单(list) 把子订单赋值给总订单  根据子订单查询出商品id,根据id查询出商品对应的图片
		ModelAndView model = new ModelAndView("order/showDetailOrder");
		OrderMaster orderMaster = orderMasterService.selectAllOrder(orderSn);
		List<OrderMaster> list = new ArrayList<OrderMaster>();
		List<OrderDetail> list1= new ArrayList<OrderDetail>();
		list1= orderDetailService.selectAllDetailOrderByOrderSn(orderSn);
		//获取到子订单商品的id  根据商品id 查询商品标题图片
		if(orderMaster != null){
			if(list1.size()!=0){
				Integer userId=null;
				for (OrderDetail orderDetail : list1) {
					Integer productId = orderDetail.getProductId();
					Product pro = productService.selectById(productId);
					if(StringUtils.isNotEmpty(pro.getTitleImg())){
					   orderDetail.setImgUrl(constantUtils.ImgHtmlPath+"images/"+pro.getTitleImg());
					}
					userId=orderDetail.getUserId();
				}
				orderMaster.setUserId(userId);
				orderMaster.setOrderDetail(list1);
				list.add(orderMaster);
			}
		}else{
			ModelAndView model1 = new ModelAndView("order/showNullOrder");
			return model1;
		}	
		model.addObject("list", list);
		return model;
	}
	/*
	 * 添加物流发货订单addOrderDelivery
	 * @Param orderDelivery
	 */
	@RequestMapping("/addOrderDelivery")
	@ResponseBody
	public boolean addOrderDelivery(OrderDelivery orderDelivery){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		orderDelivery.setCreateDate(sdf.format(new Date()));
		boolean isAdd= orderDeliveryService.addOrderDelivery(orderDelivery);
		//修改订单状态 待发货--》已发货
		Integer id = orderDelivery.getOrderMasterId();
		if(isAdd){
			boolean isUpdate = orderMasterService.updateById(orderDelivery,id);
			if(isUpdate){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	/*
	 * 设置订单时长限制
	 * setTime
	 */
	@RequestMapping("/setTime")
	@ResponseBody
	public boolean setTime(OrderCostTime orderCostTime){
		int costTime = orderCostTime.getCostTime()*60*1000;
		int totalTime = orderCostTime.getTotalTime()*24*60*60*1000;
		int finishDate = orderCostTime.getFinishDate()*24*60*60*1000;
		orderCostTime.setCostTime(costTime);
		orderCostTime.setTotalTime(totalTime);
		orderCostTime.setFinishDate(finishDate);
		boolean isAdd = orderCostService.updateTime(orderCostTime);
		return isAdd;
	} 
	/*
	 * 查询物流信息
	 * queryDelivery
	 */
	@RequestMapping("/queryDelivery")
	@ResponseBody
	public Map<String,Object> queryDelivery(Integer id){
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//根据id去查询物流单号以及物流公司代码
		String url=constantUtils.WULIUURL;
		OrderDelivery delivery= orderDeliveryService.selectByOrderId(id);
		String corpNum = delivery.getLogisticsNumber();
		//System.out.println(corpNum);
		DeliveryCorp corp = deliveryCorpService.selectCorpByid(delivery.getLogisticsId());
		if(corp!=null){
			String code = corp.getCorpCode();
			String param ="corpCode="+code+"&corpNumber="+corpNum;
			System.out.println(param);
			String sendPost = HttpRequest.sendPost(url, param);
			JSONObject json = JSONObject.fromObject(sendPost);  
			map.put("corp",corp.getLogisticsName());
			map.put("result",json);
		}else{
			map.put("corp","");
			map.put("result",null);
		}
		
		return map;
	}
	/**
	 * 验证快递单号是否已经存在
	 * @param corpNumber
	 * @param url
	 * @return
	 */
	@RequestMapping("/validationLogisticsNumber")
	@ResponseBody
	public boolean validationOrderNum(String logisticsNumber){
	
		OrderDelivery delivery = orderDeliveryService.validationOrderNum(logisticsNumber);
		if(delivery !=null){
			return false;
		}
		return true;
	}
	
	
	/*
	 * 验证物流单号
	 * @param url corpNumber
	 * validationCorp
	 */
	@RequestMapping("/validationCorp")
	@ResponseBody
	public Map<String,Object> validationCorp(String corpNumber,String url){
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String param ="corpNumber="+corpNumber;
		String sendGet = HttpRequest.sendGet(url,param);
		JSONObject json = JSONObject.fromObject(sendGet); 
		map.put("result",json);
		return map;
	}
}
