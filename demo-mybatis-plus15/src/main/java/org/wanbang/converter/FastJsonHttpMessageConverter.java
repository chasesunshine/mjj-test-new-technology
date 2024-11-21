package org.wanbang.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public FastJsonHttpMessageConverter() {
        super(new MediaType[]{MediaType.APPLICATION_JSON});
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        // 由于 FastJSON 可以转换任何对象，这里返回 true
        return true;
    }

    @Override
    protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
//        String json = new String(inputMessage.getBody().readAllBytes(), "UTF-8");
//        return JSON.parseObject(json, clazz);
        return null;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        String json = JSON.toJSONString(o, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        outputMessage.getBody().write(json.getBytes("UTF-8"));
    }
}
