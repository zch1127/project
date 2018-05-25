package cn.csbe.web.cms.information.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.csbe.web.cms.auth.bean.UserPassword;
import cn.csbe.web.cms.common.CSBE;
import cn.csbe.web.cms.common.DateUtils;
import cn.csbe.web.cms.common.Result;
import cn.csbe.web.cms.common.ToHtml;
import cn.csbe.web.cms.common.UploadResult;
import cn.csbe.web.cms.common.UploadUtils;
import cn.csbe.web.cms.common.constantUtils;
import cn.csbe.web.cms.common.bean.Message;
import cn.csbe.web.cms.information.bean.NewsInformation;
import cn.csbe.web.cms.information.service.NewsInformationService;
import cn.csbe.web.cms.news.bean.PubNews;
import cn.csbe.web.cms.wallpager.bean.PubTheme;

/**
 * 新闻资讯
 * @author sxzhang
 *
 */
@Controller
@RequestMapping("/information")
public class NewsInformationController {
	@Autowired
	private NewsInformationService newsInformationService;
	
	/**
	 * 跳转
	 * toShowInformation
	 */
	@RequestMapping("/toShowInformation")
	public Object toShowInformation (){
		return "/information/information";
	}
	/**
	 * 跳转  
	 * toAddInformation
	 */
	@RequestMapping("/toAddInformation")
	public Object toAddInformation (){
		return "/information/addInformation";
	}
	/**
	 * 跳转到编辑
	 * toEditInformation
	 */
	@RequestMapping("/toEditInformation")
	public ModelAndView toEditInformation (Integer infoId) throws Exception{
		
		ModelAndView view = new ModelAndView();
		NewsInformation newsInformation = (NewsInformation) newsInformationService.findById(infoId);
		view.addObject("newsInformation", newsInformation);
		view.setViewName("information/editInformation");
		return view;
	}
	/**
	 * 展示所有的新闻资讯信息
	 * showInformation
	 * @return
	 */
	@RequestMapping("/showInformation")
	@ResponseBody
	public Map<String,Object> showInformation(Integer page,Integer rows){
		return newsInformationService.selectAllInformation(page,rows);
	}
	/**
	 * 添加
	 * addInformation
	 * @return
	 */
	@RequestMapping("/addInformation")
	@ResponseBody
	public boolean addInformation(NewsInformation newsInformation) throws Exception{
		String time = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(StringUtils.isEmpty(newsInformation.getCreateTime())){//判断字符是否为空
			time=DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd");
			newsInformation.setCreateTime(DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
		}else{
			time = DateUtils.getDateTimeStr(format.parse(newsInformation.getCreateTime()), "yyyy-MM-dd");
		}
		if(!StringUtils.isEmpty(newsInformation.getHtmlUrl())){
			String content=newsInformation.getHtmlUrl();
			if(content.contains(CSBE.addlocalStr)){
				content=content.replaceAll(CSBE.addlocalStr,CSBE.imgHtmlPath);
			}
			int rand=CSBE.getRandomNum();
			//将html内容生成html页面，将链接存储到数据库中
			ToHtml.service("model", "/model/news/", rand,newsInformation.getInfoName(), time, newsInformation.getPreviewTotal(), content);
			newsInformation.setHtmlUrl(CSBE.htmlPath+"model/news/"+rand+".html");
	   }
		if(newsInformation.getTempleId() == -1){
			newsInformation.setTempleId(null);
		}
		NewsInformation information = newsInformationService.queryBigPreviewTotal(newsInformation.getType());
		if(information == null){
			newsInformation.setPreviewTotal(33);
		}else{
			int number = information.getPreviewTotal();
			newsInformation.setPreviewTotal(number+(int)(Math.random()*50+1));
		}
		boolean isAdd = newsInformationService.addInformation(newsInformation);
		return isAdd;
	}
	/**
	 * 删除
	 * deleteInformation
	 * @return
	 */
	@RequestMapping("/deleteInformation")
	@ResponseBody
	public boolean deleteInformation(Integer[] infoId){
		boolean isDelete = newsInformationService.deleteInformation(infoId);
		return isDelete;
	}
	/**
	 * 修改
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws ParseException 
	 */
	@RequestMapping("/updateInformation")
	@ResponseBody
	public boolean updateInformation(NewsInformation newsInformation) throws ServletException, IOException, ParseException{
		int rand;
		String time = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(StringUtils.isEmpty(newsInformation.getCreateTime())){
			time=DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd");
			newsInformation.setCreateTime(DateUtils.getDateTimeStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
		}else{
			time = DateUtils.getDateTimeStr(format.parse(newsInformation.getCreateTime()), "yyyy-MM-dd");
		}
		if(!StringUtils.isEmpty(newsInformation.getHtmlUrl())){
			String content=newsInformation.getHtmlUrl();
			if(content.contains(CSBE.localStr)){
				content=content.replaceAll(CSBE.localStr,CSBE.imgHtmlPath);
			}
			//查询原来htmlUrl
			if(StringUtils.isEmpty(newsInformation.getParam())){
				rand=CSBE.getRandomNum();
			}else{
				 String param=newsInformation.getParam();
				 rand=Integer.parseInt(param.substring(param.length()-11, param.length()-5));
			}
			
			//将html内容生成html页面，将链接存储到数据库中
			ToHtml.service("model", "/model/news/", rand,newsInformation.getInfoName(), time, newsInformation.getPreviewTotal(), content);
			newsInformation.setHtmlUrl(CSBE.htmlPath+"model/news/"+rand+".html");
	   }
		if(newsInformation.getTempleId() == -1){
			newsInformation.setTempleId(null);
		}
		if(newsInformation.getStatus()==null){
			newsInformation.setStatus(1);
		}
		NewsInformation information = newsInformationService.queryBigPreviewTotal(newsInformation.getType());
		if(information == null){
			newsInformation.setPreviewTotal(33);
		}else{
			int number = information.getPreviewTotal();
			newsInformation.setPreviewTotal(number+(int)(Math.random()*50+1));
		}
		boolean isUpdate = newsInformationService.updateInformation(newsInformation);
		return isUpdate;
		
	}
	/**
	 * 图片上传
	 */
	@RequestMapping(value = "upload/pictrue", method = RequestMethod.POST)
	@ResponseBody
	private Object uploadfile(@RequestParam("upfile") CommonsMultipartFile mFile, HttpServletRequest request,
			HttpServletResponse response, UserPassword userPassword) throws Exception {

		UploadResult uploadResult = UploadUtils.upload(request, mFile,constantUtils.BUDDHA_IMG);

		if (uploadResult == null || uploadResult.getStatus() != CSBE.OK) {
			return new Message(false, "不合法的文件类型");
		}

		return CSBE.encryption(new Result(CSBE.OK, "上传成功", uploadResult.getValue()));

	}

	
}
