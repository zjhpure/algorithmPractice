package org.pure.algorithm.contiguousSequence;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-01 22:40
 * @description 连续数列
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
        // 定义最大总和，初始最大总和为int类型的最小值
        int max = -2147483648;

        // 定义总和
        int sum = 0;

        // 遍历数组nums
        for (int num : nums) {
            // 累加计算当前总和
            sum += num;

            if (sum > max) {
                // 如果当前总和大于最大总和，最大总和更新为当前总和
                max = sum;
            }

            if (sum < 0) {
                // 如果当前总和已经小于0，重置当前总和为0，因为如果当前总和小于0，假如后面的连续数列得到最大总和，因为前面连续数列是负数，如果加上前面连续数列，肯定是变小的，所以最大总和的连续数列肯定是从前面连续数列为负数的下一个元素开始的连续数列，那么这里就应该把总和重置为0，因为后面的总和计算从下一个元素开始了
                sum = 0;
            }
        }

        // 返回最大总和
        return max;
    }

}
