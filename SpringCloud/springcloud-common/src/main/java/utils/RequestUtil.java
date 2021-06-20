package utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import log.LogUtil;
import okhttp3.*;
import okhttp3.Request.Builder;
import org.jetbrains.annotations.NotNull;
import sun.applet.Main;

/**
 * http工具类,封装okhttp进行
 */
public class RequestUtil {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * get
     *
     * @param url
     * @param headers header的map
     * @return
     */
    public static String get(String url, HashMap<String, String> headers) {
        // LogUtil.info("请求url:" + url);
        Builder builder = addHeader(headers);
        Request request = builder.url(url).build();
        return send(request);
    }


    /**
     * post请求, 数据域存放requestBody中
     * @param url
     * @param json  json数据
     * @param headers header数据 没有传递null
     * @return
     */
    public static String post(String url, JSONObject json, HashMap<String, String> headers) {
        RequestBody body = RequestBody.create(JSON, json.toString());
        Builder builder = addHeader(headers);
        Request request = builder.post(body)
                .url(url)
                .build();
        return send(request);
    }


    /**
     * post请求,表单域提交数据
     * @param url
     * @param paramMap 表单域数据内容
     * @param headers 请求头内容,无传空
     * @return
     */
    public static String postParam(String url, HashMap<String, String> paramMap, HashMap<String, String> headers) {
        FormBody.Builder formBody = new FormBody.Builder();

        // 遍历Map,组长okhttp的信息
        Set<String> keys = paramMap.keySet();
        for (String key : keys) {
            String value = paramMap.get(key);
            formBody.add(key, value);
        }

        // 发送请求
        FormBody form = formBody.build();
        Builder builder = addHeader(headers);
        Request request = builder.post(form)
                .url(url)
                .build();
        return send(request);
    }

    /**
     * 封装添加header方法
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
     * 封装同步发送方法
     *
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
            // LogUtil.info("请求返回:" + respCon);
        } catch (IOException e) {
            // LogUtil.error("请求异常  : IOException, respCon:" + respCon);
            e.printStackTrace();
        }
        return respCon;
    }


    /**
     * 封装异步发送方法
     *
     * @param req
     * @return
     */
    public static String sysnsend(Request req) {
        String respCon = "";
        OkHttpClient okHttpClient = new OkHttpClient();

        Call call = okHttpClient.newCall(req);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                LogUtil.error("请求异常  : IOException, respCon:" + e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String str = response.body().string();
                LogUtil.error("请求成功,返回内容 : " + str);
            }
        });
        return "";
    }

    public static void main(String[] args) {
        String url = "https://api.369cx.cn/v2/Line/GetRealTimeLineInfo/218?type=3&rnd=1";

        HashMap<String,String> header = new HashMap<>();
        header.put("User-Agent","Mozilla/5.0 (Linux; Android 7.1.2; Redmi/vmos) Cx369Android/6200 NetType/WIFI BusQrCodeSdkVersion/4 DarkMode/0");
        header.put("Host","api.369cx.cn");
        header.put("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6Ik5tWTNOalJoT0RBdE9EQXhOUzAwTmpNNUxXRXlabUV0WmpSaU5tRTVNR0UzWlRVMyIsInJvbGUiOiJWaXNpdG9yIiwibmFtZWlkIjoiLTE4MDgxNzg4OTkiLCJqdGkiOiIzODk0OTE3MC01OWQwLTRkMGQtYTJmNC0yNDk5YWQwYWYyMzUiLCJuYmYiOjE2MjA5MDYwMzIsImV4cCI6MTc3ODY3MjQzMiwiaWF0IjoxNjIwOTA2MDMyLCJpc3MiOiJ3ZWIuMzY5Y3guY24iLCJhdWQiOiJhcGkud2ViLjM2OWN4LmNuIn0.vNwKgScYozMPETGzuQOT0YC73ybTtLpmaHK1GFf58bJ38peFm4hrV9fhaMrGODPvDcTAGmNAkkCCxLektPKgsMWjwWPj7UpXlIlBIhuYjCnXYk48LdMq-rJtaAgbhJZYcw66Z1fDHFg3ps7lg4KFXTvyS_AaFKJKEfN1afJeeygkRrN-GGr2t0lXhADr3bucIWVww38u0_WQXES3iyPB3fDRwgr_2FiuErkHd563J7OYCg3LMC660A6QM-v_ydjWSFh_G00LRtr-cyACCXlCvv-r2ch6qbiys8yqUSNDPToiPos0vO9mgCOv1KfvVy9KHGFF2fXfy9hkwI_u76ol0A");

        String con = get(url, header);
        System.out.println(con);
    }
}
