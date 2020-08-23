package com.mining.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.mining.domain.MiningPeopleCount;
import com.mining.service.MiningPeopleCountService;
import com.mining.utils.ImageTest;
import com.mining.utils.LogUtil;
import com.mining.utils.TimeUtil;


@Configuration 
@EnableScheduling
public class PeopleTotalTask {
	
	@Autowired
	private MiningPeopleCountService peopleCountService;
	
	/**
	 *  获取总人数task
	 */
	@Scheduled(cron = "0/5 * * * * ?")
	public void getPeopleCountTask() {
		
		try {
			JSONObject code = ImageTest.getCode();
			LogUtil.info("code:"+code);
			
			if(code != null) {
				
				JSONObject data = code.getJSONObject("data");
				String total = data.get("registration_num").toString();
				String online = data.get("onlinenum").toString();
				
				MiningPeopleCount min = new MiningPeopleCount(null,"1",TimeUtil.getNowDateStr(3),total,online,TimeUtil.getNowDateStr(1),"");
				peopleCountService.save(min);
				LogUtil.info("保存成功人数");
			}
			
		} catch (HttpProcessException e) {
			LogUtil.info("获取人数失败");
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new PeopleTotalTask().getPeopleCountTask();
	}
}
