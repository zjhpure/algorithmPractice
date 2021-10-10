package org.pure.algorithm.longestPalindromicSubsequence;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-10 17:58
 * @description 最长回文子序列
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int result = longestPalindromeSubseq(str);
        System.out.println(result);
    }

    private static int longestPalindromeSubseq(String s) {
        // 动态规划法，用i和j分别表示子序列的起始下标和结束下标，两边都是闭合区间，前面的子序列的回文子序列长度可以用来统计后面的子序列的回文子序列长度

        // 获取字符串s的长度
        int n = s.length();

        // 定义二维数组dp，行数和列数都是字符串s的长度，二维数组保存回文子序列的长度
        int[][] dp = new int[n][n];

        // 从n-1遍历到0，因为后面的回文子序列的长度是最小的，最长回文子序列长度是从0到最后一个字符，通过这里的递推，把前面统计出的回文子序列长度用来计算后面的回文子序列长度，最后就能计算出最长回文子序列长度，这个长度保存在二维数组第1行的最后1列
        for (int i = n - 1; i >= 0; --i) {
            // 二维数组相同行和列的值赋为1
            dp[i][i] = 1;

            // 获取字符串i下标的字符c1
            char c1 = s.charAt(i);

            // 从i+1遍历到n-1
            for (int j = i + 1; j < n; ++j) {
                // 获取字符串j下标的字符c2
                char c2 = s.charAt(j);

                if (c1 == c2) {
                    // 若c1等于c2，那么二维数组这行这列的值等于他的右上角元素，即行和列各自向中间移动1位
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 若c1不等于c2，那么二维数组这行这列的值等于他的右侧元素和上侧元素的最大值，即行向中间移动1位，或者列向中间移动1位，从这两者中取最大值
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // 返回二维数组dp的第1行最后1列，即为最长回文子序列的长度
        return dp[0][n - 1];
    }

}
