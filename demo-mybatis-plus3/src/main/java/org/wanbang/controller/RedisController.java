package org.wanbang.controller;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.wanbang.service.SpringWordService;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/6/22 16:14
 * @version 1.0
 */

@Component
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    private SpringWordService springWordService;

//    @Resource
//    private LockExecutor lockExecutor;

    @GetMapping("/selectOne")
    public void  selectOne(){
//        try {
//            String mjj1 = lockExecutor.exec("Mjj:token", 3, () -> {
//                return "1";
//            });
//            System.out.println("1");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) throws ParseException {
        String date = "202207";
        String string = new StringBuffer(date).insert(4, "-").append("-01 00:00:00").toString();
        Date date3 = new Date();

        Date parse = DateUtils.parseDate(string,"yyyy-MM-dd HH:mm:ss");

        Date date1 = stepMonth(parse, 1);
        Date date2 = stepDay(date1, -1);

        System.out.println(date2);
        System.out.println(date3);
    }

    public static Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

    public static Date stepDay(Date sourceDate, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

}
