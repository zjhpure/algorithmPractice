package org.pure.algorithm.maximumSubarray;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-18 22:37
 * @description 最大子序和
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
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    private static int maxSubArray(int[] nums) {
        // 定义初始最大和，用数组nums的第一个元素作为初始最大和
        int res = nums[0];

        // 定义计算过程的最大和
        int sum = 0;

        // 遍历数组nums
        // 逐个元素叠加出sum值，当sum小于等于0时，重置sum为当前元素，因为前面部分的和为0，计算总和时等于0加当前元素，即为当前元素
        for (int num : nums) {
            if (sum > 0) {
                // 若sum大于0，继续叠加
                sum += num;
            } else {
                // 若sum小于等于0，重置sum为当前元素
                sum = num;
            }

            if (sum > res) {
                // 更新最大和
                res = sum;
            }
        }

        return res;
    }

}
