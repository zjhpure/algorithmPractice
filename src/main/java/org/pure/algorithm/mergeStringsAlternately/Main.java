package org.pure.algorithm.mergeStringsAlternately;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-17 21:03
 * @description 交替合并字符串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        String result = mergeAlternately(str1, str2);
        System.out.println(result);
    }

    private static String mergeAlternately(String word1, String word2) {
        // 定义字符串集合
        StringBuilder sb = new StringBuilder();

        // 定义短字符串的长度
        int length = Math.min(word1.length(), word2.length());

        // 遍历字符串的字符，交替取word1和word2的字符，长度为短字符串的长度
        for (int i = 0; i < length; ++i) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        // 取剩下字符串的字符
        if (word1.length() > word2.length()) {
            // 若word1为长字符串，取word1剩下的字符
            for (int i = length; i < word1.length(); ++i) {
                sb.append(word1.charAt(i));
            }
        } else {
            // 若word2为长字符串，取word2剩下的字符
            for (int i = length; i < word2.length(); ++i) {
                sb.append(word2.charAt(i));
            }
        }

        // 字符串集合转为字符串
        return sb.toString();
    }

}
