package cn.csbe.web.cms.activities.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.activities.bean.CouponReceive;
import cn.csbe.web.cms.activities.bean.RedPacketReceive;
import cn.csbe.web.cms.activities.mapper.CouponReceiveMapper;
import cn.csbe.web.cms.activities.service.CouponReceiveService;
@Service
public class CouponReceiveServiceImpl implements CouponReceiveService {

	@Autowired
	private CouponReceiveMapper couponReceiveMapper;
	@Override
	public Map<String,Object> selectAllCouponReceive(Integer page, Integer rows,Integer activityStatus,Integer couponId){
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		int start=(page-1)*rows;
		List<RedPacketReceive> list = couponReceiveMapper.selectAllCouponReceive(start,rows,activityStatus,couponId);
		int total = couponReceiveMapper.countAllCouponReceive(activityStatus,couponId);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	@Override
	public boolean changeCouponReceiveUseStatus(Integer couponId) {
		int i=couponReceiveMapper.changeCouponReceiveUseStatus(couponId);
		return i>0;
	}
	@Override
	public boolean add(CouponReceive couponReceive) {
		// TODO Auto-generated method stub
		return couponReceiveMapper.add(couponReceive);
	}

}
