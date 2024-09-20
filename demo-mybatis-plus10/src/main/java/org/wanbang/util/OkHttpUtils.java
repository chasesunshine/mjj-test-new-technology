package org.wanbang.util;

//import com.alibaba.nacos.common.http.BaseHttpMethod;
//import lombok.extern.slf4j.Slf4j;
//import okhttp3.*;
//import org.apache.commons.lang3.ObjectUtils;
//import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: majiajian
 * @CreateTime: 2024-09-19 11:39
 * @Description:
 */
//@Slf4j
//@Component
public class OkHttpUtils {

//    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
//
//    private static OkHttpClient client;
//
//    @Autowired
//    public void setClient(@Qualifier(value = "originalOkHttpClient") OkHttpClient client) {
//        OkHttpUtils.client = client;
//    }
//
//    /**
//     * CloseableHttpClient 方式 - 发送请求参数在RequestBody中的Get请求
//     * OkHttpClient 不支持
//     *
//     * @param url 地址
//     * @param jsonStr 参数
//     *              demo:   Gson gson = new GsonBuilder().create();
//     *                      String reqParams = gson.toJson(reqParamEntity);
//     * @param heads 请求头
//     * @return
//     * @throws Exception
//     */
//    public static String getRequestBodyHeader(String url, String jsonStr, Map<String, String> heads) {
//        String body = "";
//
//        //创建httpclient对象
//        CloseableHttpClient client = HttpClients.createDefault();
//
//        // http get实体
//        BaseHttpMethod.HttpGetWithEntity httpGetWithEntity = new BaseHttpMethod.HttpGetWithEntity(url);
//        HttpEntity httpEntity = new StringEntity(jsonStr, ContentType.APPLICATION_JSON);
//        httpGetWithEntity.setEntity(httpEntity);
//
//        // 设置请求头
//        if(MapUtils.isNotEmpty(heads)){
//            for (String key : heads.keySet()){
//                String value = heads.get(key);
//                httpGetWithEntity.addHeader(key,value);
//            }
//        }
//
//        try {
//            //执行请求操作，并拿到结果（同步阻塞）
//            CloseableHttpResponse response = client.execute(httpGetWithEntity);
//            assert response.getEntity() != null;
//            //获取结果实体
//            HttpEntity entity = response.getEntity();
//            if (entity != null) {
//                //按指定编码转换结果实体为String类型
//                body = EntityUtils.toString(entity, "utf-8");
//            }
//            //释放链接
//            response.close();
//            return body;
//        }catch (Exception e ){
//            log.error("CloseableHttpClient方式 - 发送请求参数在Body中Get请求失败 {}",  ExceptionUtils.getMessage(e));
//            return null;
//        }
//    }
//
//    /**
//     * OkHttpClient get请求 - url请求
//     *
//     * @param url 地址
//     * @param heads 请求头
//     * @return
//     */
//    public static String getForUrl(String url, Map<String, String> heads){
//        try {
//            Headers headers = getHeaders(heads);
//            Request request = new Request.Builder()
//                    .url(url)
//                    .build();
//            if(ObjectUtils.isNotEmpty(headers)){
//                request.newBuilder().headers(headers);
//            }
//
//            Response response = client.newCall(request).execute();
//            assert response.body() != null;
//            return response.body().string();
//        } catch (Exception e) {
//            log.warn("GET ERROR: {}", ExceptionUtils.getMessage(e));
//        }
//        return null;
//    }
//
//    /**
//     *  OkHttpClient get请求 - 带requestparam参数
//     *
//     * @param url 地址
//     * @param params requestparam参数
//     * @return
//     */
//    public static String getParams(String url , Map<String, String> params , Map<String, String> heads){
//        try {
//            // 构建带有参数的 URL
//            HttpUrl httpUrl = new HttpUrl.Builder()
//                    .scheme("https")
//                    .host(url)
//                    .addPathSegment("data")
//                    .build();
//
//            HttpUrl.Builder urlBuilder = httpUrl.newBuilder();
//            if(MapUtils.isNotEmpty(params)){
//                for (String key : params.keySet()){
//                    String value = params.get(key);
//                    urlBuilder.addQueryParameter(key, value);
//                }
//            }
//
//            // 构建最终的 URL
//            httpUrl = urlBuilder.build();
//
//            Headers headers = getHeaders(heads);
//
//            // 构建 Request 对象
//            Request request = new Request.Builder()
//                    .url(httpUrl)
//                    .build();
//            if(ObjectUtils.isNotEmpty(headers)){
//                request.newBuilder().headers(headers);
//            }
//
//            Response response = client.newCall(request).execute();
//            assert response.body() != null;
//            return response.body().string();
//        } catch (Exception e) {
//            log.warn("GET PARAMS ERROR: {}", ExceptionUtils.getMessage(e));
//        }
//        return null;
//    }
//
//    /**
//     * OkHttpClient post请求
//     *
//     * @param url 请求url
//     * @param jsonStr 请求入参
//     *              demo:   Gson gson = new GsonBuilder().create();
//     *                      String reqParams = gson.toJson(reqParamEntity);
//     * @param heads 请求头
//     * @return
//     */
//    public static String postJsonHead(String url, String jsonStr, Map<String, String> heads) {
//        try {
//            RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, jsonStr);
//            Headers headers = getHeaders(heads);
//            Request request = new Request.Builder()
//                    .url(url)
//                    .post(requestBody)
//                    .build();
//            if(ObjectUtils.isNotEmpty(headers)){
//                request.newBuilder().headers(headers);
//            }
//
//            Response response = client.newCall(request).execute();
//            assert response.body() != null;
//            return response.body().string();
//        } catch (IOException e) {
//            log.warn("POST JSON ERROR: {}", ExceptionUtils.getMessage(e));
//        }
//        return null;
//    }
//
//    /**
//     * 设置headers
//     *
//     * @param heads
//     * @return
//     */
//    private static Headers getHeaders(Map<String, String> heads) {
//        Headers.Builder builder = new Headers.Builder();
//        if (MapUtils.isNotEmpty(heads)) {
//            heads.keySet().forEach(key -> builder.add(key, heads.get(key)));
//        }else {
//            return null;
//        }
//        Headers headers = builder.build();
//        return headers;
//    }


}
