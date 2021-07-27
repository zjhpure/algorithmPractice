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
        // 动态规划法，定义数组保存以nums[i]结尾的最长递增子序列长度，以nums[i]结尾的最长递增子序列长度，从以nums[i-i]结尾的的最长递增子序列长度算出

        if (nums.length == 0) {
            // 如果数组nums的长度为0，最长递增子序列的长度为0
            return 0;
        }

        // 定义数组dp，长度为数组nums的长度，记录以nums[i]结尾的最长递增子序列长度
        int[] dp = new int[nums.length];

        // 数组dp的第1个元素为1，因为以nums[0]结尾的最长递增子序列长度是1
        dp[0] = 1;

        // 定义最长递增子序列的长度，初始为1
        int maxLength = 1;

        // 遍历数组nums的元素，从1遍历到数组长度-1，计算以nums[0]结尾的最长递增子序列长度，至以nums[nums.length-1]结尾的的最长递增子序列长度
        for (int i = 1; i < nums.length; ++i) {
            // 以nums[i]结尾的最长递增子序列长度初始为1
            dp[i] = 1;

            // 从数组nums的第1个元素遍历到第i个元素
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    // 若当前元素大于前面的元素，那么符合递增，以nums[j]结尾的最长递增子序列长度加1，和以nums[i]结尾的最长递增子序列长度比较，取较大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // dp[i]是以nums[i]结尾的最长递增子序列长度，如果第i+1个元素不大于前面的任何元素，那么dp[i]是初始的1不变，最长递增子序列长度和以nums[i-1]结尾时一样，并不会影响到计算最长递增子序列的长度，因为dp[i] = Math.max(dp[i], dp[j] + 1)，会取较大值

            // 更新最长递增子序列的长度，比较每次以nums[i]结尾的最长递增子序列长度，找出最大值
            maxLength = Math.max(maxLength, dp[i]);
        }

        // 返回最长递增子序列的长度
        return maxLength;
    }

}
