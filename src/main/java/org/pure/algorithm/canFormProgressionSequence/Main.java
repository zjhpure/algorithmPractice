package org.pure.algorithm.canFormProgressionSequence;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-11 21:59
 * @description 判断能否形成等差数列
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
        boolean result = canMakeArithmeticProgression(nums);
        System.out.println(result);
    }

    private static boolean canMakeArithmeticProgression(int[] arr) {
        // 先对数组arr进行冒泡排序
        // 需要进行排序的趟数刚好为数组arr的长度减1，每一趟排序找出当前的最大数，挪到对应的位置
        for (int i = 0; i < arr.length - 1; ++i) {
            // 每一趟排序时，不断比较当前元素和下一个元素谁大，把大的元素往后挪
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    // 若当前元素大于下一个元素，交换两个元素
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                }
            }
        }

        // 定义数列的初始差
        int dif = arr[1] - arr[0];

        // 遍历排序后的数组arr，从第3个元素开始遍历
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] - arr[i - 1] != dif) {
                // 若有两个相邻数的差不等于初始差，那么数组arr就不是等差数列
                return false;
            }
        }

        // 若遍历排序后的数组arr能遍历完，那么证明任意两个相邻数的差是相等的，数组arr是等差数列
        return true;
    }

}
