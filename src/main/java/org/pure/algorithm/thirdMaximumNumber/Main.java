package org.pure.algorithm.thirdMaximumNumber;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-02 23:10
 * @description 第三大的数
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
        int result = thirdMax(nums);
        System.out.println(result);
    }

    private static int thirdMax(int[] nums) {
        // 三次遍历，先找出第一大的数，再找出第二大的数，最后找出第三大的数，时间复杂度O(3n)，O(3n)=O(n)

        // 定义第一大的数
        int first = -2147483648;

        // 第一次遍历数组nums，找出第一大的数
        for (int num : nums) {
            if (num >= first) {
                first = num;
            }
        }

        // 定义第二大的数
        int second = -2147483648;

        // 第二次遍历数组nums，找出第二大的数
        for (int num : nums) {
            if (num >= second && num < first) {
                second = num;
            }
        }

        // 定义第三大的数
        int third = -2147483648;

        // 是否找到第三大的数
        boolean isFind = false;

        // 第三次遍历数组nums，找出第三大的数
        for (int num : nums) {
            if (num >= third && num < second) {
                third = num;
                isFind = true;
            }
        }

        if (isFind) {
            // 若找到第三大的数，返回第三大的数
            return third;
        } else {
            // 若没有找到第三大的数，返回第一大的数
            return first;
        }
    }

}
