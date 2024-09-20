package org.wanbang.config;

//import cn.hutool.json.JSONUtil;
//import lombok.extern.slf4j.Slf4j;
//import okhttp3.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocketFactory;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//import javax.validation.constraints.NotNull;
//import java.io.IOException;
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.util.concurrent.TimeUnit;

/**
 * @Author: majiajian
 * @CreateTime: 2024-09-19 11:17
 * @Description:
 */
//@Slf4j
//@Configuration
public class OriginalOkHttpConfig {

//    private static final int DEFAULT_CONNECT_TIMEOUT = 30;
//    private static final int DEFAULT_READ_TIMEOUT = 30;
//    private static final int DEFAULT_WRITE_TIMEOUT = 30;
//
//    @Bean(name = "originalX509TrustManager")
//    public X509TrustManager x509TrustManager() {
//        return new X509TrustManager() {
//            @Override
//            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
//            }
//
//            @Override
//            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
//            }
//
//            @Override
//            public X509Certificate[] getAcceptedIssuers() {
//                return new X509Certificate[0];
//            }
//        };
//    }
//
//    /**
//     * ssl 配置
//     *
//     * @param originalX509TrustManager
//     * @return
//     */
//    @Bean(name = "originalSslSocketFactory")
//    public SSLSocketFactory sslSocketFactory(@Lazy X509TrustManager originalX509TrustManager) {
//        try {
//            //信任任何链接
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, new TrustManager[]{originalX509TrustManager}, new SecureRandom());
//            return sslContext.getSocketFactory();
//        } catch (NoSuchAlgorithmException | KeyManagementException e) {
//            log.error("异常信息", e);
//        }
//        return null;
//    }
//
//    /**
//     * 创建okHttp客户端
//     *
//     * @param originalSslSocketFactory
//     * @param originalX509TrustManager
//     * @return
//     */
//    @Bean(name = "originalOkHttpClient")
//    public OkHttpClient originalOkHttpClient(@Lazy SSLSocketFactory originalSslSocketFactory, @Lazy X509TrustManager originalX509TrustManager) {
//        ConnectionPool originalConnectionPool = new ConnectionPool(200, 5, TimeUnit.MINUTES);
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
//                .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS)
//                .writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)
//                .retryOnConnectionFailure(false)
//                .connectionPool(originalConnectionPool)
//                .sslSocketFactory(originalSslSocketFactory, originalX509TrustManager)
////                .addInterceptor(new RetryIntercepter(2))
//                .addInterceptor(new RequestIntercepter());
//        return builder.build();
//    }
//
//    /**
//     * @Author: majiajian
//     * @CreateTime: 2024/09/19 11:34
//     * @Description: 请求拦截器
//     */
//    public class RequestIntercepter implements Interceptor {
//
//        @NotNull
//        @Override
//        public Response intercept(@NotNull Chain chain) throws IOException {
//            Request originalRequest = chain.request();
//            Response response = chain.proceed(originalRequest);
//            log.debug("[okhttp]send originalRequest:{}, response:{}", JSONUtil.toJsonStr(originalRequest), JSONUtil.toJsonStr(response));
//            return response;
//        }
//
//    }
//
//    /**
//     * @Author: majiajian
//     * @CreateTime: 2024/09/19 11:34
//     * @Description: 重试拦截器
//     */
//    public class RetryIntercepter implements Interceptor {
//
//        /**
//         * 最大重试次数
//         */
//        private int maxRetry;
//        /**
//         * 假如设置为3次重试的话，则最大可能请求4次（默认1次+3次重试）
//         */
//        private int retryNum = 0;
//
//        public RetryIntercepter(int maxRetry) {
//            this.maxRetry = maxRetry;
//        }
//
//        /**
//         * 拦截器链配置
//         *
//         * @param chain
//         * @return
//         * @throws IOException
//         */
//        @NotNull
//        @Override
//        public Response intercept(@NotNull Chain chain) throws IOException {
//            Request request = chain.request();
//            System.out.println("retryNum=" + retryNum);
//            Response response = chain.proceed(request);
//            while (!response.isSuccessful() && retryNum < maxRetry) {
//                retryNum++;
//                System.out.println("retryNum=" + retryNum);
//                response = chain.proceed(request);
//            }
//            return response;
//        }
//    }

}

/**
 *
 *     <properties>
 *         <okhttp.version>3.14.9</okhttp.version>
 *         <discovery.version>2.2.8.RELEASE</discovery.version>
 *         <lang.version>3.11</lang.version>
 *     </properties>
 *          <!-- okhttp -->
 *         <dependency>
 *             <groupId>com.squareup.okhttp3</groupId>
 *             <artifactId>okhttp</artifactId>
 *             <version>${okhttp.version}</version>
 *         </dependency>
 *
 *         <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
 *             <version>${discovery.version}</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>org.apache.commons</groupId>
 *             <artifactId>commons-lang3</artifactId>
 *             <version>${lang.version}</version>
 *         </dependency>
 */