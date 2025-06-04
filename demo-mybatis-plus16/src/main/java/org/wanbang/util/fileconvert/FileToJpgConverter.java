package org.wanbang.util.fileconvert;

import org.apache.commons.io.ByteOrderMark;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.input.BOMInputStream;

@Component
public class FileToJpgConverter extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 获取上传的文件
//        Part filePart = request.getPart("file");
//        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//        InputStream fileContent = filePart.getInputStream();

        // 获取上传的文件
        String fileUrl = request.getHeader("fileUrl");

        // mjj 实现文件的转换
        HttpClientUrlFetcher.FileData fileData = HttpClientUrlFetcher.fetchFileFromUrl(fileUrl);
        String fileName = fileData.getFileName();
        InputStream fileContent = fileData.getInputStream();

        // 转换为 JPG
        BufferedImage image = convertToJpg(fileContent, fileName,"");

        // 设置响应头
        response.setContentType("image/jpeg");
        response.setHeader("Content-Disposition", "inline; filename=\"converted.jpg\"");

        // 输出 JPG 到响应流
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    public void convertFile(MultipartFile file, HttpServletResponse response) throws IOException{
        Charset charset = readWithBOMDetection(file);
        String content = new String(file.getBytes(), charset);

        // 1. 获取文件名（包括扩展名）
        String fileName = file.getOriginalFilename();
        InputStream fileContent = file.getInputStream();

        // 转换为 JPG
        BufferedImage image = convertToJpg(fileContent, fileName,content);

        // 设置响应头
        response.setContentType("image/jpeg");
        response.setHeader("Content-Disposition", "inline; filename=\"converted.jpg\"");

        // 输出 JPG 到响应流
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    /**
     * 转换为图片
     * @param inputStream
     * @param fileName
     * @return
     * @throws IOException
     */
    private BufferedImage convertToJpg(InputStream inputStream, String fileName,String content) throws IOException {
        BufferedImage image;

        try {
            // 尝试直接读取为图像
            image = ImageIO.read(inputStream);

            if (image == null) {
                // 如果不是图像文件，创建包含文件信息的图像
                image = createImageFromFile(inputStream, fileName,content);
            }

            // 转换为 RGB 格式（确保没有 alpha 通道）
            BufferedImage jpgImage = new BufferedImage(
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_INT_RGB);

            jpgImage.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
            return jpgImage;

        } catch (Exception e) {
            // 转换失败时返回错误图像
            return createErrorImage(e.getMessage());
        }
    }

    private BufferedImage createImageFromFile(InputStream inputStream, String fileName,String content) throws IOException {
        // 读取文件内容为文本
//        String content = new String(inputStream.readAllBytes());

        // 创建包含文件信息的图像
        BufferedImage image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        // 设置背景和文本
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 600, 400);
        graphics.setColor(Color.BLACK);
//        graphics.setFont(new Font("Arial", Font.PLAIN, 16));
        graphics.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));

        // 绘制文件名和内容
//        graphics.drawString("File: " + fileName, 20, 30);

        // 分行绘制文件内容
        String[] linesOld = content.split("\n");

        ArrayList<String> list = new ArrayList<>(Arrays.asList(linesOld));
//        list.subList(0, 20).clear(); // 删除前20个元素
        String[] lines = list.toArray(new String[0]);

        for (int i = 0; i < Math.min(lines.length, 20); i++) {
            graphics.drawString(lines[i], 20, 60 + i * 20);
        }

        if (lines.length > 20) {
            graphics.drawString("... (content truncated)", 20, 60 + 20 * 20);
        }

        graphics.dispose();
        return image;
    }

    /**
     * 创建错误图像
     *
     * @param errorMessage
     * @return
     */
    private BufferedImage createErrorImage(String errorMessage) {
        BufferedImage image = new BufferedImage(400, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, 400, 200);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.BOLD, 16));
        graphics.drawString("Conversion Error:", 20, 40);
        graphics.drawString(errorMessage, 20, 80);

        graphics.dispose();
        return image;
    }

    public static Charset readWithBOMDetection(MultipartFile file) throws IOException {
        try (BOMInputStream bomIn = new BOMInputStream(new ByteArrayInputStream(file.getBytes()), ByteOrderMark.UTF_8, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_16BE)) {
            Charset charset;
            if (bomIn.hasBOM()) {
                charset = Charset.forName(bomIn.getBOM().getCharsetName());
            } else {
                charset = StandardCharsets.UTF_8; // 默认
            }

            return charset;
        }
    }
}
