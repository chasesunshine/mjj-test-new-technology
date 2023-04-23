package com.log.collection.core;

import java.util.UUID;

/**
 * @author :XXX
 * @date :2021-02-08 11:41
 * @description :
 */
public class LogHelper {

    public static String getTraceId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}