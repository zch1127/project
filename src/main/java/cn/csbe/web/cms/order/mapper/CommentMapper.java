package cn.csbe.web.cms.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.order.bean.OrderComment;

public interface CommentMapper {
	//查询所有
	List<OrderComment> selectAllComment(@Param("page")Integer page,@Param("rows")Integer rows);
	//分页数量
	int selectCount();
	//单个删除
	boolean deleteById(Integer id);
	//批量删除
	boolean deleteManyComment(Integer[] ids);
	//查询ById
	OrderComment selectCommentById(Integer id);
	//添加评论回复
	boolean updateComment(@Param("reply")String reply,@Param("id")Integer id);
	//自动好评  添加评论
	boolean addComment(OrderComment com);

}
