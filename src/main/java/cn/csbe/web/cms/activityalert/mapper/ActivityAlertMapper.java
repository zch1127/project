package cn.csbe.web.cms.activityalert.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.activityalert.bean.ActivityAlert;

public interface ActivityAlertMapper {
	//全部数据
	List<ActivityAlert> selectAllAlert(@Param("page")Integer page, @Param("rows")Integer rows);
	int selectCount();
	//未开始
	List<ActivityAlert> selectAllAlertByStatus(@Param("page")Integer page, @Param("rows")Integer rows,@Param("dateTimeStr")String dateTimeStr);
	int selectCountByStatus(String dateTimeStr);
	//进行中
	List<ActivityAlert> selectAlertOngoing(@Param("page")Integer page, @Param("rows")Integer rows,@Param("dateTimeStr")String dateTimeStr);
	int selectCountOngoing(String dateTimeStr);
	//已结束
	List<ActivityAlert> selectAllFinishedAlert(@Param("page")Integer page, @Param("rows")Integer rows,@Param("dateTimeStr")String dateTimeStr);
	int selectFinishedCount(String dateTimeStr);
	//添加
	boolean addAlert(ActivityAlert activityAlert);
	//修改
	boolean updateAlert(ActivityAlert activityAlert);
	//删除
	boolean deleteManyAlertActivity(Integer[] alertId);
	
}
