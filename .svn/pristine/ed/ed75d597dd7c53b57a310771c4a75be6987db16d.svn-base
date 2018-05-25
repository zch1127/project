package cn.csbe.web.cms.product.service;

import java.util.List;
import java.util.Map;

import cn.csbe.web.cms.product.bean.Product;
import cn.csbe.web.cms.product.bean.ProductCategory;


public interface ProductService {
	//添加商品信息
	public boolean addProduct(Product product);
	//上架
	public Map<String, Object> selectAllProduct(Integer page, Integer rows);
	//搜索
	public Map<String, Object> searchProduct(String name,Integer page, Integer rows);
	//仓库中
	public Map<String, Object> selectProductInCk(Integer page, Integer rows);
	//库存为0
	public Map<String, Object> selectProductByquantityNumber(Integer page,
			Integer rows);
	//推荐
	public Map<String, Object> selectProductByRecommend(Integer page,
			Integer rows);
	//批量删除
	public boolean delete(int[] id);
	//批量下架商品
	public boolean updatePro(int[] id);
	//批量上架商品
	public boolean shelvesProduct(int[] id);
	//批量取消推荐商品
	public boolean updateProByRecommend(int[] id);
	//查询最新的id
	public int selectNewId();
	//根据id去查询数据
	public Product selectById(Integer id);
	//修改商品
	public boolean updateProduct(Product product);

	
	
	
}
