package cn.csbe.web.cms.activityalert.service;

import java.util.Map;

import cn.csbe.web.cms.activityalert.bean.ActivityAlert;

public interface ActivityAlertService {

	boolean addAlert(ActivityAlert activityAlert);

	Map<String, Object> selectAllAlert(Integer page, Integer rows);

	Map<String, Object> selectAllAlertByStatus(Integer page, Integer rows,String dateTimeStr);

	Map<String, Object> selectAlertOngoing(Integer page, Integer rows,String dateTimeStr);

	Map<String, Object> selectAllFinishedAlert(Integer page, Integer rows,String dateTimeStr);

	boolean updateAlert(ActivityAlert activityAlert);

	boolean deleteManyAlertActivity(Integer[] alertId);

}
