package cn.csbe.web.cms.activities.controller;

import java.io.Serializable;
import java.sql.Timestamp;
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
import cn.csbe.web.cms.activities.bean.RedPacket;
import cn.csbe.web.cms.activities.service.RedPacketReceiveService;
import cn.csbe.web.cms.activities.service.RedPacketService;

/**
 * @author: wffu
 * @date:2017-12-11 上午10:42:52
 * @version :
 * 
 */
@Controller
@RequestMapping("/activity")
public class RedPacketController implements Serializable {
	@Autowired
	private RedPacketService redPacketService;
	@Autowired
	private RedPacketReceiveService redPacketReceiveService;
	
	@RequestMapping("/showAllRedPacket")
	public ModelAndView showAllRedPacket(Integer activityStatus){
		ModelAndView model= new ModelAndView("activity/redPacket/redPacket");
		List<RedPacket> list = redPacketService.showAllRedPacket(activityStatus);
		
		model.addObject("list", list);
		model.addObject("activityStatus",activityStatus);
		return model;
	}
	
	
	//跳转到红包列表页面
	@RequestMapping("/toAllRedPacket")
	public ModelAndView toAllRedPacket(){
		ModelAndView model= new ModelAndView("activity/redPacket/redPacket");
		
		return model;
	}
	
	
	
	
	//跳转到添加红包页面
	@RequestMapping("/toAddRedPacket")
	public ModelAndView toAddRedPacket(Integer activityStatus){
		ModelAndView model= new ModelAndView("activity/redPacket/addRedPacket");
		return model;
	}
	//执行添加红包操作
	@RequestMapping("/addRedPacket")
	public String addRedPacket(RedPacket redPacket,String startTimeStr,String endTimeStr,Model model){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try {
			if(startTimeStr!=null&&startTimeStr!=""){
				
					ts = Timestamp.valueOf(startTimeStr);
					redPacket.setStartTime(ts);
					System.out.println(ts);
				
			}
			if(endTimeStr!=null&&endTimeStr!=""){
				
					ts = Timestamp.valueOf(endTimeStr);
					redPacket.setEndTime(ts);
					System.out.println(ts);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean isAdd = redPacketService.addRedPacket(redPacket);
		//model.addAttribute("isAdd", isAdd);
		return "redirect:showAllRedPacket?activityStatus=0";
	}
	
	
	
	//删除红包
	@RequestMapping("/deleteRedPacket")
	public String deleteRedPacket(int id,Integer activityStatus,Model model){
		
		boolean isDel = redPacketService.deleteRedPacket(id);
		return "redirect:showAllRedPacket?activityStatus="+activityStatus+"&isDel="+isDel;
	}
	
	
	
	//跳转到更新红包页面
	@RequestMapping("/toUpdateRedPacket")
	public ModelAndView toUpdateRedPacket(int id,Integer activityStatus,HttpSession session){
		ModelAndView view = new ModelAndView("activity/redPacket/editRedPacket");
		RedPacket redPacket = redPacketService.toUpdateRedPacket(id);
		view.addObject("redPacket",redPacket);
		session.setAttribute("activityStatus11", activityStatus);
		return view;
	}
	//执行更新操作
	@RequestMapping("/updateRedPacket")
	public String updateRedPacket(RedPacket redPacket,String startTimeStr,String endTimeStr,ModelMap model,HttpSession session){
		Integer activityStatus = (Integer) session.getAttribute("activityStatus11");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		if(startTimeStr!=null&&startTimeStr!=""){
			try {
				ts = Timestamp.valueOf(startTimeStr);
				redPacket.setStartTime(ts);
				System.out.println(ts);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(endTimeStr!=null&&endTimeStr!=""){
			try {
				ts = Timestamp.valueOf(endTimeStr);
				redPacket.setEndTime(ts);
				System.out.println(ts);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		boolean isUpate = redPacketService.updateRedPacket(redPacket);
		model.addAttribute("isUpate", isUpate);
		model.addAttribute("activityStatus", activityStatus);
		
		return "redirect:showAllRedPacket?activityStatus="+activityStatus;
	}
	
	
	
	
	//跳转到红包提现页面
	@RequestMapping("/toAllRedPacketReceive")
	public ModelAndView toAllRedPacketReceive(Integer activityStatus,HttpSession session,Integer redPacketId){
		ModelAndView model= new ModelAndView("activity/redPacket/redPacketWithDraw");
		session.setAttribute("activityStatus11", activityStatus);
		session.setAttribute("redPacketId", redPacketId);
		return model;
	}
	//查询所有提现红包
	@RequestMapping("/selectAllRedPacketReceive")
	@ResponseBody
	public Map<String,Object> selectAllRedPacketReceive(Integer page,Integer rows,HttpSession session,Integer isRemit){
		Integer activityStatus = (Integer) session.getAttribute("activityStatus11");
		Integer redPacketId = (Integer) session.getAttribute("redPacketId");
		activityStatus=1;
		redPacketId=44;
				
		Map<String,Object> map = redPacketReceiveService.selectAllRedPacketReceive(page,rows,activityStatus,redPacketId,isRemit);
		//System.out.println(page+rows+"*****");
		return map;
	}
	
	//定时改变红包活动状
	public List<RedPacket> selectStartEndDate(){
		List<RedPacket> list= redPacketService.selectStartEndDate();
		Timestamp systemDate = new Timestamp(System.currentTimeMillis()); 
		for (RedPacket redPacket : list) {
			Timestamp startTime = redPacket.getStartTime();
			if(startTime.getTime()<systemDate.getTime()){
				redPacketService.changeRedPacketActivityStatus(redPacket.getId(),1);
			}
			Timestamp endTime = redPacket.getEndTime();
			if(startTime.getTime()<systemDate.getTime()){
				redPacketService.changeRedPacketActivityStatus(redPacket.getId(),2);
				redPacketReceiveService.changeRedPacketReceiveUseStatus(redPacket.getId());
			}
		}
		return list;
	}
	
	//打款给用户
	
	@RequestMapping("/remit")
	@ResponseBody
	public boolean remit(String[] idss){
		boolean j=false;
		if(idss!=null){
			Integer[] ids=new Integer[idss.length];
			for (int i = 0; i < idss.length; i++) {
				ids[i]=Integer.parseInt(idss[i]);
				
			}
			j = redPacketReceiveService.changeRemitStatus(ids);
		}
		
		return j;
	}
}
