package org.pure.algorithm.kthLargestElementInAnArray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-27 13:06
 * @description 数组中的第K个最大元素
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = findKthLargest(nums, k);
        System.out.println(result);
    }

    private static int findKthLargest(int[] nums, int k) {
        // 对数组排序，用系统提供的sort方法排序
        Arrays.sort(nums);
        // 取倒数第k个数，因为前面排序后是从小到大的，这里通过数组长度-k得到第k个数的索引
        return nums[nums.length - k];
    }

}
