package org.wanbang.study.medianFinderTest;

import java.io.*;
import java.util.*;

public class MedianFinder {

    private static final long TOTAL_NUMBERS = 100_0000_0000L; // 100亿
    private static final int MEMORY_LIMIT = 512 * 1024 * 1024; // 512MB
    private static final int UNSIGNED_INT_RANGE = 1 << 16; // 使用16位分桶(可根据内存调整)

    public static long findMedian(String inputFile) throws IOException {
        // 第一阶段：统计各区间计数
        long[] rangeCounts = new long[UNSIGNED_INT_RANGE];
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                long num = Long.parseLong(line.trim());
                int range = (int)(num / ((1L << 32) / UNSIGNED_INT_RANGE));
                rangeCounts[range]++;
            }
        }

        // 确定中位数所在的区间
        long accumulated = 0;
        int medianRange = 0;
        for (; medianRange < rangeCounts.length; medianRange++) {
            accumulated += rangeCounts[medianRange];
            if (accumulated >= TOTAL_NUMBERS / 2) {
                break;
            }
        }

        // 计算区间范围
        long rangeStart = medianRange * ((1L << 32) / UNSIGNED_INT_RANGE);
        long rangeEnd = (medianRange + 1) * ((1L << 32) / UNSIGNED_INT_RANGE);

        // 第二阶段：收集该区间内的所有数字并排序
        List<Long> numbersInRange = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                long num = Long.parseLong(line.trim());
                if (num >= rangeStart && num < rangeEnd) {
                    numbersInRange.add(num);
                    // 如果内存快满，可以先部分排序并写入临时文件
                    if (numbersInRange.size() > 10_000_000) {
                        Collections.sort(numbersInRange);
                        // 写入临时文件(实际实现中需要处理)
                        numbersInRange.clear();
                    }
                }
            }
        }

        // 排序并找到中位数
        Collections.sort(numbersInRange);
        long offset = (TOTAL_NUMBERS / 2) - (accumulated - rangeCounts[medianRange]);
        return numbersInRange.get((int)offset);
    }

    public static void main(String[] args) throws IOException {
        // 假设输入文件每行一个数字
        String inputFile = "numbers.txt";
        long median = findMedian(inputFile);
        System.out.println("Median is: " + median);
    }
}
