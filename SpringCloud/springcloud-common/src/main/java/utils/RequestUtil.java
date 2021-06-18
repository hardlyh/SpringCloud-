package utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import log.LogUtil;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

/**
 * http工具类,封装okhttp进行
 */
public class RequestUtil {

	/**
	 * get
	 * @param url
	 * @param headers header的map
	 * @return
	 */
	public static String get(String url, HashMap<String, String> headers) {
		LogUtil.info("请求url:" + url);
		Builder builder = addHeader(headers);
		Request request = builder.url(url).build();
		return send(request);
	}
	
	/**
	 * post  传参通过requestBody
	 * @param url
	 * @param headers header的map
	 * @return
	 */
	public static String post(String url, HashMap<String, String> headers) {
		return "";
	}
	
	/**
	 * post  传参通过param
	 * @param url
	 * @param headers header的map
	 * @return
	 */
	public static String postParam(String url, HashMap<String, String> headers) {
		return "";
	}

	/**
	 * 封装header方法
	 * 
	 * @param headers
	 * @return
	 */
	public static Request.Builder addHeader(HashMap<String, String> headers) {
		Request.Builder builder = new Request.Builder();

		if (headers != null) {
			Set<String> keySet = headers.keySet();
			for (String keyStr : keySet) {
				String value = headers.get(keyStr);
				builder.addHeader(keyStr, value);
			}

		}

		return builder;
	}

	/**
	 * 封装发送方法
	 * @param req
	 * @return
	 */
	public static String send(Request req) {
		String respCon = "";
		OkHttpClient okHttpClient = new OkHttpClient();

		Call call = okHttpClient.newCall(req);
		try {
			Response response = call.execute();
			respCon = response.body().string();
			LogUtil.info("请求返回:" + respCon);
		} catch (IOException e) {
			LogUtil.error("请求异常  : IOException, respCon:" + respCon);
			e.printStackTrace();
		}
		return respCon;
	}
}
