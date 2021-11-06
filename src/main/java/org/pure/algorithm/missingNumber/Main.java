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

//    // 方法2，数学法
//    private static int missingNumber(int[] nums) {
//        // 数学法
//
//        // 获取数组的长度
//        int n = nums.length;
//
//        // 利用公式计算[0,n]范围整数的总和，total = (首项 + 末项) * 项数 / 2
//        int total = n * (n + 1) / 2;
//
//        // 计算数组的总和
//        int sum = 0;
//
//        // 遍历数组nums，通过累加计算数组的总和sum
//        for (int num : nums) {
//            sum += num;
//        }
//
//        // [0,n]范围整数的总和减去数组的总和，就是丢失的数字
//        return total - sum;
//    }

    // 方法3，位运算法
    private static int missingNumber(int[] nums) {
        // 位运算法，利用异或的规律，x ^ x = 0，x ^ 0 = 0

        // 定义异或的结果
        int xor = 0;

        // 遍历数组nums，每个元素和xor进行异或计算
        for (int num : nums) {
            xor ^= num;
        }

        // 遍历[0,n]范围的整数，每个元素和xor进行异或计算
        for (int i = 0; i <= nums.length; ++i) {
            xor ^= i;
        }

        // 遍历两次，一次是数组nums，一次是[0,n]，刚好除了丢失的数字，其他数字都出现了两次，因为x ^ x = 0，所以其他两两出现的数字都成了0，只有丢失的数字只出现一次，定义丢失的数字为miss，所以最后就变成miss ^ 0，根据x ^ 0 = 0，即miss
        return xor;
    }

}
