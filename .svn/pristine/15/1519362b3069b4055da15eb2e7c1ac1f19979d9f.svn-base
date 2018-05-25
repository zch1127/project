package cn.csbe.web.cms.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.product.bean.Product;
import cn.csbe.web.cms.product.bean.ProductCategory;
import cn.csbe.web.cms.product.mapper.ProductMapper;
import cn.csbe.web.cms.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	//自动装配dao接口
	@Autowired
	private ProductMapper productMapper;
	
	
	//对返回值进行判断然后进行返回
	@Override
	public boolean addProduct(Product product) {
		
		return productMapper.insert(product)>0;
	}
	//模糊查询
	@Override
	public Map<String, Object> searchProduct(String name,Integer page, Integer rows) {
		Map<String,Object> map = new HashMap<String,Object>();
		page = (page-1)*rows;
		List<Product> list = productMapper.searchProduct(name,page,rows);
		int total = productMapper.selectCountByName(name);
		map.put("rows", list);
		map.put("total",total);
		return map;
	}

	//查询上架数据
	@Override
	public Map<String, Object> selectAllProduct(Integer page, Integer rows) {
		Map<String,Object> map = new HashMap<String,Object>();
		page = (page-1)*rows;
		List<Product> list = productMapper.selectAllProduct(page,rows);
		int total = productMapper.selectCount();
		map.put("rows", list);
		map.put("total",total);
		return map;
	}
	//仓库中
	@Override
	public Map<String, Object> selectProductInCk(Integer page, Integer rows) {
		Map<String,Object> map = new HashMap<String,Object>();
		page = (page-1)*rows;
		List<Product> list = productMapper.selectProductInCk(page,rows);
		int total = productMapper.selectCountInCk();
		map.put("rows", list);
		map.put("total",total);
		return map;
	}
	//售光
	@Override
	public Map<String, Object> selectProductByquantityNumber(Integer page,
			Integer rows) {
		Map<String,Object> map = new HashMap<String,Object>();
		page = (page-1)*rows;
		List<Product> list = productMapper.selectProductByquantityNumber(page,rows);
		int total = productMapper.selectCountByQN();
		map.put("rows", list);
		map.put("total",total);
		return map;
	}
	//推荐商品
	@Override
	public Map<String, Object> selectProductByRecommend(Integer page,
			Integer rows) {
		Map<String,Object> map = new HashMap<String,Object>();
		page = (page-1)*rows;
		List<Product> list = productMapper.selectProductByRecommend(page,rows);
		int total = productMapper.selectCountBR();
		map.put("rows", list);
		map.put("total",total);
		return map;
	}
	//批量删除
	@Override
	public boolean delete(int[] id) {
		int count = productMapper.delete(id);
		if(count >0){
			return true;
		}
		return false;
	}
	//批量下架
	@Override
	public boolean updatePro(int[] id) {
		int count = productMapper.updatePro(id);
		if(count >0){
			return true;
		}
		return false;
	}
	//上架
	@Override
	public boolean shelvesProduct(int[] id) {
		int count = productMapper.shelvesProduct(id);
		if(count >0){
			return true;
		}
		return false;
	}
	//批量取消推荐商品
	@Override
	public boolean updateProByRecommend(int[] id) {
		int count = productMapper.updateProByRecommend(id);
		if(count >0){
			return true;
		}
		return false;
	}
	@Override
	public int selectNewId() {
		
		return productMapper.selectNewId();
	}
	@Override
	public Product selectById(Integer id) {
		
		return productMapper.selectById(id);
	}
	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.updateProduct(product);
	}
	
	
	
}