package cn.csbe.web.cms.activities.service;

import java.util.Map;

import cn.csbe.web.cms.activities.bean.CouponReceive;

public interface CouponReceiveService {

	Map<String, Object> selectAllCouponReceive(Integer page, Integer rows,Integer activityStatus,Integer couponId);

	boolean changeCouponReceiveUseStatus(Integer couponId);

	boolean add(CouponReceive couponReceive);


}
