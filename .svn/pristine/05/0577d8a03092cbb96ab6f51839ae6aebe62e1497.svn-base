package cn.csbe.web.cms.order.service;

import java.util.Map;

import cn.csbe.web.cms.order.bean.OrderComment;

public interface CommentService {
	//查询所有的评价
	public Map<String, Object> selectAllComment(Integer page, Integer rows);
	//根据id进行单个删除
	public boolean deleteById(Integer id);
	//批量删除
	public boolean deleteManyComment(Integer[] ids);
	//根据ID进行查询
	public OrderComment selectCommentById(Integer id);
	//添加回复
	public boolean updateComment(String reply, Integer id);
	//自动好评  添加评论信息
	public boolean addComment(OrderComment com);

}
