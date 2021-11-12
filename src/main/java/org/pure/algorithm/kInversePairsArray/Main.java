package org.pure.algorithm.kInversePairsArray;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-11 21:45
 * @description K个逆序对数组
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String k = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = kInversePairs(Integer.parseInt(n), Integer.parseInt(k));
        System.out.println(result);
    }

    private static int kInversePairs(int n, int k) {
        // 动态规划，待理解原理

        // 定义模
        int mod = 1000000007;

        // 定义二维数组n * (k + 1)
        int[][] dp = new int[n][k + 1];

        // dp初始化
        for (int i = 0; i < n; ++i) {
            dp[i][0] = 1;
        }

        // 从1遍历到n - 1
        for (int i = 1; i < n; ++i) {
            // 从1遍历到k
            for (int j = 1; j <= k; ++j) {
                // 获取二维数组当前值
                long sum = dp[i][j];

                // 从0遍历到i和j中最小值
                for (int w = 0; w <= i && w <= j; ++w) {
                    // 累加
                    sum += dp[i - 1][j - w];
                }

                // 取模，更新到二维数组
                dp[i][j] = (int) (sum % mod);
            }
        }

        // 返回二维数组最后一行最后一列的值
        return dp[n - 1][k];
    }

}
