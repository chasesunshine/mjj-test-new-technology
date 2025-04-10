package org.wanbang.util;

import lombok.extern.log4j.Log4j2;
import org.apache.hadoop.conf.Configuration;
import org.springframework.stereotype.Component;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Hadoop工具类
 * @Author
 * @Date 2024/7/23 下午2:54
 * @Version 1.0
 */
@Component
@Log4j2
public class HadoopUtil {

    @Value("${hadoop.fsUri}")
    private String fsUri;

    @Value("${hadoop.input.path}")
    private String inputPath;

    @Resource
    private FileSystem fileSystem;


    /**
     * 输入流上传
     * @param inputStream 输入流
     * @param hdfsFilePath 路径
     * @throws IOException
     */
    public void uploadFileToHDFS(InputStream inputStream, String hdfsFilePath) throws Exception {
        Path path = new Path(hdfsFilePath);

        Configuration conf = new Configuration();
        // 设置代理用户
        conf.set("hadoop.proxyuser.superuser.hosts", "*");
        conf.set("hadoop.proxyuser.superuser.groups", "*");
        // 或者在获取FileSystem时指定用户
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://localhost:9000"), conf, "daikin");

        try (FSDataOutputStream outputStream = fileSystem.create(path)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }
            log.info("文件上传成功");
        } finally {
            inputStream.close();
        }
    }

    /**
     * 本地文件上传
     * @param localFilePath 文件路径
     * @param hdfsFilePath 上传路径
     * @throws IOException
     */
    public void uploadLocalFileToHDFS(String localFilePath, String hdfsFilePath) throws Exception {
        try (InputStream inputStream = new FileInputStream(localFilePath)) {
            uploadFileToHDFS(inputStream, hdfsFilePath);
        } catch (FileNotFoundException e) {
            throw new IOException("找不到文件：" + localFilePath, e);
        }
    }

    /**
     * 文件下载
     * @param hdfsFilePath 文件路径
     * @param outputStream 输出流
     * @throws IOException
     */
    public void downloadFileFromHDFS(String hdfsFilePath, OutputStream outputStream) throws Exception {
        Path path = new Path(hdfsFilePath);

        Configuration conf = new Configuration();
        // 设置代理用户
        conf.set("hadoop.proxyuser.superuser.hosts", "*");
        conf.set("hadoop.proxyuser.superuser.groups", "*");
        // 或者在获取FileSystem时指定用户
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://localhost:9000"), conf, "daikin");

        try (FSDataInputStream inputStream = fileSystem.open(path)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    /**
     * 创建目录
     * @param hdfsDirPath 文件目录
     * @throws IOException
     */
    public void createDirectoryInHDFS(String hdfsDirPath) throws IOException {
        Path path = new Path(hdfsDirPath);
        // 检查目录是否已经存在
        if (fileSystem.exists(path)) {
            // 目录已存在
            log.info("目录已存在: " + hdfsDirPath);
            return;
        }
        // 创建目录
        boolean success = fileSystem.mkdirs(path);
        if (!success) {
            throw new IOException("目录创建失败: " + hdfsDirPath);
        }
        log.info("目录创建成功: " + hdfsDirPath);
    }
}


