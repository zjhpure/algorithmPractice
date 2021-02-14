package org.pure.algorithm.longestPalindromicSubstring;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-13 22:13
 * @description 最长回文子串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = longestPalindrome2(s);
        System.out.println(result);
    }

    // 方法2，三个for循环，超出时间限制，不建议使用
    private static String longestPalindrome2(String s) {
        if (s.length() == 1) {
            // 若字符串s为单个字符，直接返回本身
            return s;
        }

        // 最长回文子串
        String maxStr = "";

        // 回文子串最大长度
        int maxSize = 1;

        // 遍历字符串s
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i + 1; j < s.length(); ++j) {
                // 构造子串
                String str = s.substring(i, j + 1);

                // 是否为回文串
                boolean isPalindrome = true;

                // 获取字串长度
                int length = str.length();

                // 遍历字串字符到一半
                for (int n = 0; n < length / 2; ++n) {
                    // 当前字符
                    char a = str.charAt(n);

                    // 交叉位置的字符
                    char b = str.charAt(length - n - 1);

                    if (a != b) {
                        // 若两个字符不等，则字串不是回文串
                        isPalindrome = false;
                        break;
                    }
                }

                // 判断字符串是否为回文串
                if (isPalindrome) {
                    // 获取回文子串长度
                    int size = j - i + 1;

                    if (size > maxSize) {
                        // 更新回文子串最大长度
                        maxSize = size;
                        // 更新最长回文子串
                        maxStr = str;
                    }
                }
            }
        }

        if (maxSize == 1) {
            // 若回文子串最大长度还是1，那么回文子串就是一个字符，则取第1个字符
            maxStr = s.substring(0, 1);
        }

        return maxStr;
    }

}
