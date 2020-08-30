package com.mining.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpCookies;
import com.arronlong.httpclientutil.exception.HttpProcessException;

public class SendMsgUtil {
	static String url = "https://oapi.dingtalk.com/robot/send?access_token=8bbd1894881c838e2fe8a3f9381c13210c08b2d78c9463f0e6550b2a21f5d496";

	public static void main(String[] args) {
//		String str = "挖矿增长人数\n 2019-08-27\n  总人数为: xxx\n  增长人数为:xxx\n  昨日增长人数:xxx\n  增长率为: xxx\n  昨日增长率为: xxx ";
//		sendText(str);
		
	}
	
	public static void sendText(String text) {
		JSONObject sendParam = new JSONObject();

		sendParam.put("msgtype", "text");
		JSONObject textParam = new JSONObject();
		textParam.put("content", "**" + text);
		sendParam.put("text", textParam);

		HttpConfig config = HttpConfig.custom() // 设置headers，不需要时则无需设置
				.url(url).json(sendParam.toString());

		String sendResult = "";
		try {
			sendResult = HttpClientUtil.post(config);
		} catch (Exception e) {
			LogUtil.info("推送消息异常:" + e.toString());
			e.printStackTrace();
		}
		JSONObject resultJs = JSON.parseObject(sendResult);
		LogUtil.info("推送消息返回:" + resultJs);
	}

}
