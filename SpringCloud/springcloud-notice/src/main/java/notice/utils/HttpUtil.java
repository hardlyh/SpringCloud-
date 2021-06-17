package notice.utils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Administrator
 * 通过okttp进行封装,     异步,同步
 */
public class HttpUtil {
	
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	public void post(String url) throws IOException {
		 OkHttpClient client = new OkHttpClient();
		  Request request = new Request.Builder()
	                .url(url)
	                .build();

	        Response response = client.newCall(request).execute();

	        if (response.isSuccessful()) {
	            System.out.println(response.body().string());
	        }
	}
	
	public void get() {
		
	}
	
	public void normal() {
		
	}
	
	public void syncPost() {
		
	}

}
