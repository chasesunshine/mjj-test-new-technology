package org.wanbang.testlvmi;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class AccessToken {

    public static void main(String[] args) {
        String accessToken = getAccessToken();
        System.out.println(accessToken);
    }


    public static String getAccessToken(){
        String forUrl = getForUrl("https://open-cn.aqara.com/v3.0/open/authorize?response_type=code&client_id=12979313793780776965bd52&redirect_uri=https://developer.aqara.com/", null);
        return forUrl;
    }

    public static String getForUrl(String url, Map<String, String> heads){
        try {
            return getResponse(heads, new Request.Builder()
                    .url(url));
        } catch (Exception e) {
            log.warn("GET ERROR: {}", ExceptionUtils.getMessage(e));
        }
        return null;
    }

    /**
     * 获取http访问返回结果
     *
     * @param heads 请求头
     * @param httpUrl 地址
     * @return
     * @throws IOException
     */
    private static String getResponse(Map<String, String> heads, Request.Builder httpUrl) throws IOException {
        Headers headers = getHeaders(heads);

        // 构建 Request 对象
        Request request = httpUrl
                .build();
        if(ObjectUtils.isNotEmpty(headers)){
            request.newBuilder().headers(headers);
        }
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        return response.body().string();
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
