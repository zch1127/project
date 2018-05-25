package cn.csbe.web.cms.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.csbe.web.cms.order.bean.OrderComment;
import cn.csbe.web.cms.order.service.CommentService;
import cn.csbe.web.cms.product.bean.SinglePicture;
/**
 * @author sxzhang
 *	评论表
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	/*
	 * toComment 
	 */
	@RequestMapping("/toComment")
	public Object toComment(){
		return "/comment/showAllComment";
	}
	/*
	 * selectAllComment
	 * @Param page rows 
	 */
	@RequestMapping("/selectAllComment")
	@ResponseBody
	public Map selectAllComment(Integer page,Integer rows){
		Map<String,Object> map = new HashMap<String,Object>();
		map = commentService.selectAllComment(page,rows);
		return map;
	}
	/*
	 * deleteById
	 * @Param id
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public boolean deleteById(Integer id){
		boolean isDel = commentService.deleteById(id);
		return isDel;
	}
	/*
	 * deleteManyComment
	 * @Param ids
	 */
	@RequestMapping("/deleteManyComment")
	@ResponseBody
	public boolean deleteManyComment(Integer[] ids){
		boolean isDel = commentService.deleteManyComment(ids);
		return isDel;
	}
	/*
	 * selectCommentById
	 * @Param id
	 */
	@RequestMapping("/selectCommentById")
	@ResponseBody
	public ModelAndView selectCommentById(Integer id){
		ModelAndView model = new ModelAndView("comment/showDetailComment");
		OrderComment comment = commentService.selectCommentById(id);
		
		String str = comment.getCommentImgJson();
		List list1= new ArrayList();//存储查询出来的图片数据
		if(str !=null){
			JSONArray array=JSONArray.fromObject(str);
			List<SinglePicture> list=JSONArray.toList(array, SinglePicture.class);
			if(list!=null){
				for(SinglePicture s:list){
					list1.add(s);
					//System.out.println(s);
				}
			}
		}
		model.addObject("list1", list1);
		model.addObject("comment", comment);
		return model;
	}
	/*
	 * addHF
	 * @Param reply id
	 */
	@RequestMapping("/addHF")
	@ResponseBody
	public boolean addHF(String reply,Integer id){
		boolean isAdd = commentService.updateComment(reply,id);
		return isAdd;
	}
	
	
}
