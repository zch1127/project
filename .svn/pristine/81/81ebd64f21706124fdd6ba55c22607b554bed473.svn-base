package cn.csbe.web.cms.activityalert.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.csbe.web.cms.activityalert.bean.ActivityAlert;
import cn.csbe.web.cms.activityalert.service.ActivityAlertService;
import cn.csbe.web.cms.auth.bean.UserPassword;
import cn.csbe.web.cms.common.CSBE;
import cn.csbe.web.cms.common.DateUtils;
import cn.csbe.web.cms.common.Result;
import cn.csbe.web.cms.common.UploadResult;
import cn.csbe.web.cms.common.UploadUtils;
import cn.csbe.web.cms.common.constantUtils;
import cn.csbe.web.cms.common.bean.Message;

/**
 * 活动弹窗控制
 * Title: ActivityAlertController  
 * @author sxzhang 
 * @date 上午10:25:04
 */
@Controller
@RequestMapping("alert")
public class ActivityAlertController {
	@Autowired
	private ActivityAlertService activityAlertService;
	
	/**
	 * 跳转到查询所有页面
	 * showAll
	 */
	@RequestMapping("showAll")
	public Object toShowAllActivityAlert(){
		return "/alert/showAllAlertActivity";
	}
	/**
	 * 查询所有弹窗活动
	 * selectAllAlert
	 */
	@RequestMapping("selectAllAlert")
	@ResponseBody
	public Map<String,Object> selectAllAlert(Integer page,Integer rows,Integer status){
		Map<String,Object> map= new HashMap<String,Object>();
		String dateTimeStr = DateUtils.getDateTimeStr(new Date());
		if(status == null || status == 0){//查询全部数据
			map = activityAlertService.selectAllAlert(page,rows);
		}else if(status == 1){//未开始
			map = activityAlertService.selectAllAlertByStatus(page,rows,dateTimeStr);
		}else if(status == 2){//进行中
			map = activityAlertService.selectAlertOngoing(page,rows,dateTimeStr);
		}else if(status == 3){//已结束
			map = activityAlertService.selectAllFinishedAlert(page,rows,dateTimeStr);
			
		}
		return map;
	}
	/**
	 * 添加活动数据
	 */
	@RequestMapping("addAlert")
	@ResponseBody
	public Map<String,Object> addAlert(ActivityAlert activityAlert){
		Map<String,Object> map= new HashMap<String,Object>();
		activityAlert.setCreateTime(DateUtils.getDateTimeStr(new Date()));
		boolean isAdd = activityAlertService.addAlert(activityAlert);
		map.put("isAdd", isAdd);
		return map;
	}
	/**
	 * 修改活动数据
	 */
	@RequestMapping("updateAlert")
	@ResponseBody
	public Map<String,Object> updateAlert(ActivityAlert activityAlert){
		Map<String,Object> map= new HashMap<String,Object>();
		boolean isUpdate = activityAlertService.updateAlert(activityAlert);
		map.put("isAdd", isUpdate);
		return map;
	}
	/**
	 * 批量删除操作
	 * deleteManyAlertActivity
	 */
	/**
	 * 修改活动数据
	 */
	@RequestMapping("deleteManyAlertActivity")
	@ResponseBody
	public Map<String,Object> deleteManyAlertActivity(Integer[] alertId){
		Map<String,Object> map= new HashMap<String,Object>();
		boolean isDelete = activityAlertService.deleteManyAlertActivity(alertId);
		map.put("isAdd", isDelete);
		return map;
	}
	
	/**
	 * 图片上传
	 */
	/*@RequestMapping(value = "upload/pictrue", method = RequestMethod.POST)
	@ResponseBody
	private Object uploadfile(@RequestParam("upfile") CommonsMultipartFile mFile, HttpServletRequest request,
			HttpServletResponse response, UserPassword userPassword) throws Exception {
		
		UploadResult uploadResult = UploadUtils.upload(request, mFile,constantUtils.ALERT_IMG);
		
		if (uploadResult == null || uploadResult.getStatus() != CSBE.OK) {
			return new Message(false, "不合法的文件类型");
		}
		
		return CSBE.encryption(new Result(CSBE.OK, "上传成功", uploadResult.getValue()));
		
	}*/
		
}

