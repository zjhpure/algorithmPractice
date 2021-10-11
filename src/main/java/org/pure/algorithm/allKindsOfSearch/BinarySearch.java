package org.pure.algorithm.allKindsOfSearch;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-11 19:18
 * @description 二分查找
 */
public class BinarySearch {

    // 二分查找也叫折半查找
    // 二分查找的序列必须是有序序列
    // 二分查找有两种实现方式，一种是非递归方式；另一种是递归方式

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = binarySearch(arr, target);
        System.out.println("二分查找，有序查找，非递归方式：" + result);

        // 获取输出结果
        int result2 = binarySearch2(arr, target, 0, arr.length - 1);
        System.out.println("二分查找，有序查找，递归方式：" + result2);
    }

    // 二分查找，有序查找，非递归方式，时间复杂度O(logn)
    private static int binarySearch(int[] arr, int target) {
        // 定义左指针
        int left = 0;

        // 定义右指针
        int right = arr.length - 1;

        // 进行二分查找，对于已经排好序的数组，用二分查找效率高
        while (left <= right) {
            // 定义中间指针，防止整数溢出，不使用(left + right) / 2，改为left + (right - left) / 2，而且使用位运算的方法代替除以2，比除法运算快
            int mid = left + ((right - left) >> 1);

            if (target == arr[mid]) {
                // 若目标值等于数组的元素，那么找到了目标值，返回下标
                return mid;
            } else if (target < arr[mid]) {
                // 若目标值小于数组的元素，那么目标值落在数组的前半部分，把右指针更新为中间指针减1
                right = mid - 1;
            } else {
                // 若目标值大于数组的元素，那么目标值落在数组的后半部分，把左指针更新为中间指针加1
                left = mid + 1;
            }
        }

        // 若没有找到目标值，返回-1
        return -1;
    }

    // 二分查找，有序查找，递归方式，时间复杂度O(logn)
    private static int binarySearch2(int[] arr, int target, int left, int right) {
        if (left > right) {
            // 若左指针大于右指针，那么没有找到目标值，返回-1
            return -1;
        }

        // 定义中间指针，防止整数溢出，不使用(left + right) / 2，改为left + (right - left) / 2，而且使用位运算的方法代替除以2，比除法运算快
        int mid = left + ((right - left) >> 1);

        if (target == arr[mid]) {
            // 若目标值等于数组的元素，那么找到了目标值，返回下标
            return mid;
        } else if (target < arr[mid]) {
            // 若目标值大于数组的元素，那么目标值落在数组的后半部分，把左指针更新为中间指针加1
            return binarySearch2(arr, target, left, mid - 1);
        } else {
            // 若目标值大于数组的元素，那么目标值落在数组的后半部分，把左指针更新为中间指针加1
            return binarySearch2(arr, target, mid + 1, right);
        }
    }
}
