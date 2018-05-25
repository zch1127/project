package cn.csbe.web.cms.push.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.csbe.web.cms.common.CSBE;
import cn.csbe.web.cms.common.DateUtils;
import cn.csbe.web.cms.common.ToHtml;
import cn.csbe.web.cms.common.ToHtmlPay;
import cn.csbe.web.cms.common.constantUtils;
import cn.csbe.web.cms.push.bean.PubNotice;
import cn.csbe.web.cms.push.service.PubNoticeService;
import cn.csbe.web.cms.push.service.UserNoticeService;
import cn.csbe.web.cms.user.service.IUserService;

/**
 * 推送活动
 * Title: PubNoticeController  
 * @author sxzhang 
 * @date 下午1:56:54
 */
@Controller
@RequestMapping("push")
public class PubNoticeController {
	@Autowired
	private PubNoticeService pubNoticeService;
	@Autowired
	private UserNoticeService userNoticeService;
	@Autowired
	private IUserService userService;
	/**
	 * toShowAllPush
	 * @return
	 */
	@RequestMapping("toShowAllPush")
	public Object toShowAllPush(){
		
		return "/notice/showAllPush";
	}
	
	/**
	 * toAddPayNotice
	 * @return
	 */
	@RequestMapping("toAddPayNotice")
	public Object addPayNotice(){
		
		
		return "/notice/addPayNotice";
	}
	
	/**
	 * toAddNotice
	 * @return
	 */
	@RequestMapping("toAddNotice")
	public Object toAddNotice(){
		
		return "/notice/addNotice";
	}
	/**
	 * toEditPush
	 * 跳转到编辑页面
	 */
	@RequestMapping("toEditPush")
	private ModelAndView toEditPush(String noticeId) throws Exception {

		ModelAndView view = new ModelAndView();

		PubNotice obj = pubNoticeService.findById(noticeId);
		view.addObject("notice", obj);
		System.out.println(obj.getTwoType()+"======================================="+obj.getIntroduction());
		view.setViewName("notice/editNotice");

		return view;
	}
	/**
	 * toPayEditPush
	 * 跳转到付费编辑页面
	 */
	@RequestMapping("toEditPayPush")
	private ModelAndView toPayEditPush(String noticeId) throws Exception {
		
		ModelAndView view = new ModelAndView();
		
		PubNotice obj = pubNoticeService.findById(noticeId);
		view.addObject("notice", obj);
		System.out.println(obj.getTwoType()+"======================================="+obj.getIntroduction());
		view.setViewName("notice/editPayNotice");
		
		return view;
	}
	
	/**
	 * 展示全部推送活动
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("showAllPush")
	@ResponseBody
	public Map<String,Object> showAllPush(Integer page,Integer rows){
		
		Map<String,Object> map = new HashMap<String,Object>(); 
		map = pubNoticeService.queryAllPush(page,rows);
		return map;
	}
	
	
	
	/**
	 * 添加推送
	 * addNotice
	 * @return
	 */
	@RequestMapping("/addNotice")
	@ResponseBody
	public boolean addNotice(PubNotice pubNotice) throws Exception{
		String time=DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd HH:mm");
		System.out.println(pubNotice.getTwoType());
		if(StringUtils.isNotEmpty(pubNotice.getHtmlUrl())){
			pubNotice.setHtmlUrl(pubNotice.getHtmlUrl().trim());
		}
		
		pubNotice.setNoticeId(constantUtils.get_id());
		pubNotice.setLeftIcon(constantUtils.noticeIcon);
		boolean isAdd = pubNoticeService.addNotice(pubNotice);
		return isAdd;
	}
	
	/**
	 * 
	 */
	
