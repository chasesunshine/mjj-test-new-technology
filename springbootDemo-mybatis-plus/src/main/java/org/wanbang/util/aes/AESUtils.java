package org.wanbang.util.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
/**
 *
 * @author Administrator
 *
 */
public class AESUtils {

    // 加密
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return new Base64().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {

        // 需要加密的字串
        JSONObject object = new JSONObject();
        object.put("goodsNo","12345678xsxsxs");
        object.put("code","200");
        object.put("message","mjj");
        String toJSONString = object.toJSONString();
        System.out.println("加密前的字串是：" + toJSONString);

        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        String cKey = "pms654321;++==--";

        // 加密
        String enString = AESUtils.Encrypt(toJSONString, cKey);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String DeString = AESUtils.Decrypt(enString, cKey);
        System.out.println("解密后的字串是：" + DeString);

        JSONObject value = JSONObject.parseObject(DeString);

        System.out.println("转换："+value.toJSONString());
        String goodsNo = value.getString("goodsNo");
        String code = value.getString("code");
        String message = value.getString("message");
        System.out.println("goodsNo :"+goodsNo);
        System.out.println("code :"+code);
        System.out.println("message :"+message);

    }
}

//源代码片段来自云代码http://yuncode.net