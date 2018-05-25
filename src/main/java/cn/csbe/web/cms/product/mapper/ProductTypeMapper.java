package cn.csbe.web.cms.product.mapper;

import java.util.List;
import cn.csbe.web.cms.product.bean.ProductType;


public interface ProductTypeMapper {
	//查询所有的类型
	public List<ProductType> selectAllType();

}
