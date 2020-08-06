package com.mining.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mining.domain.MiningAccount;
import com.mining.service.MiningAccountService;

/**
 * <p>
 * 挖矿用户表 前端控制器
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
@RestController
@RequestMapping("/miningAccount")
public class MiningAccountController {
	
	@Autowired
	private MiningAccountService accountService;
	
	
	/**
	 * 根据账号获取账号信息
	 */
	@RequestMapping("/getInfoByAccount")
	public Object getInfoByAccount() {
		List<MiningAccount> list = accountService.list();
		return list;
	}

}

