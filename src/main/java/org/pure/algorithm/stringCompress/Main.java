package org.pure.algorithm.stringCompress;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-23 23:54
 * @description 字符串压缩
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = compressString(str);
        System.out.println(result);
    }

    private static String compressString(String S) {
        // 定义压缩后的字符串集合
        StringBuilder sb = new StringBuilder();

        // 字符重复个数
        int num = 1;

        // 字符串长度
        int size = S.length();

        if (size == 1) {
            // 若字符串长度为1，返回原字符串
            return S;
        }

        // 遍历字符串
        for (int i = 0; i < size; ++i) {
            // 获取当前字符
            char c = S.charAt(i);

            // 第一位置的字符
            if (i == 0) {
                // 添加第一个字符
                sb.append(c);

                // 获取下一个字符
                char cNext = S.charAt(i + 1);

                if (c != cNext) {
                    // 若当前字符和下一个字符不同，那么进行字符重复个数结算
                    sb.append(num);

                    // 重置字符重复个数
                    num = 1;
                }

                continue;
            }

            // 最后位置的字符
            if (i == size - 1) {
                // 获取上一个字符
                char cPre = S.charAt(i - 1);

                if (c == cPre) {
                    // 当前字符和前一个字符相同
                    ++num;
                    sb.append(num);
                } else {
                    // 当前字符和前一个字符不同
                    sb.append(c);
                    sb.append(1);
                }

                continue;
            }

            // 中间位置的字符

            // 获取上一个字符
            char cPre = S.charAt(i - 1);

            if (c == cPre) {
                // 当前字符和前一个字符相同
                ++num;
            } else {
                // 当前字符和前一个字符不同
                sb.append(c);
            }

            // 获取下一个字符
            char cNext = S.charAt(i + 1);

            if (c != cNext) {
                // 若当前字符和下一个字符不同，那么进行字符重复个数结算
                sb.append(num);

                // 重置字符重复个数
                num = 1;
            }
        }

        // 获取压缩后的字符串
        String str = sb.toString();

        if (str.length() < S.length()) {
            // 若压缩后的字符串长度变短了，返回压缩后的字符串
            return str;
        } else {
            // 若压缩后的字符串长度没有变短，返回原字符串
            return S;
        }
    }

}
