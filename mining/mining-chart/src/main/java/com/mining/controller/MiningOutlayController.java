package com.mining.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	 * 保存支出记录
	 * 
	 * @throws IllegalAccessException
	 */
	@RequestMapping("/saveOutLayInfo")
	public void saveOutLayInfo(String date, Integer dayNumber, Integer price) throws IllegalAccessException {
		int rete = map.get(dayNumber);
		MiningOutlay dto = new MiningOutlay();
		dto.setDayNumber(dayNumber);
		dto.setPrice(price);
		dto.setOutlayDay(date);
		dto.setRete(rete);

		String div = MoneyUtil.div(String.valueOf(rete), "100", 2);
		String profit = MoneyUtil.mul(String.valueOf(price), div);

		Integer total = Integer.parseInt(profit) + price;

		dto.setProfit(Integer.parseInt(profit));
		dto.setTotalAmt(total);
		dto.setLineNumber(TimeUtil.getSpecifiedDay(date, dayNumber));
		boolean save = outlayService.save(dto);
		
		// 同时触发总额计算
		incomeService.addTotalInfo(dto);
		LogUtil.info("保存完成");
	}
}
