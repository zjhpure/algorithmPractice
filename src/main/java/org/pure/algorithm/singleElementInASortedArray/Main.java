package org.pure.algorithm.singleElementInASortedArray;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-10 03:27
 * @description 有序数组中的单一元素
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
        int result = singleNonDuplicate(nums);
        System.out.println(result);
    }

    private static int singleNonDuplicate(int[] nums) {
        // 位运算法，相同的两个整数进行异或运算等于0，0和任何其他整数进行异或运算等于其他整数本身，只出现两次的整数通过异或运算都等于0，而0和0异或也等于0，最后剩下只出现一次的整数

        // 定义累计异或运算的结果
        int result = 0;

        // 遍历数组，累计异或运算
        for (int num : nums) {
            // 累计异或运算，抵消掉只出现两次的整数，最后剩下只出现一次的整数
            result ^= num;
        }

        // 返回累计异或运算的结果，累计异或运算的结果就是只出现一次的整数
        return result;
    }

}
