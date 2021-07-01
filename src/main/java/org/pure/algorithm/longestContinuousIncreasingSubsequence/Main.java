package org.pure.algorithm.longestContinuousIncreasingSubsequence;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-01 21:59
 * @description 最长连续递增序列
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = findLengthOfLCIS(nums);
        System.out.println(result);
    }

    private static int findLengthOfLCIS(int[] nums) {
        // 定义最大长度
        int max = 0;
        // 定义连续递增子序列长度
        int count = 0;

        // 遍历数组nums的元素
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                // 若是第一个元素，连续递增子序列长度加1
                ++count;
            } else {
                if (nums[i] > nums[i - 1]) {
                    // 若当前元素大于前一个元素，那么是递增子序列，连续递增子序列长度加1
                    ++count;
                } else {
                    // 若当前元素小于等于前一个元素，那么不是递增子序列了
                    if (count > max) {
                        // 更新最大长度
                        max = count;
                    }
                    // 重置连续递增子序列长度为1，自己本身一个数就算作长度1
                    count = 1;
                }
            }
        }

        if (count > max) {
            // 最后再更新最大长度
            max = count;
        }

        // 返回最大长度
        return max;
    }

}
