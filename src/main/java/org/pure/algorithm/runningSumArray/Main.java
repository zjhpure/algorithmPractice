package org.pure.algorithm.runningSumArray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-07 12:48
 * @description 一维数组的动态和
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
        int[] results = runningSum(nums);
        System.out.println(Arrays.toString(results));
    }

    private static int[] runningSum(int[] nums) {
        // 定义总和
        int sum = 0;

        // 定义结果数组
        int[] results = new int[nums.length];

        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            // 逐个叠加
            sum += nums[i];
            // 叠加结果放入结果数组中
            results[i] = sum;
        }

        return results;
    }

}
