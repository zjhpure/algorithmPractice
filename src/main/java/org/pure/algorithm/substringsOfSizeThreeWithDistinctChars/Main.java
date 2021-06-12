package org.pure.algorithm.substringsOfSizeThreeWithDistinctChars;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-12 20:26
 * @description 长度为三且各字符不同的子字符串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int result = countGoodSubstrings(str);
        System.out.println(result);
    }

    private static int countGoodSubstrings(String s) {
        // 定义好子字符串的数量
        int count = 0;

        // 遍历字符串s的字符，从第1个字符遍历到倒数3个字符
        for (int i = 0; i < s.length() - 2; ++i) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2)) {
                // 遍历到的每一个字符，和后两个字符组成长度为3的子字符串，若这三个字符都不两两都相等，那么就是好子字符串，数量加1
                ++count;
            }
        }

        // 返回好子字符串的数量
        return count;
    }

}
