package org.pure.algorithm.maxProductOfTwoElementsInArray;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-24 22:17
 * @description 数组中两元素的最大乘积
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
        int result = maxProduct(nums);
        System.out.println(result);
    }


    private static int maxProduct(int[] nums) {
        // 定义乘积最大值
        int max = 0;

        // 第一轮遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            // 第二轮遍历数组nums
            for (int j = 0; j < nums.length; ++j) {
                // 取不同的元素
                if (i != j) {
                    // 计算两者减1的乘积
                    int product = (nums[i] - 1) * (nums[j] - 1);

                    // 和乘积最大值比较，更新乘积最大值
                    if (product > max) {
                        max = product;
                    }
                }
            }
        }

        return max;
    }

}
