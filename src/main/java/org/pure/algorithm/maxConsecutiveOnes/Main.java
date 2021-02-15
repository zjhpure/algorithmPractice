package org.pure.algorithm.maxConsecutiveOnes;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-15 13:55
 * @description 最大连续1的个数
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
        int result = findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        // 定义最大个数
        int max = 0;

        // 定义连续1的个数
        int count = 0;

        // 遍历数组nums
        for (int num : nums) {
            if (num == 1) {
                // 连续1的个数加1
                ++count;

                if (count > max) {
                    // 更新最大个数
                    max = count;
                }
            } else {
                // 连续1的个数重置为0
                count = 0;
            }
        }

        return max;
    }

}
