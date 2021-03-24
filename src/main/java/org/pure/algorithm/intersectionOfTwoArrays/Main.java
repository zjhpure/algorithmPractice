package org.pure.algorithm.intersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-24 22:45
 * @description 两个数组的交集
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs1 = str1.split("\\[")[1].split("]")[0].split(",");
        int size1 = strs1.length;
        int[] nums1 = new int[size1];
        for (int i = 0; i < size1; ++i) {
            nums1[i] = Integer.parseInt(strs1[i]);
        }

        // 处理输入结果
        String[] strs2 = str2.split("\\[")[1].split("]")[0].split(",");
        int size2 = strs2.length;
        int[] nums2 = new int[size2];
        for (int i = 0; i < size2; ++i) {
            nums2[i] = Integer.parseInt(strs2[i]);
        }

        // 获取输出结果
        int[] results = intersection(nums1, nums2);
        System.out.println(Arrays.toString(results));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        // 定义列表list保存交集数字
        List<Integer> list = new ArrayList<>();

        // 遍历数组nums1
        for (int num1 : nums1) {
            // 遍历数组nums2
            for (int num2 : nums2) {
                // 若两个数字相等并且在列表list中不存在，那么就是交集数字
                if (num1 == num2 && !list.contains(num1)) {
                    list.add(num1);
                }
            }
        }

        // 定义数组nums，保存结果
        int[] nums = new int[list.size()];

        // 遍历列表list，把交集数字装进数组nums
        for (int i = 0; i < list.size(); ++i) {
            nums[i] = list.get(i);
        }

        return nums;
    }

}
