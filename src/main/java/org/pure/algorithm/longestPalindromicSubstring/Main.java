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
        String result = longestPalindrome(s);
        System.out.println(result);
    }

//    // 方法1，三个for循环，超出时间限制，不建议使用
//    private static String longestPalindrome(String s) {
//        if (s.length() == 1) {
//            // 若字符串s为单个字符，直接返回本身
//            return s;
//        }
//
//        // 最长回文子串
//        String maxStr = "";
//
//        // 回文子串最大长度
//        int maxSize = 1;
//
//        // 遍历字符串s
//        for (int i = 0; i < s.length(); ++i) {
//            for (int j = i + 1; j < s.length(); ++j) {
//                // 构造子串
//                String str = s.substring(i, j + 1);
//
//                // 是否为回文串
//                boolean isPalindrome = true;
//
//                // 获取字串长度
//                int length = str.length();
//
//                // 遍历字串字符到一半
//                for (int n = 0; n < length / 2; ++n) {
//                    // 当前字符
//                    char a = str.charAt(n);
//
//                    // 交叉位置的字符
//                    char b = str.charAt(length - n - 1);
//
//                    if (a != b) {
//                        // 若两个字符不等，则字串不是回文串
//                        isPalindrome = false;
//                        break;
//                    }
//                }
//
//                // 判断字符串是否为回文串
//                if (isPalindrome) {
//                    // 获取回文子串长度
//                    int size = j - i + 1;
//
//                    if (size > maxSize) {
//                        // 更新回文子串最大长度
//                        maxSize = size;
//                        // 更新最长回文子串
//                        maxStr = str;
//                    }
//                }
//            }
//        }
//
//        if (maxSize == 1) {
//            // 若回文子串最大长度还是1，那么回文子串就是一个字符，则取第1个字符
//            maxStr = s.substring(0, 1);
//        }
//
//        return maxStr;
//    }

    // 方法2，动态规划法，不超出时间限制
    private static String longestPalindrome(String s) {
        // 动态规划法

        int len = s.length();

        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j]表示s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];

        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由L和i可以确定右边界，即j - i + 1 = L得
                int j = L + i - 1;

                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要dp[i][L] == true 成立，就表示子串s[i..L]是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

}
