package com.mining.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mining.domain.MiningOutlay;
import com.mining.service.MiningIncomeService;
import com.mining.service.MiningOutlayService;
import com.mining.utils.LogUtil;
import com.mining.utils.MoneyUtil;
import com.mining.utils.TimeUtil;

/**
 * <p>
 * 挖矿支出 前端控制器
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
@RestController
@RequestMapping("/miningOutlay")
public class MiningOutlayController {

	@Autowired
	private MiningOutlayService outlayService;

	@Autowired
	private MiningIncomeService incomeService;

	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	{
		map.put(1, 5);
		map.put(2, 8);
		map.put(3, 10);
		map.put(5, 13);
		map.put(7, 18);
	}

	/**
	 * 时间段内的总额统计测试
	 * 
	 * @return
	 */
	@RequestMapping("/getDateCountInfo")
	public Object getDateCountInfo(String startTime, String endTime) {
		List<MiningOutlay> countByDate = outlayService.countByDate(startTime, endTime);
		JSONObject root = new JSONObject();
		root.put("countInfo", countByDate);

		// 找到列表
		List<MiningOutlay> list = outlayService.countByDateGroup(startTime, endTime);
		root.put("groupList", list);
		return root;
	}

	/**
	 * 时间段内的总额统计测试
	 * 
	 * @return
	 */
	@RequestMapping("/getDateDetailInfo")
	public Object getDateDetailInfo(String dateTime) {
		List<MiningOutlay> listByDate = outlayService.listByDate(dateTime);
		return listByDate;
	}

	
	
	/**
	 * 保存支出记录
	 * 
	 * @throws IllegalAccessException
	 */
	@RequestMapping("/saveOutLayInfo")
	public Object saveOutLayInfo(String date, Integer dayNumber, Integer price) throws IllegalAccessException {
		
		Double price2 = MoneyUtil.mul(price, 100);
		price = price2.intValue();
		
		int rete = map.get(dayNumber);
		MiningOutlay dto = new MiningOutlay();
		dto.setDayNumber(dayNumber);
		dto.setPrice(price);
		dto.setOutlayDay(date);
		dto.setRete(rete);

		// 计算利润
		String div = MoneyUtil.div(String.valueOf(rete), "100", 2);
		String profit = MoneyUtil.mul(String.valueOf(price), div);

		// 计算总额 本+利润
		Integer total = Integer.parseInt(profit) + price;

		dto.setProfit(Integer.parseInt(profit));
		dto.setTotalAmt(total);
		dto.setLineNumber(TimeUtil.getSpecifiedDay(date, dayNumber));
		boolean save = outlayService.save(dto);

		// 同时触发总额计算,更新结算表中结束天数的数据
//		incomeService.addTotalInfo(dto);
		LogUtil.info("保存完成");
		return 0;
	}
	
	
	
}
