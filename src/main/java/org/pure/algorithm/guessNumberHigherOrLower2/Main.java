package org.pure.algorithm.guessNumberHigherOrLower2;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-12 22:07
 * @description 猜数字大小II
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = getMoneyAmount(n);
        System.out.println(result);
    }

    private static int getMoneyAmount(int n) {
        // 动态规划法，待理解原理

        int[][] f = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 1; --i) {
            for (int j = i + 1; j <= n; ++j) {
                int minCost = Integer.MAX_VALUE;

                for (int k = i; k < j; ++k) {
                    int cost = k + Math.max(f[i][k - 1], f[k + 1][j]);
                    minCost = Math.min(minCost, cost);
                }

                f[i][j] = minCost;
            }
        }
        return f[1][n];
    }

}
