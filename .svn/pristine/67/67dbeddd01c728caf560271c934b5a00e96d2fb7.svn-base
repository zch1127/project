package cn.csbe.web.cms.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.csbe.web.cms.product.bean.ProductType;
import cn.csbe.web.cms.product.mapper.ProductTypeMapper;
import cn.csbe.web.cms.product.service.ProductTypeService;
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	@Autowired 
	private ProductTypeMapper productTypeMapper;

	@Override
	public List<ProductType> selectAllType() {
		List<ProductType> list = productTypeMapper.selectAllType();
		return list;
	}
	


}
