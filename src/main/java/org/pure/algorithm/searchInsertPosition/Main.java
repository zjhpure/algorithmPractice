package org.pure.algorithm.searchInsertPosition;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-31 18:22
 * @description 搜索插入位置
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
        int result = searchInsert(nums, Integer.parseInt(target));
        System.out.println(result);
    }

    private static int searchInsert(int[] nums, int target) {
        // 遍历排序数组nums
        for (int i = 0; i < nums.length; ++i) {
            if (target == nums[i]) {
                // 等于数组元素
                return i;
            } else if (target < nums[i]) {
                // 小于数组元素
                if (i == 0 || target > nums[i - 1]) {
                    // 若是第1个数组元素，或者大于前1个数组元素
                    return i;
                }
            }
        }

        // 若遍历排序数组nums后无法返回结果，则证明target比数组中任何一个数大，那么返回数组最大索引加1
        return nums.length;
    }

}
