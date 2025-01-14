package org.wanbang.testlvmi;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.collections4.MapUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Test {

    public static void main(String[] args) {
        String url = "https://open-cn.aqara.com/v3.0/open/api";
        String randomString = TimestampedRandomStringGenerator.generateRandomString();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String accesstoken = "a244f6341a3e713e046960cbbe483a13";
        stringStringHashMap.put("Accesstoken",accesstoken);
        stringStringHashMap.put("Appid","12979313793780776965bd52");
        stringStringHashMap.put("Keyid","K.1297931379814285312");
        stringStringHashMap.put("Nonce",randomString);
        stringStringHashMap.put("Time",timeStamp);
        stringStringHashMap.put("Sign",CreateSign.getSign(accesstoken,timeStamp,randomString));
        stringStringHashMap.put("Lang","zh");

        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setIntent("query.device.info");
        Device device = new Device();
        device.setPageNum(2);
        device.setPageSize(10);
        device.setPositionId("");
        device.setDids(null);
        deviceDTO.setData(device);

        Gson gson = new Gson();
        JsonObject jsonObject = gson.toJsonTree(deviceDTO).getAsJsonObject();
        String jsonStr = jsonObject.toString();

        String s = postJsonHead(url, jsonStr, stringStringHashMap);
        System.out.println(s);
    }

    public static String postJsonHead(String url, String jsonStr, Map<String, String> heads) {
        OkHttpClient client = new OkHttpClient();
        try {
            // 构造请求体
            RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), jsonStr);

            // 设置headers
            Headers headers = getHeaders(heads);

            if(ObjectUtils.isNotEmpty(headers)){
                // 创建Request对象，设置URL、请求体和头部信息
                Request request = new Request.Builder()
                        .url(url)
                        .headers(headers)
                        .post(body)
                        .build();
                Response response = client.newCall(request).execute();
                return response.body().string();
            }else {
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                Response response = client.newCall(request).execute();
                return response.body().string();
            }
        } catch (IOException e) {
            log.warn("POST JSON ERROR: {}", e.getMessage());
        }finally {
            client.connectionPool().evictAll();
        }
        return null;
    }

    /**
     * 设置headers
     *
     * @param heads
     * @return
     */
    private static Headers getHeaders(Map<String, String> heads) {
        Headers.Builder builder = new Headers.Builder();
        if (MapUtils.isNotEmpty(heads)) {
            heads.keySet().forEach(key -> builder.add(key, heads.get(key)));
        }else {
            return null;
        }
        Headers headers = builder.build();
        return headers;
    }
}
