package org.pure.algorithm.peakIndexInAMountainArray;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-15 08:31
 * @description 山脉数组的峰顶索引
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
        int result = peakIndexInMountainArray(nums);
        System.out.println(result);
    }

    private static int peakIndexInMountainArray(int[] arr) {
        // 本题可归结为查找数组的最大值，因为山脉数组要从小到大再从大到小，峰顶值刚好就是数组的最大值

        // 定义峰顶索引，初始值为0
        int index = 0;
        // 定义峰顶元素，初始值为第一个元素
        int max = arr[0];

        // 遍历山脉数组，查找最大值，保存最大值的索引
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > max) {
                index = i;
                max = arr[i];
            }
        }

        return index;
    }

}
