package org.pure.algorithm.binarySearch;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-17 18:20
 * @description 二分查找
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = search(nums, target);
        System.out.println(result);
    }

    private static int search(int[] nums, int target) {
        // // 直接遍历查找，效率很低，不建议使用
        // for (int i = 0; i < nums.length; ++i) {
        //     if (target == nums[i]) {
        //         return i;
        //     }
        // }

        // 定义中间指针，左指针
        int center, left = 0;
        // 定义右指针
        int right = nums.length - 1;

        // 二分查找法，对于已经排好序的数组，用二分查找效率高
        while (left <= right) {
            // 获取数组的中间索引
            center = (left + right) / 2;

            if (target == nums[center]) {
                // 若目标值等于数组的元素，那么就是找到了目标值，返回下标即可
                return center;
            } else if (target < nums[center]) {
                // 若目标值小于数组的元素，那么目标值落在数组的前半部分，把右指针更新为中间指针减1
                right = center - 1;
            } else {
                // 若目标值大于数组的元素，那么目标值落在数组的后半部分，把左指针更新为中间指针加1
                left = center + 1;
            }
        }

        // 若没有找到目标值，返回-1
        return -1;
    }

}
