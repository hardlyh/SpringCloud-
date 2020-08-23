package com.mining.service.impl;

import com.mining.domain.MiningIncome;
import com.mining.domain.MiningPeopleCount;
import com.mining.mapper.MiningPeopleCountMapper;
import com.mining.service.MiningPeopleCountService;
import com.mining.utils.MoneyUtil;
import com.mining.utils.TimeUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人数记录表 服务实现类
 * </p>
 *
 * @author liyh
 * @since 2020-08-23
 */
@Service
public class MiningPeopleCountServiceImpl extends ServiceImpl<MiningPeopleCountMapper, MiningPeopleCount>
		implements MiningPeopleCountService {

	@Override
	public JSONObject getStatisticsByDate(String date) throws IllegalAccessException {
		// 获取到前一天日期
		String beforeDay = TimeUtil.getBeforeDay(date, 1);

		QueryWrapper<MiningPeopleCount> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("count_day", beforeDay);
		MiningPeopleCount beforeObj = getOne(queryWrapper);

		QueryWrapper<MiningPeopleCount> queryWrapper2 = new QueryWrapper<>();
		queryWrapper2.eq("count_day", date);
		MiningPeopleCount todayObj = getOne(queryWrapper2);

		String todayStatic = "0";
		String sub = "0";
		String total = "0";
		JSONObject root = new JSONObject();
		if (beforeObj != null && todayObj != null) {
			String beforTotal = beforeObj.getTotalPeople();
			String todayTotal = todayObj.getTotalPeople();
			total = todayTotal;
			
			// 先算增长率,然后百分制
			todayStatic = MoneyUtil.mul(MoneyUtil.div(todayTotal, beforTotal, 2), "100");
			sub = MoneyUtil.sub(todayTotal, beforTotal);
		} else if (todayObj != null) {
			todayStatic = "100";
			sub = todayObj.getTotalPeople();
			total =  todayObj.getTotalPeople();
		}

		root.put("todayStatic", todayStatic);
		root.put("sub", sub);
		root.put("total", total);

		return root;
	}

}
