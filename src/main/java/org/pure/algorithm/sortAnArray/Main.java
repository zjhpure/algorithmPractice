package org.pure.algorithm.sortAnArray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-08-26 21:28
 * @description 排序数组
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
        int[] result = sortArray(nums);
        System.out.println(Arrays.toString(result));
    }

    // 方法1，冒泡排序(交换排序)，时间复杂度O(n^2)，空间复杂度O(1)，这里运行超时，不能作为答案，因为题目做了严格的时间控制，必须使用优化过的快速排序运行才不超时
    private static int[] sortArray(int[] nums) {
        // 思路：冒泡排序

        // 定义数组nums的长度
        int n = nums.length;

        // 冒泡排序需要走n-1趟的比较和交换，每一趟实现把还没排序的元素的最大值交换到最后，比较元素时，起始元素从第一个元素到倒数第二个元素
        for (int i = 0; i < n - 1; ++i) {
            // 定义数组是否已有序的标识，默认有序
            boolean isSort = true;

            // 每一趟都往后逐个判断当前元素比后一个元素大是否成立，若成立，则交换两个元素
            for (int j = 0; j < n - 1 - i; ++j) {
                if (nums[j] > nums[j + 1]) {
                    // 若当前元素比后一个元素大，那么交换两个元素，把较大的元素往后移，这里使用位运算的方法实现两个元素的交换
                    nums[j] ^= nums[j + 1];
                    nums[j + 1] ^= nums[j];
                    nums[j] ^= nums[j + 1];
                    // 有进行交换元素，证明数组不是已有序，数组是否有序的标识设为false
                    isSort = false;
                }
            }

            if (isSort) {
                // 若数组已有序，那么前面的for循环不会出现nums[i] > nums[i + 1]，数组是否有序标识为true，所以可以直接结束循环
                break;
            }
        }

        // 返回有序的数组
        return nums;
    }

}
