package org.pure.algorithm.missingNumber;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-03-19 22:45
 * @description 丢失的数字
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
        int result = missingNumber(nums);
        System.out.println(result);
    }

//    // 方法1，哈希集合法
//    private static int missingNumber(int[] nums) {
//        // 哈希集合法
//
//        // 定义哈希集合保存数组
//        Set<Integer> set = new HashSet<>();
//
//        // 遍历数组nums，把nums的元素保存进哈希集合set中
//        for (int num : nums) {
//            set.add(num);
//        }
//
//        // 遍历[0,n]范围的整数
//        for (int i = 0; i <= nums.length; ++i) {
//            if (!set.contains(i)) {
//                // 若哈希集合set中不包含此元素，那么这个就是丢失的数字
//                return i;
//            }
//        }
//
//        return -1;
//    }

    // 方法2，数学法
    private static int missingNumber(int[] nums) {
        // 数学法

        // 获取数组的长度
        int n = nums.length;

        // 利用公式计算[0,n]范围整数的总和，total = (首项 + 末项) * 项数 / 2
        int total = n * (n + 1) / 2;

        // 计算数组的总和
        int sum = 0;

        // 遍历数组nums，通过累加计算数组的总和sum
        for (int num : nums) {
            sum += num;
        }

        // [0,n]范围整数的总和减去数组的总和，就是丢失的数字
        return total - sum;
    }

}
