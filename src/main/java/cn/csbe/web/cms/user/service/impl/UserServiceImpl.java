package cn.csbe.web.cms.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csbe.web.cms.common.bean.QueryResult;
import cn.csbe.web.cms.common.service.impl.BaseService;
import cn.csbe.web.cms.push.bean.PubNotice;
import cn.csbe.web.cms.user.bean.PubUser;
import cn.csbe.web.cms.user.bean.WithDrawals;
import cn.csbe.web.cms.user.mapper.IUserMapper;
import cn.csbe.web.cms.user.service.IUserService;

@Service
public class UserServiceImpl extends BaseService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Autowired
	public void setMapper(IUserMapper mapper) {
		super.setMapper(mapper);
	}

	@Override
	public QueryResult findWithDrawals(WithDrawals t) throws Exception {
		QueryResult queryResult = new QueryResult();
		Long totalSize = this.mapper.findWithDrawalsCount(t);
		List list = this.mapper.findWithDrawals(t);
		queryResult.setTotalSize(totalSize);
		queryResult.setList(list);
		return queryResult;
	}

	@Override
	public WithDrawals findWithDrawalsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.findWithDrawalsById(id);
	}

	@Override
	public boolean updateWithDrawals(WithDrawals withDrawals) throws Exception {
		// TODO Auto-generated method stub
			return this.mapper.updateWithDrawals(withDrawals) > 0;
	}

	@Override
	public List<PubUser> findUserByPayLogAndTemple(PubNotice pubNotice) {
		//4.积庆寺—捐赠建塔--供认青石
        //6、供奉--祈福 （四种） 7、供奉--超度 8、供奉--供斋 9、供奉--供僧 
        //10、请灯祈福--吉祥如意（三种灯） 11、请灯祈福--光明智慧 12、请灯祈福--荷花转运 13、许愿（寺内挂许愿条需付费） 
        //14、敲钟 
		//3供奉付费通知 4点灯通知 5敲钟通知 6许愿通知 7积庆寺通知
		if(pubNotice.getInfoType()==7){
			return this.mapper.findUserByTempleLog(pubNotice);
		}else if(pubNotice.getInfoType()==4){
			pubNotice.getTempleId();
			return this.mapper.findUserByLightPayLog( pubNotice);
		}else if(pubNotice.getInfoType()==3){
			return this.mapper.findUserByPayLog( pubNotice);
		}else if(pubNotice.getInfoType()==5){
			return this.mapper.findUserByPayLog( pubNotice);
		}else if(pubNotice.getInfoType()==6){
			return this.mapper.findUserByPayLog( pubNotice);
		}
		return null;
		
	}
}
