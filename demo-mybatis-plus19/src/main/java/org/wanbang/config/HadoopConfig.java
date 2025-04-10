package org.wanbang.config;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Author
 * @Date 2024/7/22 上午11:50
 * @Version 1.0
 */

@org.springframework.context.annotation.Configuration
@ConditionalOnProperty(name="hadoop.fsUri")
public class HadoopConfig {

    @Value("${hadoop.fsUri}")
    private String fsUri;


    /**
     * Configuration conf=new Configuration（）；
     * 创建一个Configuration对象时，其构造方法会默认加载hadoop中的两个配置文件，
     * 分别是hdfs-site.xml以及core-site.xml，这两个文件中会有访问hdfs所需的参数值，
     * 主要是fs.default.name，指定了hdfs的地址，有了这个地址客户端就可以通过这个地址访问hdfs了。
     * 即可理解为configuration就是hadoop中的配置信息。
     * @return
     */
    @Bean
    public FileSystem fileSystem() throws IOException, InterruptedException, URISyntaxException {
        System.setProperty("hadoop.home.dir", "D:\\allSoftwareInstall\\workSoftwareInstall\\hadoopInstallPackage\\hadoop-3.1.0");
        System.setProperty("HADOOP_USER_NAME", "daikin");
        // 创建Hadoop Configuration实例
        Configuration configuration = new Configuration();
        // 设置HDFS系统URL
        configuration.set("fs.defaultFS", fsUri);
        // 使用指定的URI、配置和用户名"root"来获取一个FileSystem实例
        return FileSystem.get(new URI(fsUri), configuration, "root");
    }
}


