package org.wanbang.study.ioc.ioc07.io;

import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/10/8 11:14
 * @version 1.0
 */

/**
 * 通过 HTTP 的方式读取云服务的文件，我们也可以把配置文件放到 GitHub 或者
 * Gitee 上。
 */
public class UrlResource implements Resource {
    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        try {
            return con.getInputStream();
        }catch (IOException ex){
            if (con instanceof HttpURLConnection){
                ((HttpURLConnection) con).disconnect();
            }
            throw ex;
        }
    }

}