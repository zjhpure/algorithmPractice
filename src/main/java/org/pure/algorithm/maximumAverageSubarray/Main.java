package org.pure.algorithm.maximumAverageSubarray;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-16 22:37
 * @description 子数组最大平均数I
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
        double result = findMaxAverage(nums, k);
        System.out.println(result);
    }

    // 此方法超出时间限制，不建议使用
    private static double findMaxAverage(int[] nums, int k) {
        // 定义最大平均数
        double averageMax = -2147483648d;

        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            if (nums.length - i >= k) {
                // 若数组nums后面的长度大于等于k
                // 定义总和
                double sum = nums[i];

                // 计算连续子数组的总和
                for (int j = i + 1; j < i + k; ++j) {
                    sum += nums[j];
                }

                // 计算平均数
                double average = sum / k;

                if (average > averageMax) {
                    // 比较更新最大平均数
                    averageMax = average;
                }
            }
        }

        return averageMax;
    }

}
