package cn.csbe.web.cms.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.product.bean.ProductAttribute;
import cn.csbe.web.cms.product.mapper.AttributeMapper;
import cn.csbe.web.cms.product.service.ProductAttributeService;
@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {
	@Autowired
	private AttributeMapper attributeMapper;
	@Override
	public boolean addAttribute(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		return attributeMapper.addAttribute(productAttribute);
	}
	@Override
	public List<ProductAttribute> selectByProductId(Integer id) {
		
		return attributeMapper.selectByProductId(id);
	}
	
	@Override
	public void deleteAtt(Integer id) {
		attributeMapper.deleteAtt(id);
		
	}

}
