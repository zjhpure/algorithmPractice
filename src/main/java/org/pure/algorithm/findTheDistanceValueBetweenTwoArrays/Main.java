package org.pure.algorithm.findTheDistanceValueBetweenTwoArrays;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-16 08:31
 * @description 两个数组间的距离值
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int d = scanner.nextInt();
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
        int size2 = strs1.length;
        int[] nums2 = new int[size2];
        for (int i = 0; i < size2; ++i) {
            nums2[i] = Integer.parseInt(strs2[i]);
        }

        // 获取输出结果
        int result = findTheDistanceValue(nums1, nums2, d);
        System.out.println(result);
    }

    private static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // 定义统计数量
        int count = 0;

        // 遍历数组arr1
        for (int e1 : arr1) {
            // 定义是否符合距离值的标志
            boolean isFind = false;

            // 遍历数组arr2
            for (int e2 : arr2) {
                if (Math.abs(e1 - e2) <= d) {
                    // 如果出现一个两数相减的绝对值小于等于d，那么不符合距离值的定义，标志为false，结束循环
                    isFind = true;
                    break;
                }
            }

            if (!isFind) {
                // 若是否符合距离值的标志为true，那么统计数量加1
                ++count;
            }
        }

        return count;
    }

}
