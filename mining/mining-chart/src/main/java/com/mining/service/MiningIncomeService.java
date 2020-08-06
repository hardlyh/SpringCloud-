package com.mining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.domain.MiningIncome;
import com.mining.domain.MiningOutlay;

/**
 * <p>
 * 挖矿收入表 服务类
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
public interface MiningIncomeService extends IService<MiningIncome> {
	
	public void addTotalInfo(MiningOutlay pay) throws IllegalAccessException ;
}
