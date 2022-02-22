package org.wanbang.study.filterAndInterceptor.filter;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

// 对于get请求和post请求全局过滤：
//自己创建一个类，实现HttpServletRequestWrapper接口
public class FilterSetRequest extends HttpServletRequestWrapper {
    public FilterSetRequest(HttpServletRequest request){
        super(request);
    }

    @Override
    public String getParameter(String name){
        String value = super.getParameter(name);
        //判断是否是使用get请求
        if(getMethod().equalsIgnoreCase("GET")){
            try
            {
                value = new String(value.getBytes("iso-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return value;
    }
}
