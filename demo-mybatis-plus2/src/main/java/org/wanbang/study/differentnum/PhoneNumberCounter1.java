package org.wanbang.study.differentnum;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import sun.nio.cs.ext.Big5;

import java.io.*;
import java.util.*;

/**
 *
 * 统计不同号码的个数（100MB内存限制下）
 * 在Java中，当内存限制为100MB时，统计大量不同号码的个数需要考虑内存效率。以下是几种解决方案：
 *
 * 1. 如果号码数量在200万以内：使用HashSet最简单直接
 * 2. 如果号码数量巨大但可接受近似结果：使用布隆过滤器
 * 3. 如果数据量极大且需要精确结果：使用外部排序方法
 * 4. 如果号码是数字且有固定模式：考虑位图法
 *
 */
public class PhoneNumberCounter1 {
    public static void main(String[] args) throws Exception {
        hashsetMethod();

        bloomFilterMethod();

        bufferFileMethod();

        bitMapMethod();
    }

    /**
     * 方案1：使用HashSet（适合号码数量较少的情况）
     */
    private static void hashsetMethod() {
        HashSet<String> uniqueNumbers = new HashSet<>();

        // 模拟数据输入
        String[] phoneNumbers = {"13800138000", "13900139000", "13800138000", /*...更多号码...*/};

        for (String number : phoneNumbers) {
            uniqueNumbers.add(number);
        }

        System.out.println("不同号码的个数: " + uniqueNumbers.size());
    }

    /**
     * 方案2：使用布隆过滤器（适合超大数量，允许少量误判）
     */
    private static void bloomFilterMethod() {
        // 预计元素数量1000万，误判率1%
        BloomFilter<CharSequence> filter = BloomFilter.create(
                Funnels.stringFunnel(new Big5()),
                10_000_000,
                0.01);
        int uniqueCount = 0;

        // 模拟数据输入
        String[] phoneNumbers = {"13800138000", "13900139000", "13800138000", /*...更多号码...*/};

        for (String number : phoneNumbers) {
            if (!filter.mightContain(number)) {
                filter.put(number);
                uniqueCount++;
            }
        }

        System.out.println("不同号码的估计个数: " + uniqueCount);
    }

    /**
     * 方案3：外部排序+遍历计数（适合超大数据集）
     *
     * @throws Exception
     */
    private static void bufferFileMethod()throws Exception {
        File tempFile = File.createTempFile("phoneNumbers", ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        // 模拟写入号码数据
        String[] phoneNumbers = {/*...号码数据...*/};
        for (String number : phoneNumbers) {
            writer.write(number);
            writer.newLine();
        }
        writer.close();

        // 2. 外部排序
        List<String> sortedNumbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        String line;
        while ((line = reader.readLine()) != null) {
            sortedNumbers.add(line);
        }
        reader.close();
        Collections.sort(sortedNumbers);

        // 3. 遍历计数
        int uniqueCount = 0;
        String prevNumber = null;
        for (String number : sortedNumbers) {
            if (!number.equals(prevNumber)) {
                uniqueCount++;
                prevNumber = number;
            }
        }

        System.out.println("不同号码的个数: " + uniqueCount);
        tempFile.delete();
    }

    /**
     * 方案4：使用位图法（适合数字型号码且范围有限）
     */
    private static void bitMapMethod() {
        // 假设号码是11位数字，且前三位固定（如138,139等）
        // 我们只处理后8位，范围0-99,999,999
        BitSet bitSet = new BitSet(100_000_000);

        // 模拟号码数据（只取后8位）
        String[] phoneNumbers = {"13800138000", "13900139000", "13800138001"};

        for (String number : phoneNumbers) {
            int last8Digits = Integer.parseInt(number.substring(3));
            bitSet.set(last8Digits);
        }

        System.out.println("不同号码的个数: " + bitSet.cardinality());
    }
}
