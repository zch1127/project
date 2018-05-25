package cn.csbe.web.cms.product.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.csbe.web.cms.product.service.ProductCategoryService;
/*
 * 商品分类信息
 * author sxzhang
 */
@Controller
@RequestMapping("/category")
public class ProductCategoryController {
	@Autowired
	private ProductCategoryService productCategoryService;
	
	/*
	 * addFirstCategory
	 * 添加一级类别
	 */
	@RequestMapping("/addFirstCategory")
	@ResponseBody
	public boolean addFirstCategory(String name,String id){
		//System.out.println(id+""+name);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//productCategory.setId(id);
		boolean isAdd = false;
		if(id.equals("一级分类")){
			int id1 =0;
			String createDate = sdf.format(new Date());
			isAdd=productCategoryService.addFirstCategory(name,id1,createDate);
			return isAdd;
		}else{
			int id1=Integer.valueOf(id);
			String createDate = sdf.format(new Date());
			isAdd=productCategoryService.addFirstCategory(name,id1,createDate);
			return isAdd;
		}
	}
	/*
	 * deleteCategory
	 * 删除分类
	 */
	@RequestMapping("/deleteCategory")
	@ResponseBody
	public boolean deleteCategory(Integer id){
		boolean isDelete = productCategoryService.deleteCategory(id);
		return isDelete;
	}
	/*
	 * updateProductCategory
	 * 修改
	 */
	@RequestMapping("/updateProductCategory")
	@ResponseBody
	public boolean updateProductCategory(Integer id,String cname){
		boolean isUpdate = productCategoryService.updateProductCategory(id,cname);
		return isUpdate;
	}
	
}
