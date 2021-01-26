package org.pure.algorithm.palindromePermutation;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-26 23:13
 * @description 回文排列
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        // 获取输出结果
        boolean rs = canPermutePalindrome(s);
        System.out.println(rs);
    }

    private static boolean canPermutePalindrome(String s) {
        // 字符串长度
        int size = s.length();

        // 单个字符出现次数
        int singleTime = 0;

        while (s.length() > 0) {
            // 获取字符串的第一个字符
            char c = s.charAt(0);

            // 获取出现字符c的第一个索引
            int i = s.indexOf(c);

            // 获取去掉一个字符c后的字符串
            s = s.substring(0, i) + s.substring(i + 1);

            // 获取出现字符c的第二个索引
            int n = s.indexOf(c);

            if (n > -1) {
                // 若存在第二个字符c，获取去掉两个字符c后的字符串
                s = s.substring(0, n) + s.substring(n + 1);
            } else {
                // 若不存在第二个字符c，单个字符出现次数自增1
                ++singleTime;

                if (size % 2 == 0) {
                    // 若字符串长度为偶数，字符必须成对出现才能构成回文串
                    return false;
                } else {
                    // 若字符串长度为奇数，必须要出现一个单独的字符
                    if (singleTime != 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
