package org.pure.algorithm.minOperationsToMakeTheArrayIncreasing;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-10 21:59
 * @description 最少操作使数组递增
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
        int result = minOperations(nums);
        System.out.println(result);
    }

    private static int minOperations(int[] nums) {
        // 定义最少操作次数
        int minCount = 0;

        // 从数组的第一个元素开始遍历，到数组的最后一个元素
        for (int i = 1; i < nums.length; ++i) {
            // 若当前元素小于等于前一个元素，开始进行操作，使得当前元素大于前一个元素
            if (nums[i] - nums[i - 1] <= 0) {
                // 获取这次要操作的次数，因为一次只能加1，所以差值加1就是这次要操作的次数
                int time = nums[i - 1] - nums[i] + 1;

                // 最少操作次数累加这次要操作的次数
                minCount += time;

                // 当前元素更新为被操作后的数字
                nums[i] += time;
            }
        }

        // 返回最少操作次数
        return minCount;
    }
}
