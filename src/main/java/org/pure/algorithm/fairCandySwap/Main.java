package org.pure.algorithm.fairCandySwap;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-23 21:12
 * @description 公平的糖果棒交换
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
        int[] result = fairCandySwap(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] fairCandySwap(int[] A, int[] B) {
        // 定义数组A的总和
        int sumA = 0;
        // 定义数组B的总和
        int sumB = 0;

        // 遍历数组A，计算出数组A的总和
        for (int a : A) {
            sumA += a;
        }

        // 遍历数组B，计算出数组B的总和
        for (int b : B) {
            sumB += b;
        }

        // 遍历数组A
        for (int a : A) {
            // 遍历数组B
            for (int b : B) {
                // 数组A的元素和数组B的元素交换，判断两边的数组总和是否相等
                if (sumA - a + b == sumB - b + a) {
                    return new int[]{a, b};
                }
            }
        }

        return null;
    }

}
