package org.wanbang.study.designMode.decorator.test;


import org.wanbang.study.designMode.decorator.IPhone;
import org.wanbang.study.designMode.decorator.Phone;
import org.wanbang.study.designMode.decorator.PlayPhoneDecorate;
import org.wanbang.study.designMode.decorator.RingPhoneDecorate;

import java.io.*;

/**
 * PhoneDemo
 * 装饰者模式
 *   装饰者模式就是使用被装饰类的一个子类的实例，在客户端将
 * 这个子类的实例交给装饰类。是集成的替代方案
 *   优点：使用装饰模式，可以提供比继承更灵活的扩展对象的功能，它可以动态的添加对象
 * 的功能，并且可以随意地组合这些功能。
 *   缺点：正因为可以随意组合，所以就可能出现一些不合理地逻辑
 * @author MoXingJian
 * @email 939697374@qq.com
 * @date 2016年12月11日 下午9:06:30
 * @version 1.0
 */
public class PhoneDemo {
    public static void main(String[] args) {
        Phone p = new IPhone();
        p.call();
        System.out.println("-----------------------");
        // 打电话前听彩铃
        // 给手机添加彩铃功能
        RingPhoneDecorate rpd = new RingPhoneDecorate(p);
        rpd.call();
        System.out.println("-----------------------");
        // 打完电话后看视频
        // 给手机添加播放视频
        PlayPhoneDecorate pd = new PlayPhoneDecorate(p);
        pd.call();
        System.out.println("-----------------------");
        // 打电话前听彩铃，打完电话后播放视频
        RingPhoneDecorate r = new RingPhoneDecorate(new PlayPhoneDecorate(p));
        r.call();
        System.out.println("-----------------------");
        // 类似的IO流也是装饰者模式设计
        InputStream is = System.in; // 字节流
        // 包装
        InputStreamReader isr = new InputStreamReader(is); // 字符流，单读取一个
        // 再包装
        BufferedReader bis = new BufferedReader(isr);
        // 可以用一行来表示
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //又或者是控制台录入
        //Scanner sc = new Scanner(System.in);
    }
}
