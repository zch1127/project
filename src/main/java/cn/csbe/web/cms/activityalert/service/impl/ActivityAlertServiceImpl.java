package cn.csbe.web.cms.activityalert.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.activityalert.bean.ActivityAlert;
import cn.csbe.web.cms.activityalert.mapper.ActivityAlertMapper;
import cn.csbe.web.cms.activityalert.service.ActivityAlertService;
@Service
public class ActivityAlertServiceImpl implements ActivityAlertService {
	@Autowired
	private ActivityAlertMapper activityAlertMapper;

	@Override
	public Map<String, Object> selectAllAlert(Integer page, Integer rows) {
		Map<String,Object> map= new HashMap<String,Object>();
		page = (page-1)*rows;
		List<ActivityAlert> list = activityAlertMapper.selectAllAlert(page,rows);
		int total = activityAlertMapper.selectCount();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}

	@Override
	public Map<String, Object> selectAllAlertByStatus(Integer page, Integer rows,
			String dateTimeStr) {
		Map<String,Object> map= new HashMap<String,Object>();
		page = (page-1)*rows;
		List<ActivityAlert> list = activityAlertMapper.selectAllAlertByStatus(page,rows,dateTimeStr);
		int total = activityAlertMapper.selectCountByStatus(dateTimeStr);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	@Override
	public Map<String, Object> selectAlertOngoing(Integer page, Integer rows,
			String dateTimeStr) {
		Map<String,Object> map= new HashMap<String,Object>();
		page = (page-1)*rows;
		List<ActivityAlert> list = activityAlertMapper.selectAlertOngoing(page,rows,dateTimeStr);
		int total = activityAlertMapper.selectCountOngoing(dateTimeStr);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}

	@Override
	public Map<String, Object> selectAllFinishedAlert(Integer page,
			Integer rows, String dateTimeStr) {
		Map<String,Object> map= new HashMap<String,Object>();
		page = (page-1)*rows;
		List<ActivityAlert> list = activityAlertMapper.selectAllFinishedAlert(page,rows,dateTimeStr);
		int total = activityAlertMapper.selectFinishedCount(dateTimeStr);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	@Override
	public boolean addAlert(ActivityAlert activityAlert) {
		// TODO Auto-generated method stub
		return activityAlertMapper.addAlert(activityAlert);
	}

	@Override
	public boolean updateAlert(ActivityAlert activityAlert) {
		// TODO Auto-generated method stub
		return activityAlertMapper.updateAlert(activityAlert);
	}

	@Override
	public boolean deleteManyAlertActivity(Integer[] alertId) {
		// TODO Auto-generated method stub
		return activityAlertMapper.deleteManyAlertActivity(alertId);
	}
}
