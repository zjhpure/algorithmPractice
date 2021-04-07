package org.pure.algorithm.mergeSortedArray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-07 23:42
 * @description 合并两个有序数组
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String mStr = scanner.nextLine();
        String str2 = scanner.nextLine();
        String nStr = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs1 = str1.split("\\[")[1].split("]")[0].split(",");
        int size1 = strs1.length;
        int[] nums1 = new int[size1];
        for (int i = 0; i < size1; ++i) {
            nums1[i] = Integer.parseInt(strs1[i]);
        }

        // 处理输入结果
        int m = Integer.parseInt(mStr);

        // 处理输入结果
        String[] strs2 = str2.split("\\[")[1].split("]")[0].split(",");
        int size2 = strs2.length;
        int[] nums2 = new int[size2];
        for (int i = 0; i < size2; ++i) {
            nums2[i] = Integer.parseInt(strs2[i]);
        }

        // 处理输入结果
        int n = Integer.parseInt(nStr);

        // 获取输出结果
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 若数组nums2的长度为0，那么结果就是数组nums1本身
        if (n > 0) {
            // 定义排序后的数组sorted
            int[] sorted = new int[m + n];

            // 定义索引k
            int k = 0;

            // 双指针循环，同时循环数组nums1和数组nums2，注意这里的数组nums1和数组nums2是本身有序的数组
            for (int i = 0, j = 0; i < m || j < n; ) {
                if (i >= m || j >= n) {
                    // 两个数组有一个结束循环
                    if (i >= m) {
                        // 若是数组nums1结束循环，直接取数组nums2的元素，指针j加1
                        sorted[k] = nums2[j];
                        ++j;
                    } else {
                        if (j >= n) {
                            // 若是数组nums2结束循环，直接取数组nums1的元素，指针i加1
                            sorted[k] = nums1[i];
                            ++i;
                        }
                    }
                } else {
                    // 两个数组都没有结束循环
                    if (nums1[i] < nums2[j]) {
                        // 若数组nums1的元素比数组nums2的元素小，那么取数组nums1的元素，指针i加1
                        sorted[k] = nums1[i];
                        ++i;
                    } else {
                        // 若数组nums2的元素比数组nums1的元素小，那么取数组nums2的元素，指针j加1
                        sorted[k] = nums2[j];
                        ++j;
                    }
                }

                // 每次索引k加1
                ++k;
            }

            // 复制排序后的数组sorted给数组nums1
            System.arraycopy(sorted, 0, nums1, 0, sorted.length);
        }
    }

}
