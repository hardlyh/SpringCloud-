package com.mining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mining.domain.MiningOutlay;
import com.mining.service.MiningOutlayService;
import com.mining.task.PeopleTotalTask;

/**
 * <p>
 * 挖矿收入表 前端控制器
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
@RestController
@RequestMapping("/miningIncome")
public class MiningIncomeController {

	@Autowired
	private MiningOutlayService outlayService;
	
	@Autowired
	private PeopleTotalTask task;

	@RequestMapping("/test")
	public Object test() {
		task.getPeopleCountTask();
		return "opk";
	}
	/**
	 * 获取到指定时间段内的总额信息
	 * 
	 * @return
	 */
	@RequestMapping("/getInComeDateCountInfo")
	public Object getInComeDateCountInfo(String startTime, String endTime) {
		List<MiningOutlay> countByDate = outlayService.countInComeByDate(startTime, endTime);
		JSONObject root = new JSONObject();
		root.put("countInfo", countByDate);

		// 找到列表
		List<MiningOutlay> list = outlayService.countInComeByDateGroup(startTime, endTime);
		root.put("groupList", list);
		return root;
	}

	/**
	 * 获取到指定时间段内的总额信息
	 * 
	 * @return
	 */
	@RequestMapping("/getInComeDateDetailInfo")
	public Object getInComeDateDetailInfo(String dateTime) {
		List<MiningOutlay> listByDate = outlayService.listInComeByDate(dateTime);
		return listByDate;
	}

}
