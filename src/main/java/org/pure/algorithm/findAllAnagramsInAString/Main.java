package org.pure.algorithm.findAllAnagramsInAString;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 11/28/21 11:28 AM
 * @description 找到字符串中所有字母异位词
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result);
    }

    private static List<Integer> findAnagrams(String s, String p) {
        // 计数排序法

        // 定义列表，保存结果
        List<Integer> list = new ArrayList<>();

        if (p.length() > s.length()) {
            // 若字符串p的长度大于字符串s的长度，不能存在异位词，直接返回空列表
            return list;
        }

        // 定义长度为26的数组，保存字符串p中每个字符的个数
        int[] pCount = new int[26];

        // 遍历字符串p的字符
        for (int i = 0; i < p.length(); ++i) {
            // 计数排序统计各个字符的个数
            ++pCount[p.charAt(i) - 'a'];
        }

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            // 获取结束索引加1
            int endIndex = i + p.length();

            // 若结束索引加1小于等于字符串s的长度，那么进行异位词的判断
            if (endIndex <= s.length()) {
                // 获取起始索引
                int j = i;

                // 定义长度为26的数组，保存从起始索引到结束索引的每个字符的个数
                int[] sCount = new int[26];

                // 从起始索引的字符遍历到结束索引的字符
                while (j < endIndex) {
                    // 计数排序统计各个字符的个数
                    ++sCount[s.charAt(j) - 'a'];
                    ++j;
                }

                if (Arrays.equals(pCount, sCount)) {
                    // 若两个计数排序的数组相等，那么符合异位词的条件，添加起始索引到列表
                    list.add(i);
                }
            }
        }

        // 返回结果
        return list;
    }

}
