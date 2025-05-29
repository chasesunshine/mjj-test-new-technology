package org.wanbang.study.topKFrequentWordsTest;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class TopKFrequentWords {
    private static final int MAX_MEMORY = 10 * 1024 * 1024; // 10MB
    private static final int BLOCK_SIZE = MAX_MEMORY / 2;   // 保守估计使用5MB每块

    public static List<Map.Entry<String, Integer>> findTopKFrequentWords(String filePath, int k) throws IOException {
        // 第一步：分割大文件为多个小文件并分别统计词频
        List<File> chunkFiles = splitAndCount(filePath);

        // 第二步：合并所有小文件的统计结果
        Map<String, Integer> globalCount = mergeCounts(chunkFiles);

        // 第三步：使用最小堆找出Top K
        return getTopK(globalCount, k);
    }

    private static List<File> splitAndCount(String filePath) throws IOException {
        List<File> chunkFiles = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        Map<String, Integer> wordCount = new HashMap<>();
        int currentSize = 0;
        int chunkIndex = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            // line是单词， 数据形式 （“aaa”,0+1）
            //                    （“bbb”,1+1）
            wordCount.put(line, wordCount.getOrDefault(line, 0) + 1);
            currentSize += line.length() + 16; // 保守估计内存占用

            if (currentSize >= BLOCK_SIZE) {
                // 将统计的数据写入到文件中，文件中的数据形式  aaa:1
                //                                    bbb:2
                File chunkFile = writeChunkToFile(wordCount, chunkIndex++);
                chunkFiles.add(chunkFile);
                wordCount.clear();
                currentSize = 0;
            }
        }

        // 写入最后一个块
        if (!wordCount.isEmpty()) {
            File chunkFile = writeChunkToFile(wordCount, chunkIndex);
            chunkFiles.add(chunkFile);
        }

        reader.close();
        return chunkFiles;
    }

    private static File writeChunkToFile(Map<String, Integer> wordCount, int index) throws IOException {
        File chunkFile = File.createTempFile("chunk_" + index, ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(chunkFile))) {
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        }
        return chunkFile;
    }

    private static Map<String, Integer> mergeCounts(List<File> chunkFiles) throws IOException {
        Map<String, Integer> globalCount = new HashMap<>();

        for (File chunkFile : chunkFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(chunkFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    String word = parts[0];
                    int count = Integer.parseInt(parts[1]);
                    globalCount.put(word, globalCount.getOrDefault(word, 0) + count);
                }
            }
            chunkFile.delete(); // 清理临时文件
        }

        return globalCount;
    }

    private static List<Map.Entry<String, Integer>> getTopK(Map<String, Integer> wordCount, int k) {
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            minHeap.offer(entry);
            // 这地方是一旦超过了 k ，就在队列中把最小的给弹出
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Map.Entry<String, Integer>> result = new ArrayList<>(minHeap);
        result.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return result;
    }


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("aaa",1);
        map.put("bbb",2);
        map.put("ccc",3);
        map.put("ddd",4);
        map.put("eee",5);
        map.put("fff",6);
        map.put("ggg",7);
        map.put("hhh",8);
        List<Map.Entry<String, Integer>> topK = getTopK(map, 5);
        System.out.println(JSON.toJSONString(topK));
    }
}
