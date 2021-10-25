package org.pure.algorithm.nextGreaterElement;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-27 20:56
 * @description 下一个更大元素
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
        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 暴力法

        // 定义结果数组results
        int[] results = new int[nums1.length];

        // 遍历数组nums1
        for (int i = 0; i < nums1.length; ++i) {
            // 定义在数组nums2中第一个比数组nums1元素大的索引值
            int findIndex = -1;

            // 是否找到下一个更大元素
            boolean isFind = false;

            // 遍历数组nums2
            for (int j = 0; j < nums2.length; ++j) {
                if (nums2[j] == nums1[i]) {
                    // 如果数组nums2中的元素等于数组nums1中的元素，记录索引值
                    findIndex = j;
                } else if (nums2[j] > nums1[i]) {
                    // 如果数组nums2中的元素等于数组nums1中的元素
                    if (findIndex > -1) {
                        // 如果前面已找到了相等元素，那么数组nums2中找到的比数组num1中大的元素就是下一个更大元素
                        results[i] = nums2[j];
                        isFind = true;
                        break;
                    }
                }
            }

            if (!isFind) {
                // 如果没有找到下一个更大元素，那么给结果数组赋值-1
                results[i] = -1;
            }
        }

        return results;
    }

}
