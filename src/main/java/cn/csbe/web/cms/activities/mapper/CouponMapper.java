package cn.csbe.web.cms.activities.mapper;

import java.util.List;

import cn.csbe.web.cms.activities.bean.Coupon;
import cn.csbe.web.cms.activities.bean.CouponReceive;
import cn.csbe.web.cms.activities.bean.RedPacket;

/**
 * @author: wffu
 * @date:2017-12-11 上午10:45:04
 * @version :
 * 
 */
public interface CouponMapper {
	//根据状态查询优惠券活动信息
	List<Coupon> showAllCouponByStatus(Integer activityStatus);
	
	//添加优惠券
	int addCoupon(Coupon coupon);
	
	//查询已使用的优惠券
	List<CouponReceive> selectUsedCouponReceive();

	//根据id删除优惠券
	int deleteCoupon(int id);
	
	//根据id查找优惠券
	Coupon selectById(int id);
	
	//更新优惠券
	int updateCoupon(Coupon coupon);
	
	//定时改变优惠券活动状态
	List<Coupon> selectStartEndDate();
	
	int changeCouponActivityStatus(int id,int activityStatus);

	List<Coupon> showAllCoupon();

	List<Coupon> queryNewCoupon();

}
