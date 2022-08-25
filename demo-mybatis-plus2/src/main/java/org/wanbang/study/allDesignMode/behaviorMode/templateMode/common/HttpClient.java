package org.wanbang.study.allDesignMode.behaviorMode.templateMode.common;

import com.alibaba.schedulerx.shade.org.apache.http.client.methods.CloseableHttpResponse;
import com.alibaba.schedulerx.shade.org.apache.http.client.methods.HttpGet;
import com.alibaba.schedulerx.shade.org.apache.http.entity.StringEntity;
import com.alibaba.schedulerx.shade.org.apache.http.impl.client.CloseableHttpClient;
import com.alibaba.schedulerx.shade.org.apache.http.impl.client.HttpClients;
import com.alibaba.schedulerx.shade.org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 13:17
* @version 1.0
*/

public class HttpClient {
    /**
     * @param url
     * @param jsonString
     * @return
     * @throws IOException
     */
    public static String doGet(String url, String jsonString) {
        try {

            // 创建Httpclient对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = null;
            String resultString = "";
            // 创建参数列表
            if (jsonString != null & !"".equals(jsonString)) {
                StringEntity strEnt = new StringEntity(jsonString.toString(), "UTF-8");//解决中文乱码问题
                strEnt.setContentEncoding("UTF-8");
                strEnt.setContentType("application/json");
            }
            // 创建Http get请求
            HttpGet httpGet = new HttpGet(url+"?"+jsonString);
            // 执行http请求
            response = httpClient.execute(httpGet);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            return resultString;
        }catch (Exception e){
            return null;
        }
    }


}
