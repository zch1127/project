package cn.csbe.web.cms.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.product.bean.ProductCategory;

public interface CategoryMapper {
	//查询所有二级分类信息
	public List<ProductCategory> selectAllCategory();
	
	//查询一级分类信息
	public List<ProductCategory> selectProductCategory();
	//查询一级分类下商品的总数量
	public int selectNumberByFirstId(Integer id);
	//查询一级分类下二级分类信息
	public List<ProductCategory> selectCategoryByPid(Integer id);
	//查询二级分类下的商品的数量
	public int selectNumberByPid(Integer id);
	//添加类别
	public boolean addFirstCategory(@Param("name")String name,@Param("id")Integer id, @Param("createDate")String createDate);
	//删除该id下的二级类别
	public void deleteCategory(Integer id);
	//删除对应id的类别
	public boolean deleteCategoryById(Integer id);
	//修改信息
	public boolean updateProductCategory(@Param("id")Integer id,@Param("name")String cname);

	public ProductCategory showCategoryById(Integer id);
	
}
