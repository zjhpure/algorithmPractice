package org.pure.algorithm.sortArrayFindNum;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-16 21:41
 * @description 在排序数组中查找数字I
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String target = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = search(nums, Integer.parseInt(target));
        System.out.println(result);
    }

    private static int search(int[] nums, int target) {
        // 使用二分查找法，找到数字出现的最左边索引，再往右统计这个数字的数量

        // 定义左指针，初始为数组nums的最左索引
        int left = 0;
        // 定义右指针，初始为数组nums的最后索引
        int right = nums.length - 1;

        // 循环二分查找，当左指针等于右指针时，停止循环
        while (left < right) {
            // 计算左指针和右指针的中间值
            int mid = (left + right) / 2;

            if (target <= nums[mid]) {
                // 若目标值target小于等于当前元素，右指针等于中间值
                right = mid;
            }

            if (target > nums[mid]) {
                // 若目标值target大于当前元素，左指针等于中间值加1
                left = mid + 1;
            }
        }

        // 循环结束，左指针left等于右指针right，并且找到的元素在最左侧

        // 定义数量
        int count = 0;

        // 循环往右统计目标值target的数量，每次判断左指针left下的值是否等于目标值target，若等于继续循环，左指针left加1，数量count加1，直到左指针left下的值不等于目标值target为止
        while (left < nums.length && target == nums[left]) {
            ++left;
            ++count;
        }

        // 最后返回数量
        return count;
    }

}
