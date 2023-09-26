package org.wanbang.translate;


import com.alibaba.druid.sql.visitor.functions.Char;
import lombok.extern.slf4j.Slf4j;
import org.wanbang.translate.util.Main;

import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 百度翻译开放平台： http://api.fanyi.baidu.com/doc/21
 * Java使用百度翻译api： https://blog.csdn.net/qq_37744588/article/details/80845057?spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-3-80845057-blog-90606132.235%5Ev38%5Epc_relevant_sort_base2&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-3-80845057-blog-90606132.235%5Ev38%5Epc_relevant_sort_base2&utm_relevant_index=6
 * Java文件输入流应用示例。用字符流实现，从文本文件中读取数据并显示在屏幕上： https://blog.csdn.net/M_Ciao/article/details/127468029
 */
@Slf4j
public class Java {
    public static void main(String[] args) throws Exception {
        LinkedList<Char> charList = new LinkedList<>();
        char[] chars = {'a','b'};
        Main main = new Main();

        try {
            File file = new File("C:\\个人测试\\翻译前.pu");  //文件地址
            FileReader fr = new FileReader(file);   //创建输入流
            int n;
            StringBuffer stringBufferTemp = new StringBuffer("");
            StringBuffer stringBufferFinal = new StringBuffer("");

            //循环读取数据
            while((n=fr.read())!=-1){
                char n1 = (char) n;
                if(checkSignatureText(String.valueOf(n1)) || ' ' == n1){
                    if(stringBufferTemp.length()>0){
                        //翻译
                        String translate = main.translate(stringBufferTemp.toString(), "jp", "zh");
                        stringBufferFinal.append(translate);
//                        stringBufferFinal.append("马佳健测试");
                        stringBufferTemp.delete(0, stringBufferTemp.length());
                    }
                    if(!('\r' == n1 || '\n' == n1)){
                        stringBufferFinal.append(n1);
                    }
                }else {
                    // 只剩中日文了
                    stringBufferTemp.append(n1);
                }

                if('\r' == n1 || '\n' == n1){
                    stringBufferFinal.append(n1);
                }

            }

            fr.close();    //关闭流
            System.out.println(stringBufferFinal);

            long timeMillis = System.currentTimeMillis();
            FileWriter fw=new FileWriter("C:\\个人测试\\"+String.valueOf(timeMillis)+".pu");
            fw.write(stringBufferFinal.toString());
            fw.close();

        }
        catch(Exception e){
            System.out.println("处理错误");
        }

    }

    // java含有特殊符号判断 java判断特殊字符  https://blog.51cto.com/u_16099229/6424420
    private static boolean checkSignatureText(String signatureText) throws Exception {
//        log.info("判断 字母、数字、符号");
        StringBuilder stringBuilder = new StringBuilder("");
        //校验，不支持：空格、符号、全数字  ,符号中英文符号
        char[] signatureChs=signatureText.toCharArray();
        for(char c:signatureChs){
            //48-57数字，65-90大写字母，97-122大写字母 ，0-127以内的英文字母
            if(c<127 && ( (c>47 && c<58) || (c>64 && c<91) || (c>96 && c<121) )){
                return true;
            }
        }

        String regEx = "[ _`[email protected]#$%^&*()（）+=|{}‘:;‘,\\[\\].<>/?~！@#￥%……&*()——+|{}【】‘；：”“’。，、？\"-]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(signatureText);
        if(m.find()){
            return true;
        }
        return false;
    }
}
