package cn.csbe.web.cms.product.service;

import java.util.List;
import java.util.Map;

import cn.csbe.web.cms.product.bean.ProductCategory;

public interface ProductCategoryService {
	
	/**
	 * 商品一级分类
	 */
	public List<ProductCategory>  selectOneCategory();
	//查询所有
	public List<ProductCategory> selectAllCategory();
	//查询所有一级分类
	public List<ProductCategory> selectProductCategory();
	//根据一级id查二级类别
	public List<ProductCategory> selectCategoryByPid(Integer id);
	//添加类别
	public boolean addFirstCategory(String name,Integer id, String createDate);
	//删除分类
	public boolean deleteCategory(Integer id);
	//修改分类信息
	public boolean updateProductCategory(Integer id, String cname);
	
	public ProductCategory showCategoryById(Integer id);
	
	
	
	
	
	
}
