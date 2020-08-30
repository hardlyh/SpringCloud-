package com.mining.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.jsoup.Jsoup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpCookies;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.arronlong.httpclientutil.exception.HttpProcessException;

public class ImageTest {

	static Header[] headers = HttpHeader.custom().other("Accept", "*/*").other("Accept-Encoding", "gzip, deflate")
			.other("Accept-Language", "zh-CN,zh;q=0.9").other("Connection", "keep-alive")
			.other("Cookie", "PHPSESSID=67dnlm7n3kf2v78svg2mi8koc6").other("Host", "www.boseaudio.cn")
			.other("luckkey", "undefined").other("Referer", "http://www.boseaudio.cn/")
			.other("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
			.build();

	static Header[] headers2 = HttpHeader.custom().other("Accept", "*/*").other("Accept-Encoding", "gzip, deflate")
			.other("Accept-Language", "zh-CN,zh;q=0.9").other("Connection", "keep-alive")
			.other("Cookie", "PHPSESSID=67dnlm7n3kf2v78svg2mi8koc6").other("Host", "www.boseaudio.cn")
			.other("luckkey", "undefined").other("Referer", "http://www.boseaudio.cn/")
			.other("Origin", "http://www.boseaudio.cn")
			.other("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
			.build();

	public static JSONObject getCode() throws HttpProcessException {
		String url = "http://www.boseaudio.cn/api/verifyCode/get";

		String sessionID = "67dnlm7n3kf2v78svg2mi8koc6";

		HCB hcb = HCB.custom();
		HttpClient client = hcb.build();

		HttpConfig config = HttpConfig.custom().headers(headers) // 设置headers，不需要时则无需设置
				.url(url).context(HttpCookies.custom().getContext());

		String result1 = HttpClientUtil.get(config);
		JSONObject resultJs = JSON.parseObject(result1);

		if (resultJs.getInteger("code") == 200) {
			LogUtil.info("获取验证码成功");
			String imgBase = resultJs.getJSONObject("data").getString("url");
			String imgLoog = imgLoog(imgBase);
			String codeToken = resultJs.getJSONObject("data").getString("token");
			LogUtil.info("图片识别:" + imgLoog);

			JSONObject loginParam = new JSONObject();
			loginParam.put("name", "17194242613");
			loginParam.put("password", "19960215");
			loginParam.put("rememberMe", "");
			loginParam.put("userIP", "119.164.124.154");
			loginParam.put("verifyCode", imgLoog);
			loginParam.put("verifyCodeToken", codeToken);
			loginParam.put("version", "a4e7ca5eea59272a002e1900a9941ced");

			config = HttpConfig.custom().headers(headers2) // 设置headers，不需要时则无需设置
					.url("http://www.boseaudio.cn/api/auth/login").context(HttpCookies.custom().getContext())
					.json(loginParam.toString());

			String loginMsg = HttpClientUtil.post(config);
			LogUtil.info("模拟登录返回信息:" + loginMsg);
			JSONObject loginJs = JSON.parseObject(loginMsg);
			if (loginJs.getInteger("code") == 200) {
				String luck = loginJs.getString("data");

				Header[] headers3 = HttpHeader.custom().other("Accept", "*/*").other("Accept-Encoding", "gzip, deflate")
						.other("Accept-Language", "zh-CN,zh;q=0.9").other("Connection", "keep-alive")
						.other("Cookie", "PHPSESSID=67dnlm7n3kf2v78svg2mi8koc6").other("Host", "www.boseaudio.cn")
						.other("luckkey", luck).other("Referer", "http://www.boseaudio.cn/")
						.other("Origin", "http://www.boseaudio.cn")
						.other("User-Agent",
								"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
						.build();

				config = HttpConfig.custom().headers(headers3) // 设置headers，不需要时则无需设置
						.url("http://www.boseaudio.cn/api/config/getPlatform")
						.context(HttpCookies.custom().getContext());
				String totalPeoStr = HttpClientUtil.post(config);
				LogUtil.info("获取人数信息返回:" + totalPeoStr);
				JSONObject totalPeoJs = JSON.parseObject(totalPeoStr);
				if (totalPeoJs.getInteger("code") == 200) {
					LogUtil.info("获取人数信息成功");
					return totalPeoJs;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) throws IOException, HttpProcessException {
		getCode();
//	
	}

	public static String imgLoog(String imgBase) {

		String username = "a380056867";
		// 你的密码
		String password = "19960215";
		// 图片转换过的base64编码
		String image = imgBase;
		JSONObject obj = new JSONObject();
		obj.put("username", username);
		obj.put("password", password);
		// typeid为可选参数 根据文档填写说明填写 1:纯数字 2:纯英文
		// obj.put("typeid", "");
		// 备注字段: 可以不写
		String remark = "输出计算结果";
		obj.put("image", image);
		try {
			String url = "http://api.ttshitu.com/base64";
			String ret = test1(url, obj);
			JSONObject jsonObject = JSONObject.parseObject(ret);
			if (jsonObject.getBoolean("success")) {
				String result = jsonObject.getJSONObject("data").getString("result");
				System.out.println("识别成功结果为:" + result);
				return result;
			} else {
				System.out.println("识别失败原因为:" + jsonObject.getString("message"));
			}
		} catch (Exception e) {
			System.out.println("识别失败异常:");
		}
		return null;
	}

	public static String test1(String url, JSONObject obj) throws IOException {

		URL u;
		HttpURLConnection con;
		DataOutputStream osw;
		StringBuffer buffer = new StringBuffer();
		u = new URL(url);
		con = (HttpURLConnection) u.openConnection();
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setUseCaches(false);
		con.setInstanceFollowRedirects(true);
		con.setRequestProperty("Content-Type", "application/json");
		osw = new DataOutputStream(con.getOutputStream());
		osw.writeBytes(obj.toString());
		osw.flush();
		osw.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String temp;
		while ((temp = br.readLine()) != null) {
			buffer.append(temp);
			buffer.append('\n');
		}
		return buffer.toString();

	}

	public void test2() throws IOException {
		// 用户名
		String username = "a380056867";
		// 密码
		String password = "19960215";
		// 验证码类型(默认数英混合),1:纯数字, 2:纯英文，其他:数英混合：可空
		String typeid = "1";
		// 备注字段: 可以不写
		String remark = "输出计算结果";
		InputStream inputStream = null;
		// 你需要识别的1:图片地址，2:也可以是一个文件
		// 1:这是远程url的图片地址
		// String url =
		// "https://ningge.oss-cn-shanghai.aliyuncs.com/recordImage/0000008bd2134152aa5fad036a802a89.jpg";
		// URL u = new URL(url);
		// inputStream=u.openStream();

		// 2:这是本地文件
		File needRecoImage = new File("C:\\Users\\liyuhui\\Desktop\\222.png");
		inputStream = new FileInputStream(needRecoImage);

		Map<String, String> data = new HashMap<>();
		data.put("username", username);
		data.put("password", password);
		data.put("typeid", typeid);
		data.put("remark", remark);

		String resultString = Jsoup.connect("http://api.ttshitu.com/create.json").data(data)
				.data("image", "test.jpg", inputStream).ignoreContentType(true).post().text();
		JSONObject jsonObject = JSONObject.parseObject(resultString);
		if (jsonObject.getBoolean("success")) {
			String result = jsonObject.getJSONObject("data").getString("result");
			System.out.println("识别成功结果为:" + result);
		} else {
			System.out.println("识别失败原因为:" + jsonObject.getString("message"));
		}
	}

}
