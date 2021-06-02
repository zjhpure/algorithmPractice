package org.pure.algorithm.continuousSubarraySum;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-02 08:14
 * @description 连续的子数组和
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        boolean result = checkSubarraySum(nums, k);
        System.out.println(result);
    }

    private static boolean checkSubarraySum(int[] nums, int k) {
        // 定义连续子数组总和
        int sum;

        // 第一轮遍历数组nums的元素，从0到倒数第2个
        for (int i = 0; i < nums.length - 1; ++i) {
            // 初始化连续子数组总和
            sum = nums[i];

            // 第二轮遍历数组nums的元素，从上一轮的下一个到倒数第1个
            for (int j = i + 1; j < nums.length; ++j) {
                // 累加计算连续子数组的总和
                sum += nums[j];

                if (sum % k == 0) {
                    // 若连续子数组总和对k求余等于0，那么总和就是k的倍数，那么就是找到了符合条件的连续子数组
                    return true;
                }
            }
        }

        // 若两轮遍历完都没有找到符合条件的连续子数组，那么就是不存在这样的连续子数组
        return false;
    }

}
