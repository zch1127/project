package cn.csbe.web.cms.product.service;

import java.util.List;

import cn.csbe.web.cms.product.bean.ProductAttribute;

public interface ProductAttributeService {
	//添加参数
	public boolean addAttribute(ProductAttribute productAttribute);
	//根据商品id进行查询
	public List<ProductAttribute> selectByProductId(Integer id);
	//根据商品id进行参数删除
	public void deleteAtt(Integer id);
	
	
	
}
