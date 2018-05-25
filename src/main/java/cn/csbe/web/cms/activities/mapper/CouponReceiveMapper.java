package cn.csbe.web.cms.activities.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.csbe.web.cms.activities.bean.CouponReceive;
import cn.csbe.web.cms.activities.bean.RedPacketReceive;

/**
 * @author: wffu
 * @date:2017-12-11 上午10:45:57
 * @version :
 * 
 */
public interface CouponReceiveMapper {
	//查询所有优惠券
	List<RedPacketReceive> selectAllCouponReceive(@Param("start")int start, @Param("rows")int rows,@Param("activityStatus")int activityStatus,@Param("couponId")Integer couponId);
	//查询总条数
	int countAllCouponReceive(@Param("activityStatus")int activityStatus,@Param("couponId")int couponId);
	//活动过期时修改优惠券使用状态
	int changeCouponReceiveUseStatus(Integer couponId);
	//查询优惠券领取数量
	Integer countAllCouponReceiveById(Integer couponId);
	//给用户添加优惠券信息
	boolean add(CouponReceive couponReceive);
}
