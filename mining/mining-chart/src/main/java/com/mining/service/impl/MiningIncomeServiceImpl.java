package com.mining.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.domain.MiningIncome;
import com.mining.domain.MiningOutlay;
import com.mining.mapper.MiningIncomeMapper;
import com.mining.service.MiningIncomeService;
import com.mining.utils.MoneyUtil;

/**
 * <p>
 * 挖矿收入表 服务实现类
 * </p>
 *
 * @author liyh
 * @since 2020-08-06
 */
@Service
public class MiningIncomeServiceImpl extends ServiceImpl<MiningIncomeMapper, MiningIncome>
		implements MiningIncomeService {

	@Override
	public void addTotalInfo(MiningOutlay pay) throws IllegalAccessException {
		String lineDate = pay.getLineNumber();

		QueryWrapper<MiningIncome> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("income_day", lineDate);

		MiningIncome one = getOne(queryWrapper);

		// 没有则新建
		if (one == null) {
			Integer price = pay.getPrice();
			Integer profit = pay.getProfit();

			one = new MiningIncome();
			one.setCount(1);
			one.setIncomeDay(lineDate);
			one.setPrincipal(price);
			one.setProfit(profit);
			one.setTotalAmt(pay.getTotalAmt());
			double rete = MoneyUtil.div(profit, price, 2);
			double reteBai = MoneyUtil.mul(rete, 100);
			one.setProfitMargin(new Double(reteBai).intValue());
			save(one);
		}
		// 有的话则更新
		else {
			Integer price = pay.getPrice() + one.getPrincipal();
			Integer profit = pay.getProfit() + one.getProfit();
			Integer totalAmt = pay.getTotalAmt() + one.getTotalAmt();
			one.setCount(one.getCount() + 1);
			one.setPrincipal(price);
			one.setProfit(profit);
			one.setTotalAmt(totalAmt);

			double rete = MoneyUtil.div(profit, price, 2);
			double reteBai = MoneyUtil.mul(rete, 100);
			one.setProfitMargin(new Double(reteBai).intValue());
			updateById(one);
		}
	}

}
