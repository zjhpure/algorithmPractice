package org.pure.algorithm.findPivotIndex;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-29 01:16
 * @description 寻找数组的中心索引
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
        int result = pivotIndex(nums);
        System.out.println(result);
    }

    private static int pivotIndex(int[] nums) {
        if (nums.length <= 1) {
            // 若整数数组nums的长度小于2，则没有中心索引，直接返回-1
            return -1;
        }

        // 中心索引左侧元素相加之和
        int preSum = 0;

        // 中心索引右侧元素相加之和
        int lastSum = 0;

        // 从nums的第2个元素开始遍历，构建初始的lastSum
        for (int i = 1; i < nums.length; ++i) {
            lastSum += nums[i];
        }

        // 遍历整数数组nums，preSum通过累加获取，lastSum通过累减获取
        for (int i = 0; i < nums.length; ++i) {
            if (i - 1 >= 0) {
                // 当索引i大于0时，开始累加获取preSum
                preSum += nums[i - 1];
            }

            if (i + 1 >= 2) {
                // 当索引i大于0时，开始累减获取lastSum
                lastSum -= nums[i];
            }

            if (preSum == lastSum) {
                // 若preSum等于lastSum，则找到了中心索引
                return i;
            }
        }

        // 遍历整数数组nums结束后还没有返回中心索引，则证明没有中心索引，返回-1
        return -1;
    }

}
