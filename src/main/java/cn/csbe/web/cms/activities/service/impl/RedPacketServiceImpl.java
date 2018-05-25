package cn.csbe.web.cms.activities.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.activities.bean.Coupon;
import cn.csbe.web.cms.activities.bean.RedPacket;
import cn.csbe.web.cms.activities.mapper.RedPacketMapper;
import cn.csbe.web.cms.activities.mapper.RedPacketReceiveMapper;
import cn.csbe.web.cms.activities.service.RedPacketService;

@Service
public class RedPacketServiceImpl implements RedPacketService{
	@Autowired
	private RedPacketMapper redPacketMapper;
	
	@Autowired
	private RedPacketReceiveMapper redPacketReceiveMapper;
	@Override
	public List<RedPacket> showAllRedPacket(Integer activityStatus) {
		List<RedPacket> list = redPacketMapper.showAllRedPacket(activityStatus);
		if(list!=null){
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setReceivePeoples(redPacketReceiveMapper.countReceivePeoples(list.get(i).getId()));
				list.get(i).setWithDrawPeoples(redPacketReceiveMapper.countWithDrawPeoples(list.get(i).getId()));
				System.out.println(list.get(i));
			}
		}
		return list;
	}
	@Override
	public boolean addRedPacket(RedPacket redPacket) {
		int i = redPacketMapper.addRedPacket(redPacket);
		if(i>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteRedPacket(int id) {
		int i = redPacketMapper.deleteRedPacket(id);
		if(i>0){
			return true;
		}
		return false;
	}
	
	@Override
	public RedPacket toUpdateRedPacket(int id) {
		RedPacket redPacket=redPacketMapper.selectById(id);
		return redPacket;
	}
	@Override
	public boolean updateRedPacket(RedPacket redPacket) {
		int i=redPacketMapper.updateRedPacket(redPacket);
		return i>0;
	}

	//定时改变优惠券活动状态
	public List<RedPacket> selectStartEndDate(){
		List<RedPacket> list= redPacketMapper.selectStartEndDate();
		return list;
	}
	
	@Override
	public boolean changeRedPacketActivityStatus(int id,int activityStatus) {
		int i =redPacketMapper.changeRedPacketActivityStatus(id,activityStatus);
		return i>0;
	}
}
