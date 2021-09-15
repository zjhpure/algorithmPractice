package org.pure.algorithm.findPeakElement;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-15 22:49
 * @description 寻找峰值
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
        int result = findPeakElement(nums);
        System.out.println(result);
    }

//    // 方法1，枚举法，寻找最大值的下标
//    private static int findPeakElement(int[] nums) {
//        // 寻找数组最大值的下标，因为nums[i] != nums[i + 1]，所以数组最大值的下标是一个可行的峰值的下标
//
//        // 定义数组最大值的下标
//        int maxIndex = 0;
//
//        // 从数组的第二个元素开始遍历到最后一个元素，寻找数组最大值的下标
//        for (int i = 1; i < nums.length; ++i) {
//            if (nums[i] > nums[i - 1]) {
//                maxIndex = i;
//            }
//        }
//
//        // 返回数组最大值的下标
//        return maxIndex;
//    }

    // 方法2，二分查找法
    private static int findPeakElement(int[] nums) {
        // 二分查找法，从中间开始查找，和下一个元素比较大小，如果较大，那么峰值在左侧；如果较小，那么峰值在右侧

        // 因为nums[-1] = nums[n] = -∞，所以数组两端是负无穷的，而对于所有有效的i都有nums[i] != nums[i + 1]，那么必定有两个相邻的元素nums[i] < nums[i + 1]或nums[i] > nums[i + 1]，从这里就可以推导出必定存在一个地方达到峰值，所以数组中必定能找到一个峰值

        // 定义左指针，初始为0
        int left = 0;
        // 定义右指针，初始为数组最后一个元素的下标
        int right = nums.length - 1;

        // 二分查找，从两边不断往里缩小范围，当左指针和右指针相等时，结束循环
        while (left < right) {
            // 二分计算中间指针
            int mid = (left + right) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // 若当前元素大于下一个元素，那么峰值在左侧，右指针等于中间指针，把范围缩小到左侧
                right = mid;
            } else {
                // 因为nums[i] != nums[i + 1]，所以相邻元素不会相等，所以这里是当前元素小于下一个元素
                // 若当前元素小于下一个元素，那么峰值在右侧，左指针等于中间指针加1，把范围缩小到右侧
                left = mid + 1;
            }
        }

        // 最后把位置缩小到只有一个元素，即left=right，这时的元素就是峰值之一
        return left;
    }

}
