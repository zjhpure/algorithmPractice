package org.pure.algorithm.maximumProductOfThreeNumbers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-06 11:33
 * @description 三个数的最大乘积
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
        int result = maximumProduct(nums);
        System.out.println(result);
    }

    private static int maximumProduct(int[] nums) {
        // 对数组nums排序
        Arrays.sort(nums);

        // 取第一最小值
        int min1 = nums[0];
        // 取第二最小值
        int min2 = nums[1];

        // 取第一最大值
        int max1 = nums[nums.length - 1];
        // 取第二最大值
        int max2 = nums[nums.length - 2];
        // 取第三最大值
        int max3 = nums[nums.length - 3];

        // 若全部是正数，最大乘积=第一最大值*第二最大值*第三最大值
        // 若全部是负数，最大乘积=第一最大值*第二最大值*第三最大值
        // 若有正数也有负数，最大乘积是以下两种情况中的一种，取最大值

        // 第一种情况，第一最大值*第二最大值*第三最大值
        int product1 = max1 * max2 * max3;
        // 第二种情况，第一最小值*第二最小值*第一最大值，因为如果数组中有正数也有负数时，两个负数相乘得到正数
        int product2 = min1 * min2 * max1;

        // 取两种情况中的最大值
        return Math.max(product1, product2);
    }

}
