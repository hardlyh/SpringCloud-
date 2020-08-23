package com.mining.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpCookies;
import com.arronlong.httpclientutil.exception.HttpProcessException;

public class SendMsgUtil {

	public static void main(String[] args) throws HttpProcessException {
		JSONObject sendParam = new JSONObject();

		sendParam.put("msgtype", "text");
		JSONObject textParam = new JSONObject();
		textParam.put("content", "**" + "zzs大傻逼");
		sendParam.put("text", textParam);

		HttpConfig config = HttpConfig.custom() // 设置headers，不需要时则无需设置
				.url("https://oapi.dingtalk.com/robot/send?access_token=8bbd1894881c838e2fe8a3f9381c13210c08b2d78c9463f0e6550b2a21f5d496")
				.json(sendParam.toString());
		String result1 = HttpClientUtil.post(config);
		JSONObject resultJs = JSON.parseObject(result1);
	}

}
