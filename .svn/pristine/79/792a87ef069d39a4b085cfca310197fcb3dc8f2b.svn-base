package cn.csbe.web.cms.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.csbe.web.cms.order.bean.OrderCostTime;
import cn.csbe.web.cms.order.bean.OrderMaster;
import cn.csbe.web.cms.order.service.OrderCostService;
import cn.csbe.web.cms.order.service.OrderMasterService;


/**
 * @author sxzhang
 * 创建时间：2017-12-7下午14:10:29
 * 描述：定时器执行类
 */
public class QuartzJob1 {
	@Autowired
	private OrderMasterService orderMasterService;
	@Autowired
	private OrderCostService orderCostService;
	public void work(){  
	 /**
	  *  定时更新   清理未付款订单 
	  *       a. 查询下单的时间
	  *       b. 将过期订单数据更新状态为失效  
	  *       暂时去掉
	  */
		Date date = new Date();  
		long time = date.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dd = null; //初始化date
		int orderStatus = 0;
		List<OrderMaster> list = orderMasterService.selectByStatus(orderStatus);
		
		OrderCostTime cs =orderCostService.selectById(1); 
		if(list.size()!=0){
			for (OrderMaster orderMaster : list) {
				String str =orderMaster.getCreateDate();
				if(str==""||str==null){
					continue;
				}else{
					try {
						dd = sdf.parse(str); //Mon Jan 14 00:00:00 CST 2013
						//long 计算出来的是毫秒
						long time2 = dd.getTime();
						long time1 = time-time2;
						long time3 = cs.getCostTime();//订单创建到订单取消的时间
						if(time1>time3){
							int id = orderMaster.getId();
							boolean isUpdate = orderMasterService.updateOrderStatusById(id);
							if(isUpdate){
								System.out.println("处理成功");
							}else{
								System.out.println("清理失败");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}//把string类型的时间装换成date类型的数据 和当前系统时间进行比较  比较的结果大于30分钟  就去修改订单的状态
			}
		}else{
			System.out.println("没有要处理的订单了");
		}
    }  
}
