package org.pure.algorithm.findPeakElement;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-15 22:49
 * @description 寻找峰值
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
        int result = findPeakElement(nums);
        System.out.println(result);
    }

    // 方法1，枚举法，寻找最大值的下标
    private static int findPeakElement(int[] nums) {
        // 寻找数组最大值的下标，因为nums[i] != nums[i + 1]，所以数组最大值的下标是一个可行的峰值的下标

        // 定义数组最大值的下标
        int maxIndex = 0;

        // 从数组的第二个元素开始遍历到最后一个元素，寻找数组最大值的下标
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                maxIndex = i;
            }
        }

        // 返回数组最大值的下标
        return maxIndex;
    }
}
