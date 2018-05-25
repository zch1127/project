package cn.csbe.web.cms.activities.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.csbe.web.cms.activities.bean.Coupon;
import cn.csbe.web.cms.activities.bean.Coupon;
import cn.csbe.web.cms.activities.service.CouponReceiveService;
import cn.csbe.web.cms.activities.service.CouponService;
import cn.csbe.web.cms.common.DateUtils;

/**
 * @author: wffu
 * @date:2017-12-11 上午10:41:07
 * @version :
 * 
 */
@Controller
@RequestMapping("/activity/coupon")
public class CouponController {
	@Autowired
	private CouponService couponService;
	@Autowired
	private CouponReceiveService couponReceiveService;
	
	@RequestMapping("/showAllCoupon")
	public ModelAndView showAllCoupon(Integer activityStatus){
		ModelAndView model=new ModelAndView("activity/coupon/showAllCoupon");
		if(activityStatus == -1){
			List<Coupon> list = couponService.showAllCoupon();
			model.addObject("list", list);
			model.addObject("activityStatus",activityStatus);
			return model;
		}		
			List<Coupon> list = couponService.showAllCoupon(activityStatus);
			model.addObject("list", list);
			model.addObject("activityStatus",activityStatus);
			return model;
	}
	//展示所有优惠券
	@RequestMapping("/toShowAllCoupon")
	public ModelAndView toShowAllCoupon(Integer activityStatus){
		ModelAndView model= new ModelAndView("activity/coupon/showAllCoupon");
		model.addObject("activityStatus", activityStatus);
		return model;
	}
	
	//验证日期大小
	@ResponseBody
	@RequestMapping("/compareD1ToD2")
	  public Map<String,Object> compareD1ToD2(String date1,String date2){
	         
		Map<String,Object> map = new HashMap<String,Object>();
	        //将字符串格式的日期格式化
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        try {
	            //将日期转成Date对象作比较
	            Date fomatDate1=sdf.parse(date1);
	            Date fomatDate2=sdf.parse(date2);
	            //比较两个日期
	            int result=fomatDate2.compareTo(fomatDate1);
	            //如果日期相等返回0
	            if(result<=0){
	                System.out.println("两个时间相等");
	                map.put("msg", "开始日期应小于结束日期");
	                map.put("inputDate",false);
	            }else{
	                //大于0，参数date1就是在date2之前
	                System.out.println("date1小于date2");
	                map.put("inputDate",true);
	            }
	             
	        } catch (Exception e) {
	        	map.put("msg", "日期转换异常");
	        	map.put("inputDate",false); 
	            e.printStackTrace();
	        }
	        return map;
	    }
	
	
	//执行删除优惠券操作
	@RequestMapping("/deleteCoupon")
	public String deleteCoupon(int id,Integer activityStatus){
		boolean isDel = couponService.deleteCoupon(id);
		return "redirect:showAllCoupon?activityStatus="+activityStatus+"&isDel="+isDel;
	}

	//跳转到添加页面
	@RequestMapping("/toAddCoupon")
	public ModelAndView toAddCoupon(){
		ModelAndView model= new ModelAndView("activity/coupon/addCoupon");
		return model;
	}
	
	//执行添加优惠券操作
	@RequestMapping("/addCoupon")
	public String addCoupon(Coupon coupon,String startTimeStr,String endTimeStr,Model model){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try {
			if(startTimeStr!=null&&startTimeStr!=""){
				
				ts = Timestamp.valueOf(startTimeStr);
				coupon.setStartTime(ts);
				//System.out.println(ts);
			}
			if(endTimeStr!=null&&endTimeStr!=""){
				ts = Timestamp.valueOf(endTimeStr);
				coupon.setEndTime(ts);
				//System.out.println(ts);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		coupon.setCreateDate(DateUtils.getDateTimeStr(new Date()));
		coupon.setStatus(1);
		coupon.setActivityStatus(0);
		boolean isAdd = couponService.addCoupon(coupon);
		model.addAttribute("isAdd", isAdd);
		return "redirect:showAllCoupon?activityStatus=0";
	}
	
	//跳转到更新红包页面
		@RequestMapping("/toUpdateCoupon")
		public ModelAndView toUpdateCoupon(int id,Integer activityStatus,HttpSession session){
			ModelAndView view = new ModelAndView("activity/coupon/editCoupon");
			Coupon coupon = couponService.toUpdateCoupon(id);
			view.addObject("coupon",coupon);
			session.setAttribute("activityStatus11", activityStatus);
			return view;
		}
		//执行更新操作
		@RequestMapping("/updateCoupon")
		public String updateCoupon(Coupon coupon,String startTimeStr,String endTimeStr,ModelMap model,HttpSession session){
			Integer activityStatus = (Integer) session.getAttribute("activityStatus11");
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			if(startTimeStr!=null&&startTimeStr!=""){
				try {
					ts = Timestamp.valueOf(startTimeStr);
					coupon.setStartTime(ts);
					System.out.println(ts);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(endTimeStr!=null&&endTimeStr!=""){
				try {
					ts = Timestamp.valueOf(endTimeStr);
					coupon.setEndTime(ts);
					System.out.println(ts);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(coupon.getRemind()==null){
				coupon.setRemind(0);
			}
			
			boolean isUpate = couponService.updateCoupon(coupon);
			model.addAttribute("isUpate", isUpate);
			
			return "redirect:showAllCoupon?activityStatus="+activityStatus;
		}
	
	
	
	//跳转到已使用优惠券列表
	@RequestMapping("/toAllUsedCoupon")
	public ModelAndView toAllCouponReceive(Integer activityStatus,HttpSession session,Integer couponId){
		ModelAndView model= new ModelAndView("activity/coupon/usedCouponRecord");
		session.setAttribute("activityStatus11", activityStatus);
		session.setAttribute("couponId", couponId);
		return model;
	}
	//查询所有已使用优惠券列表
	@RequestMapping("/selectAllUsedCoupon")
	@ResponseBody
	public Map<String,Object> selectAllUsedCoupon(Integer page,Integer rows,HttpSession session){
		Integer activityStatus = (Integer) session.getAttribute("activityStatus11");
		Integer couponId = (Integer) session.getAttribute("couponId");
		Map<String,Object> map = couponReceiveService.selectAllCouponReceive(page,rows,activityStatus,couponId);
		System.out.println(page+rows+"*****");
		return map;
	}
	
	
	//定时改变优惠券活动状态
	public List<Coupon> selectStartEndDate(){
		List<Coupon> list= couponService.selectStartEndDate();
		Timestamp systemDate = new Timestamp(System.currentTimeMillis()); 
		if(list.size()>0){
			for (Coupon coupon : list) {
				Timestamp startTime = coupon.getStartTime();
				if(startTime.getTime()<systemDate.getTime()){
					couponService.changeCouponActivityStatus(coupon.getId(),1);
				}
				Timestamp endTime = coupon.getEndTime();
				if(startTime.getTime()<systemDate.getTime()){
					couponService.changeCouponActivityStatus(coupon.getId(),2);
					couponReceiveService.changeCouponReceiveUseStatus(coupon.getId());
					
				}
			}
		}
		return list;
	}
	
	
}
