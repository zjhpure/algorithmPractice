package org.pure.algorithm.maximizeSumOfArrayAfterKNegations;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 12/3/21 10:14 PM
 * @description K次取反后最大化的数组和
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
        int result = largestSumAfterKNegations(nums, k);
        System.out.println(result);
    }

    private static int largestSumAfterKNegations(int[] nums, int k) {
        // 排序+暴力

        // 对数组排序
        Arrays.sort(nums);

        // 定义最大和
        int maxSum = 0;

        // 处理k次取反，每次都是取反当前最小值
        for (int i = 1; i <= k; ++i) {
            // 每次只对当前最小值取反
            nums[0] = nums[0] * -1;
            // 取反后马上对数组再排序
            Arrays.sort(nums);
        }

        // 遍历处理好后的数组，累加得到最大和
        for (int num : nums) {
            maxSum += num;
        }

        // 返回最大和
        return maxSum;
    }

}
