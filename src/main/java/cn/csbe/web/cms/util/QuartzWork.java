package cn.csbe.web.cms.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.csbe.web.cms.common.DateUtils;
import cn.csbe.web.cms.common.HttpRequest;
import cn.csbe.web.cms.common.constantUtils;
import cn.csbe.web.cms.push.bean.PubNotice;
import cn.csbe.web.cms.push.bean.UserNotice;
import cn.csbe.web.cms.push.service.PubNoticeService;
import cn.csbe.web.cms.push.service.UserNoticeService;
import cn.csbe.web.cms.user.service.IUserService;

/**
 * 定时推送活动
 * Title: QuartzWork  
 * @author sxzhang 
 * @date 上午9:44:51
 */
public class QuartzWork {
	//日志信息
	private static final Logger logger = LoggerFactory.getLogger(QuartzWork.class);
	
	@Autowired
	private PubNoticeService pubNoticeService;
	@Autowired
	private IUserService userService;
	@Autowired
	private UserNoticeService userNoticeService;
	/**
	 * 定时推送活动 8:00 9:30 16:00  19:00 21:00
	 * 同一个任务  五个定时去调用这个任务
	 * @param time 
	 * @throws UnsupportedEncodingException 
	 */
	public void work() throws UnsupportedEncodingException{
		String dateTimeStr = DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd HH:mm");
		//查询系统通知(固定通知、活动通知)
		PubNotice pubNotice = pubNoticeService.queryByTime(dateTimeStr);
		String sendPost="";
		//在这个任务中不进行判断 在controller层进行数据的判断
		if(pubNotice !=null){
			String htmlurl="",introduction="",createDate="";
			String title=URLEncoder.encode(pubNotice.getTitle(),"UTF-8");
			String twoType=URLEncoder.encode(pubNotice.getTwoType().toString(),"UTF-8");
			if(StringUtils.isNotEmpty(pubNotice.getIntroduction())){
				introduction=URLEncoder.encode(pubNotice.getIntroduction(),"UTF-8");
			}
			if(!StringUtils.isEmpty(pubNotice.getHtmlUrl())){
				htmlurl=URLEncoder.encode(pubNotice.getHtmlUrl(),"UTF-8");
			}
			if(!StringUtils.isEmpty(pubNotice.getCreateDate())){
				createDate=URLEncoder.encode(pubNotice.getCreateDate(),"UTF-8");
			}
			
			String param = "title="+title+"&introduction="+introduction+"&createDate="+createDate+"&htmlUrl="+htmlurl+"&type="+twoType;
			System.out.println(param);
//			sendPost = HttpRequest.sendPost("http://localhost/buddha-api/push/systemdaily", param);
			sendPost = HttpRequest.sendPost(constantUtils.noticeUrl, param);
		}
		
		logger.info("========日志：定时推送任务结果   ============="+sendPost);
	}
	public void payWork() throws UnsupportedEncodingException{
		logger.info("========付费消息通知   =============");
		//查询系统通知(付费通知)
		List<PubNotice> payNotices = pubNoticeService.queryByTwoType();
		String ids="";
		for (PubNotice payNotice : payNotices) {
			//查询出这条付费信息对应的付费用户
			List<cn.csbe.web.cms.user.bean.PubUser> list =userService.findUserByPayLogAndTemple(payNotice);
			//noticeId=61a4291ed3a04a89917f58ca72adbd1b, type=0, title=东华禅寺, introduction=测试数据, 
			/*htmlUrl=http://localhost:8091/buddha-img/modelPay/payNotice/981807.html, twoType=3, picture=null,
				createDate=2018-03-20 16:13:00.0, modifyDate=null, status=1, infoType=5, leftIcon=null, 
				spareField=null, templeId=1, payNoticeDetailTitle=东华禅师点灯]]*/
			UserNotice user = new UserNotice();
			user.setNoticeId(payNotice.getNoticeId());
			user.setCreateDate(DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd HH:mm"));
			
			for (cn.csbe.web.cms.user.bean.PubUser pubUser : list) {
				user.setUserId(pubUser.getUserId());
				ids+=pubUser.getUserId()+",";
				
				boolean isadd = userNoticeService.addUserAndNoticeRelation(user);
				System.out.println(isadd);
			}
			ids=ids.substring(0, ids.length()-1);
			System.out.println(ids);
			String sendPost="";
			//在这个任务中不进行判断 
			if(payNotice !=null){
				//byte[] b=payNotice.getTitle().getBytes("utf-8");//
				//byte[] c=payNotice.getIntroduction().getBytes("utf-8");//
				//System.out.println(title+introduction);
				String htmlurl="",introduction="",createDate="";
				String title=URLEncoder.encode(payNotice.getTitle(),"UTF-8");
				String twoType=URLEncoder.encode(payNotice.getTwoType().toString(),"UTF-8");
				if(StringUtils.isNotEmpty(payNotice.getIntroduction())){
					introduction=URLEncoder.encode(payNotice.getIntroduction(),"UTF-8");
				}
				if(!StringUtils.isEmpty(payNotice.getHtmlUrl())){
					/*htmlurl=URLEncoder.encode(payNotice.getHtmlUrl(),"UTF-8");
					htmlurl=URLDecoder.decode(htmlurl, "UTF-8");*/
					htmlurl=payNotice.getHtmlUrl();
				}
				if(!StringUtils.isEmpty(user.getCreateDate())){
					createDate=user.getCreateDate();
					//System.out.println(user.getCreateDate());
				}
			
				String param = "title="+title+"&introduction="+introduction+"&createDate="+createDate+"&htmlUrl="+htmlurl+"&userIds="+ids;
				System.out.println(param);
				//sendPost = HttpRequest.sendPost("http://localhost/buddha-api/push/muluser", param);
				sendPost = HttpRequest.sendPost(constantUtils.payNoticeUrl, param);
				// title=11&introduction=aa&createDate=2018-03-06+10%3A59%3A00.0&htmlUrl=https%3A%2F%2Flocalhost%3A8088%2Fbuddha-img%2Fmodel%2FpayNotice%2F298073.html&userIds=16
				//{"code":1000,"message":"系统处理成功","object":"{\"ret\":\"SUCCESS\",\"data\":{\"msg_id\":\"uabypah152030722323401\"}}"}
			}
			
			logger.info("========付款用户：定时消息通知   ============="+sendPost);
		}

	}
}
