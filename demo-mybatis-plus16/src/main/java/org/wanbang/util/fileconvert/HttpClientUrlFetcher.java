package org.wanbang.util.fileconvert;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;

import java.io.IOException;
import java.io.InputStream;

public class HttpClientUrlFetcher {

    public static FileData fetchFileFromUrl(String fileUrl) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(fileUrl);

            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    // 获取输入流
                    InputStream inputStream = entity.getContent();

                    // 获取文件名
                    String fileName = getFileName(response, fileUrl);

                    // 注意: 不要在这里关闭流，调用者需要负责关闭
                    return new FileData(fileName, inputStream);
                } else {
                    throw new IOException("No content available from URL: " + fileUrl);
                }
            }
        }
    }

    private static String getFileName(CloseableHttpResponse response, String fileUrl) {
        // 1. 尝试从 Content-Disposition 头获取文件名
        String contentDisposition = response.getFirstHeader("Content-Disposition").getValue();
        if (contentDisposition != null && contentDisposition.contains("filename=")) {
            String[] parts = contentDisposition.split("filename=");
            if (parts.length > 1) {
                return parts[1].replace("\"", "").trim();
            }
        }

        // 2. 从 URL 路径中提取文件名
        String path = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
        // 移除可能的查询参数
        int queryIndex = path.indexOf('?');
        return queryIndex > 0 ? path.substring(0, queryIndex) : path;
    }

    public static class FileData {
        private final String fileName;
        private final InputStream inputStream;

        public FileData(String fileName, InputStream inputStream) {
            this.fileName = fileName;
            this.inputStream = inputStream;
        }

        public String getFileName() {
            return fileName;
        }

        public InputStream getInputStream() {
            return inputStream;
        }
    }
}
