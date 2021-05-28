package org.pure.algorithm.totalHammingDistance;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-28 21:44
 * @description 汉明距离总和
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
        int result = totalHammingDistance(nums);
        System.out.println(result);
    }

    private static int totalHammingDistance(int[] nums) {
        // 定义汉明距离总和
        int sum = 0;

        // 两层遍历找出数组nums所有两个元素之间的组合
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                // 计算两个数的汉明距离，汉明距离就是两个数的位不同的个数之和，先把两个数进行异或运算，因为位不同异或运算会得到1，所以也就是统计异或运算后的这个数的位为1的个数，调用函数bitCount，统计位为1的个数
                sum += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }

        return sum;
    }

}
