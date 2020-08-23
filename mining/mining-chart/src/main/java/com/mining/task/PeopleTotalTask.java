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
import com.mining.utils.SendMsgUtil;
import com.mining.utils.TimeUtil;

@Configuration
@EnableScheduling
public class PeopleTotalTask {

	@Autowired
	private MiningPeopleCountService peopleCountService;

	/**
	 * 获取总人数task
	 */
	@Scheduled(cron = "0 15 23 * * ?")
	public void getPeopleCountTask() {

		try {
			String nowDate = TimeUtil.getNowDateStr(3);
			JSONObject code = ImageTest.getCode();
			LogUtil.info("code:" + code);

			if (code != null) {

				JSONObject data = code.getJSONObject("data");
				String total = data.get("registration_num").toString();
				String online = data.get("onlinenum").toString();

				MiningPeopleCount min = new MiningPeopleCount(null, "1", nowDate, total, online,
						TimeUtil.getNowDateStr(1), "");
				peopleCountService.save(min);

				LogUtil.info("保存成功人数");

//				String nowDate = "2020-08-23";
				try {
					// 计算推送消息
					JSONObject todayObj = peopleCountService.getStatisticsByDate(nowDate);
					JSONObject beforObj = peopleCountService.getStatisticsByDate(TimeUtil.getBeforeDay(nowDate, 1));

					StringBuffer sb = new StringBuffer();
					sb.append("挖矿增长人数统计" + "\n");
					sb.append(nowDate + "\n");
					sb.append("  今日总人数为 : " + todayObj.getString("total") + "\n");
					sb.append("  今日增长人数为 : " + todayObj.getString("sub") + "\n");
					sb.append("  昨日增长人数为 : " + beforObj.getString("sub") + "\n");
					sb.append("  今日增长率为  : " + todayObj.getString("todayStatic") + "\n");
					sb.append("  昨日增长率为  : " + beforObj.getString("todayStatic"));

					LogUtil.info("推送信息为:" + sb.toString());
					SendMsgUtil.sendText(sb.toString());
				} catch (Exception e) {
					LogUtil.error("计算推送消息出现异常:" + e.toString());
					e.printStackTrace();
				}

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
