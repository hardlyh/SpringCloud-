package com.mining.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
	
	
	
	
	/**
	 *  获取到指定时间段内的总额信息
	 * @return
	 */
	public Object getTotalInfoByDate(String startTime,String endTime) {
		
		
		return null;
	}

}

