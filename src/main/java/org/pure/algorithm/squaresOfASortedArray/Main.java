package org.pure.algorithm.squaresOfASortedArray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-30 22:44
 * @description 有序数组的平方
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
        int[] result = sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] sortedSquares(int[] nums) {
        // 获取数组nums长度
        int n = nums.length;

        // 定义结果数组results
        int[] results = new int[n];

        // 用双指针遍历数组nums，从数组nums两边往里遍历，每次结果数组results只取大的数，结果数组results从后往前填满，直到两个指针游标相等
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                // 若前指针i的位置的元素的平方大于后指针j的位置的元素的平方，那么前指针i移动
                results[pos] = nums[i] * nums[i];
                ++i;
            } else {
                // 若前指针i的位置的元素的平方小于等于后指针j的位置的元素的平方，那么后指针j移动
                results[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }

        return results;
    }

}
