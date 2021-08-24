package org.pure.algorithm.getMaximumInGeneratedArray;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-08-24 21:02
 * @description 获取生成数组中的最大值
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = getMaximumGenerated(n);
        System.out.println(result);
    }

    private static int getMaximumGenerated(int n) {
        // 定义数组nums，长度为n+1
        int[] nums = new int[n + 1];

        // 定义数组的最大值
        int max = 0;

        // 定义数组下标，初始为0
        int i = 0;

        // 循环遍历构造数组nums
        while (i <= n) {
            if (i == 0) {
                // 若数组下标为0，数组的值为0
                nums[i] = 0;
            } else if (i == 1) {
                // 若数组下标为1，数组的值为1
                nums[i] = 1;
            } else {
                // 数组下标从2开始，数组按照nums[2 * i] = nums[i]，nums[2 * i + 1] = nums[i] + nums[i + 1]的规则构造
                if (i % 2 == 0) {
                    // 当数组下标是偶数时，通过nums[2 * i] = nums[i]反推出nums[i] = nums[i / 2]
                    nums[i] = nums[i / 2];
                } else {
                    // 当数组下标是奇数时，通过nums[2 * i + 1] = nums[i] + nums[i + 1]反推出nums[i] = nums[i / 2] + nums[i / 2 + 1]
                    nums[i] = nums[i / 2] + nums[i / 2 + 1];
                }
            }

            if (nums[i] > max) {
                // 更新数组的最大值
                max = nums[i];
            }

            // 数组下标自加1
            ++i;
        }

        // 返回数组的最大值
        return max;
    }

}
