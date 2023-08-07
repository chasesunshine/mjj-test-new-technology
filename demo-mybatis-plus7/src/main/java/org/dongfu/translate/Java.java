package org.dongfu.translate;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * 百度翻译开放平台： http://api.fanyi.baidu.com/doc/21
 * Java使用百度翻译api： https://blog.csdn.net/qq_37744588/article/details/80845057?spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-3-80845057-blog-90606132.235%5Ev38%5Epc_relevant_sort_base2&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-3-80845057-blog-90606132.235%5Ev38%5Epc_relevant_sort_base2&utm_relevant_index=6
 * Java文件输入流应用示例。用字符流实现，从文本文件中读取数据并显示在屏幕上： https://blog.csdn.net/M_Ciao/article/details/127468029
 */
public class Java {
    public static void main(String[] args) {
        Main main = new Main();

        try {
            File file = new File("C:\\个人测试\\Java.pu");  //文件地址
            FileReader fr = new FileReader(file);   //创建输入流
            int n;
            StringBuffer stringBuffer = new StringBuffer("");
//            StringBuffer stringBufferFinal = new StringBuffer("");

            while((n=fr.read())!=-1){   //循环读取数据
                char n1 = (char) n;
//                if('\r' == n1){
//                    if("\n" .equals(stringBuffer.toString())){
//                        stringBufferFinal.append(stringBuffer.toString());
//                    }else {
//                        String translate = main.translate(stringBuffer.toString(), "jp", "zh");
//
//                        stringBufferFinal.append(translate);
//                        stringBufferFinal.append(n1);
//                    }
//
//                    stringBuffer.delete(0, stringBuffer.length());
//                }else{
//                    stringBuffer.append(n1);
//                }

                if(' ' == n1 || '\r' == n1 || '\n' == n1){
                    stringBuffer.append(n1);
                }else {
                    String translate = main.translate(String.valueOf(n1), "jp", "zh");
                    stringBuffer.append(translate);
                }
            }
            fr.close();    //关闭流
            System.out.println(stringBuffer.toString());
        }
        catch(FileNotFoundException e){
            System.out.println("文件找不到！");
        }
        catch(IOException ioe){
            System.out.println("出现错误！");
        }
    }
}
