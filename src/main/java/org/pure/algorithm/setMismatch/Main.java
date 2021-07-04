package org.pure.algorithm.setMismatch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-04 18:21
 * @description 错误的集合
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
        int[] result = findErrorNums(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findErrorNums(int[] nums) {
        // 定义返回结果数组results，数组第一个元素保存重复出现的整数，第二个元素保存丢失的整数
        int[] results = new int[2];

        // 对数组nums进行排序
        Arrays.sort(nums);

        // 定义减去丢失的整数的总和，第一个整数不可能是重复的，初始化时先累加第一个整数
        int sum = nums[0];

        // 循环遍历数组nums，从第二个整数开始遍历，找到重复出现的整数，并且累加得到减去丢失的整数的总和
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                // 若当前整数和前一个整数相等，那么找到重复出现的整数，赋值到结果数组results的第一个位置
                results[0] = nums[i];
            } else {
                // 若当前整数和前一个整数不相等，累加
                sum += nums[i];
            }
        }

        // 丢失的整数 = 从1到n的总和 - 减去丢失的整数的总和
        results[1] = (1 + nums.length) * nums.length / 2 - sum;

        // 最后返回结果数组results
        return results;
    }

}
