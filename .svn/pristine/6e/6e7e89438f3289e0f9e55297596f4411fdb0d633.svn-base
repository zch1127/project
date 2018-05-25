package cn.csbe.web.cms.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.product.bean.Product;


public interface ProductMapper {
	//添加
	public Integer insert(Product product);
	
	//根据名字条件查询
	public List<Product> searchProduct(@Param("name")String name,@Param("page")Integer page,@Param("rows")Integer rows);
	//根据名字
	public int selectCountByName(@Param("name")String name);
	//上架
	public List<Product> selectAllProduct(@Param("page")Integer page,@Param("rows")Integer rows);
	//上架的数量
	public int selectCount();
	
	//推荐数量
	public List<Product> selectProductByRecommend(@Param("page")Integer page,@Param("rows")Integer rows);
	public int selectCountBR();
	//库存为o的
	public List<Product> selectProductByquantityNumber(@Param("page")Integer page,@Param("rows")Integer rows);
	public int selectCountByQN();
	//仓库中
	public List<Product> selectProductInCk(@Param("page")Integer page,@Param("rows")Integer rows);
	public int selectCountInCk();
	//删除
	public int delete(int[] id);
	//下架
	public int updatePro(int[] id);
	//上架
	public int shelvesProduct(int[] id);
	//批量取消推荐
	public int updateProByRecommend(int[] id);
	//查询最新的id
	public int selectNewId();
	//根据ID查询
	public Product selectById(Integer id);
	//修改
	public boolean updateProduct(Product product);
	

	
	
	
	

			

	
	
}
