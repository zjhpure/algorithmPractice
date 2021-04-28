package org.pure.algorithm.magicIndex;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-28 08:05
 * @description 魔术索引
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
        int result = findMagicIndex(nums);
        System.out.println(result);
    }

    private static int findMagicIndex(int[] nums) {
        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            if (i == nums[i]) {
                // 若索引等于索引下的数组元素值，那就是魔术索引
                return i;
            }
        }

        // 如果没有找到索引等于索引下的数组元素值的索引，那么返回-1
        return -1;
    }

}
