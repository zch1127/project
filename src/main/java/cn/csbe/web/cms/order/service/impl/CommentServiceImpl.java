package cn.csbe.web.cms.order.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.order.bean.OrderComment;
import cn.csbe.web.cms.order.mapper.CommentMapper;
import cn.csbe.web.cms.order.service.CommentService;
import cn.csbe.web.cms.product.bean.Product;
import cn.csbe.web.cms.product.mapper.ProductMapper;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private ProductMapper productMapper;
	@Override
	public Map<String, Object> selectAllComment(Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OrderComment> list = new ArrayList<OrderComment>();
		Product product = new Product();
		page = (page-1)*rows;
		list = commentMapper.selectAllComment(page,rows);
		//直接把用户表和评论表连表查询
		for (OrderComment orderComment : list) {
			// 获取商品id 根据id去 查询商品的标题图片和商品名字
			int productId = orderComment.getProductId();
			product = productMapper.selectById(productId);
			orderComment.setName(product.getName());
			orderComment.setTitleImg(product.getTitleImg());
			//System.out.println(orderComment.getTitleImg());
		}
		int total = commentMapper.selectCount();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return commentMapper.deleteById(id);
	}
	@Override
	public boolean deleteManyComment(Integer[] ids) {
		// TODO Auto-generated method stub
		return commentMapper.deleteManyComment(ids);
	}
	@Override
	public OrderComment selectCommentById(Integer id) {
		OrderComment comment = commentMapper.selectCommentById(id);
		int productId = comment.getProductId();
		Product product = productMapper.selectById(productId);
		comment.setName(product.getName());
		comment.setTitleImg(product.getTitleImg());
		return comment;
	}
	@Override
	public boolean updateComment(String reply, Integer id) {
		
		return commentMapper.updateComment(reply,id);
	}
	@Override
	public boolean addComment(OrderComment com) {
		// TODO Auto-generated method stub
		return commentMapper.addComment(com);
	}
}
