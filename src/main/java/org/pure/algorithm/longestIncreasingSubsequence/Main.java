package org.pure.algorithm.longestIncreasingSubsequence;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-27 19:09
 * @description 最长递增子序列
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = lengthOfLIS(nums);
        System.out.println(result);
    }

    private static int lengthOfLIS(int[] nums) {
        // 动态规划法，定义数组保存前n个元素的最长递增子序列长度，前n+1个元素的最长递增子序列长度从前n个元素的最长递增子序列长度算出

        if (nums.length == 0) {
            // 如果数组nums的长度为0，最长递增子序列的长度为0
            return 0;
        }

        // 定义数组dp，长度为数组nums的长度，记录当前长度元素的最长递增子序列长度
        int[] dp = new int[nums.length];

        // 数组dp的第一个元素为1，因为前1个元素的最长递增子序列长度是1
        dp[0] = 1;

        // 定义最长递增子序列的长度，初始为1
        int maxLength = 1;

        // 遍历数组nums的元素，从1遍历到数组长度-1，计算前2个元素的最长递增子序列长度至前数组长度个元素的最长递增子序列长度
        for (int i = 1; i < nums.length; ++i) {
            // 前i+1个元素的最长递增子序列长度初始为1
            dp[i] = 1;

            // 从数组nums的第1个元素遍历到第i个元素
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    // 若当前元素大于前面的元素，那么符合递增，前j+1个元素的最长递增子序列长度加1，和前i+1个元素的最长递增子序列长度比较，取较大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // dp[i]是前i+1个元素的最长递增子序列长度，如果第i+1个元素不大于前面的任何元素，那么dp[i]是初始的1不变，不是前i+1个元素的最长递增子序列长度，但不会影响到计算最长递增子序列的长度，因为dp[i] = Math.max(dp[i], dp[j] + 1)，取得的是较大值

            // 更新最长递增子序列的长度，比较每次前n个元素的最长递增子序列长度，找出最大值
            maxLength = Math.max(maxLength, dp[i]);
        }

        // 返回最长递增子序列的长度
        return maxLength;
    }

}
