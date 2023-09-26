package org.wanbang.study.threadLocal.ThreadLocalTest2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilThreadLocal {
    private static ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(
            ()-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static Date parse(String dateStr) {
        Date date = null;
        try {
            date = threadLocal.get().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
