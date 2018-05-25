package cn.csbe.web.cms.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.push.bean.PubUser;
import cn.csbe.web.cms.user.mapper.PubUserCouponMapper;
import cn.csbe.web.cms.user.service.PubUserCouponService;
@Service
public class PubUserCouponServiceImpl implements PubUserCouponService {
	@Autowired
	private PubUserCouponMapper pubUserCouponMapper;
	
	@Override
	public List<PubUser> queryUserId() {
		// TODO Auto-generated method stub
		return pubUserCouponMapper.queryUserId();
	}

}