	/**添加付款模块通知
	 *
	 */
	@RequestMapping("/addPayNotice")
	@ResponseBody
	public boolean addPayNotice(PubNotice pubNotice) throws Exception{
		String time=DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd HH:mm");
		//System.out.println(pubNotice.getInfoType());
		pubNotice.setType(0);
		pubNotice.setTwoType(3);
		if(!StringUtils.isEmpty(pubNotice.getHtmlUrl())){
			String content=pubNotice.getHtmlUrl();
			if(content.contains(CSBE.localStr)){
				content=content.replaceAll(CSBE.localStr,CSBE.htmlPath);
			}
			int rand=CSBE.getRandomNum();
			//将html内容生成html页面，将链接存储到数据库中
			ToHtmlPay.service("modelPay", "/modelPay/payNotice/", rand,pubNotice.getPayNoticeDetailTitle(), pubNotice.getCreateDate(),123, content);
			pubNotice.setHtmlUrl(CSBE.htmlPath+"modelPay/payNotice/"+rand+".html");
	   }
		pubNotice.setNoticeId(constantUtils.get_id());
		boolean isAdd = pubNoticeService.addNotice(pubNotice);
		System.out.println(isAdd);
		/*UserNotice user = new UserNotice();
		if(isAdd){//添加推荐活动成功
			//4.积庆寺—捐赠建塔--供认青石
	        //6、供奉--祈福 （四种） 7、供奉--超度 8、供奉--供斋 9、供奉--供僧 
	        //10、请灯祈福--吉祥如意（三种灯） 11、请灯祈福--光明智慧 12、请灯祈福--荷花转运 13、许愿（寺内挂许愿条需付费） 
	        //14、敲钟 
			//3供奉付费通知 4点灯通知 5敲钟通知 6许愿通知 7积庆寺通知
		 	if(pubNotice.getTwoType() == 3 ){
				
				if(pubNotice.getTempleId()!=null){
					
					int templeId = pubNotice.getTempleId();
					pubNotice.setTempleId(templeId);
				}
				user.setNoticeId(pubNotice.getNoticeId());
				user.setCreateDate(time);
				List<cn.csbe.web.cms.user.bean.PubUser> list =userService.findUserByPayLogAndTemple(pubNotice);
				
				for (cn.csbe.web.cms.user.bean.PubUser pubUser : list) {
					user.setUserId(pubUser.getUserId());
					boolean isadd = userNoticeService.addUserAndNoticeRelation(user);
				}
			}
		}*/
		return isAdd;
	}
	@RequestMapping("deleteNotice")
	@ResponseBody
	public boolean deleteNotice(String[] noticeId){
		boolean isDelete = pubNoticeService.deleteNotice(noticeId);
		return isDelete;
	}
	
	/**
	 * 编辑数据
	 * editNotice
	 * @return
	 */
	@RequestMapping("editNotice")
	@ResponseBody
	public boolean editNotice(PubNotice pubNotice){
		pubNotice.setModifyDate(DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd HH:mm"));//设置修改时间
		System.out.println(pubNotice);
		pubNotice.setModifyDate(DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd HH:mm"));
		if(StringUtils.isNotEmpty(pubNotice.getHtmlUrl())){
			pubNotice.setHtmlUrl(pubNotice.getHtmlUrl().trim());
		}
		boolean isEdit = pubNoticeService.editNotice(pubNotice);
		
		return isEdit;
	}
	/**
	 * 编辑付费推送数据
	 * editNotice
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("editPayNotice")
	@ResponseBody
	public boolean editPayNotice(PubNotice pubNotice) throws ServletException, IOException{
		System.out.println(pubNotice);
		String time=DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd HH:mm");
		pubNotice.setModifyDate(DateUtils.getDateTimeStr(time));//设置修改时间
		//System.out.println(pubNotice.getInfoType());
		if(!StringUtils.isEmpty(pubNotice.getHtmlUrl())){
			String content=pubNotice.getHtmlUrl();
			if(content.contains(CSBE.localStr)){
				content=content.replaceAll(CSBE.localStr,CSBE.htmlPath);
			}
			int rand=CSBE.getRandomNum();
			//将html内容生成html页面，将链接存储到数据库中
			ToHtmlPay.service("modelPay", "/modelPay/payNotice/", rand,pubNotice.getPayNoticeDetailTitle(), pubNotice.getCreateDate(),123, content);
			pubNotice.setHtmlUrl(CSBE.htmlPath+"modelPay/payNotice/"+rand+".html");
	   }
		boolean isAdd = pubNoticeService.editPayNotice(pubNotice);
		System.out.println(isAdd);
		return isAdd;
	
	}
	
	
}
