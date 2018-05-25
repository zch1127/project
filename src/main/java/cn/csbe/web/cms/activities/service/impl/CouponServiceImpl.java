package cn.csbe.web.cms.activities.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.activities.bean.Coupon;
import cn.csbe.web.cms.activities.mapper.CouponMapper;
import cn.csbe.web.cms.activities.mapper.CouponReceiveMapper;
import cn.csbe.web.cms.activities.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService{
	@Autowired
	private CouponMapper couponMapper;
	@Autowired
	private CouponReceiveMapper couponReceiveMapper;
	@Override
	public List<Coupon> showAllCoupon(Integer activityStatus) {
		List<Coupon> list = couponMapper.showAllCouponByStatus(activityStatus);
		if(list!=null){
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setReceiveNum(couponReceiveMapper.countAllCouponReceiveById(list.get(i).getId()));
			}
		}
		return list;
	}
	@Override
	public boolean deleteCoupon(int id) {

		int i = couponMapper.deleteCoupon(id);
		
		return i>0;
	}
	@Override
	public boolean addCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		int i=couponMapper.addCoupon(coupon);
		return i>0;
	}
	//跳转到更新页面
	@Override
	public Coupon toUpdateCoupon(int id) {
		Coupon coupon = couponMapper.selectById(id);
		
		return coupon;
	}
	//更新
	@Override
	public boolean updateCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		int i = couponMapper.updateCoupon(coupon);
		return i>0;
	}

	
	//定时改变优惠券活动状态
	public List<Coupon> selectStartEndDate(){
		List<Coupon> list= couponMapper.selectStartEndDate();
		return list;
	}
	@Override
	public boolean changeCouponActivityStatus(int id,int activityStatus) {
		int i = couponMapper.changeCouponActivityStatus(id,activityStatus);
		return i>0;
	}
	@Override
	public List<Coupon> showAllCoupon() {
		List<Coupon> list = couponMapper.showAllCoupon();
		if(list!=null){
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setReceiveNum(couponReceiveMapper.countAllCouponReceiveById(list.get(i).getId()));
			}
		}
		return list;
	}
	@Override
	public List<Coupon> queryNewCoupon() {
		// TODO Auto-generated method stub
		return couponMapper.queryNewCoupon();
	}
}
