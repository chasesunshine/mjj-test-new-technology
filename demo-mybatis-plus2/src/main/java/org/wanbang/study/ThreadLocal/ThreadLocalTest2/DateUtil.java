package org.wanbang.study.ThreadLocal.ThreadLocalTest2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parse(String dateStr) {
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
