package org.wanbang.study.urlIntersectionFinderTest;

import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class URLIntersectionFinder {
    private static final int NUM_OF_SHARDS = 1000; // 分片数量
    private static final String SHARD_PREFIX_A = "a_";
    private static final String SHARD_PREFIX_B = "b_";
    private static final String OUTPUT_FILE = "common_urls.txt";

    public static void main(String[] args) throws IOException {
        String fileA = "a.txt"; // 文件A路径
        String fileB = "b.txt"; // 文件B路径

        // 第一步：分片处理
        shardFiles(fileA, SHARD_PREFIX_A);
        shardFiles(fileB, SHARD_PREFIX_B);

        // 第二步：逐对处理小文件并找出共同URL
        findCommonURLs();

        System.out.println("处理完成，共同URL已保存到 " + OUTPUT_FILE);
    }

    /**
     * 分片处理文件
     *
     * @param inputFile
     * @param shardPrefix
     * @throws IOException
     */
    private static void shardFiles(String inputFile, String shardPrefix) throws IOException {
        // 初始化分片写入器
        BufferedWriter[] shardWriters = new BufferedWriter[NUM_OF_SHARDS];
        for (int i = 0; i < NUM_OF_SHARDS; i++) {
            shardWriters[i] = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(shardPrefix + i + ".txt"), StandardCharsets.UTF_8));}

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8))) {
            String url;
            while ((url = reader.readLine()) != null) {
                // 计算哈希值确定分片
                int shardIndex = Math.abs(url.hashCode() % NUM_OF_SHARDS);
                shardWriters[shardIndex].write(url);
                shardWriters[shardIndex].newLine();
            }
        }

        // 关闭所有分片写入器
        for (BufferedWriter writer : shardWriters) {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * 找出共同URL
     *
     * @throws IOException
     */
    private static void findCommonURLs() throws IOException {
        try (BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE), StandardCharsets.UTF_8))) {
            for (int i = 0; i < NUM_OF_SHARDS; i++) {
                String shardA = SHARD_PREFIX_A + i + ".txt";
                String shardB = SHARD_PREFIX_B + i + ".txt";

                // 读取A分片的URL到内存
                Set<String> urlsInA = new HashSet<>();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(shardA), StandardCharsets.UTF_8))) {
                    String url;
                    while ((url = reader.readLine()) != null) {
                        urlsInA.add(url);
                    }
                }

                // 检查B分片中是否存在相同的URL
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(shardB), StandardCharsets.UTF_8))) {
                    String url;
                    while ((url = reader.readLine()) != null) {
                        if (urlsInA.contains(url)) {
                            outputWriter.write(url);
                            outputWriter.newLine();
                        }
                    }
                }

                // 删除临时分片文件以节省空间
                new File(shardA).delete();
                new File(shardB).delete();
            }
        }
    }
}
