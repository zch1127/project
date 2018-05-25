package cn.csbe.web.cms.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.product.bean.ProductCategory;
import cn.csbe.web.cms.product.mapper.CategoryMapper;
import cn.csbe.web.cms.product.service.ProductCategoryService;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	private CategoryMapper categoryMapper;
	
	/**
	 * 商品一级分类
	 */
	public List<ProductCategory>  selectOneCategory() {
		List<ProductCategory> list = categoryMapper.selectProductCategory();
		return list;
	}
	
	@Override
	public List<ProductCategory> selectAllCategory() {
		List<ProductCategory> list = categoryMapper.selectAllCategory();
		return list;
	}
	//查询一级分类信息 以及一级下总的商品信息
	@Override
	public	List<ProductCategory> selectProductCategory() {
		
		List<ProductCategory> list = categoryMapper.selectProductCategory();
		//得到查询出来的一级分类商品的id 查询一级分类id下的商品的总数量
		for (ProductCategory productCategory : list) {
			int number = categoryMapper.selectNumberByFirstId(productCategory.getId());
			productCategory.setcNumber(number);
		}
		return list;
	}
	//查二级分类
	@Override
	public List<ProductCategory> selectCategoryByPid(Integer id) {
		List<ProductCategory> list = categoryMapper.selectCategoryByPid(id);
		//得到查询出来的一级分类商品的id 查询一级分类id下的商品的总数量
		for (ProductCategory productCategory : list) {
			int number = categoryMapper.selectNumberByPid(productCategory.getId());
			productCategory.setcNumber(number);
		}
		return list;
	}
	//添加类别
	@Override
	public boolean addFirstCategory(String name,Integer id,String createDate) {
		
		return categoryMapper.addFirstCategory(name,id,createDate);
	}
	//删除分类
	@Override
	public boolean deleteCategory(Integer id) {
		//查询该类别是一级还是二级
		List<ProductCategory> list = categoryMapper.selectCategoryByPid(id);
		if(list.size()>0){//id为一级，删除一级分类和对应的二级分类
			categoryMapper.deleteCategory(id);
			return categoryMapper.deleteCategoryById(id);
		}else{//ID为二级 直接删除二级
			return categoryMapper.deleteCategoryById(id);
		}
	}
	@Override
	public boolean updateProductCategory(Integer id, String cname) {
		
		return categoryMapper.updateProductCategory(id,cname);
	}
	@Override
	public ProductCategory showCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return categoryMapper.showCategoryById(id);
	}

	
}
