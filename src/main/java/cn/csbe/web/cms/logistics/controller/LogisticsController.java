package cn.csbe.web.cms.logistics.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.csbe.web.cms.logistics.bean.Logistics;
import cn.csbe.web.cms.logistics.service.LogisticsService;

/*
 * 物流 logistics
 * @author sxzhang
 */
@Controller
@RequestMapping("/logistics")
public class LogisticsController {
	@Autowired
	private LogisticsService logisticsService;

	/*
	 * 查询所有的快递公司信息
	 */
	@RequestMapping("/selectAllLogistics")
	@ResponseBody
	public List<Logistics> selectAllLogistics(){
		List<Logistics> list = new ArrayList<Logistics>();
		list = logisticsService.selectAllLogistics();
		return list;
	}
	/*
	 * 根据id查询
	 * selectByid
	 * @param id
	 */
	@RequestMapping("/selectByid")
	@ResponseBody
	public Map<String,Logistics> selectByid(Integer id){
		Map<String,Logistics> map = new HashMap<String,Logistics>();
		map = logisticsService.selectByid(id);
		return map;
	}
	
	
	
	
	
}
