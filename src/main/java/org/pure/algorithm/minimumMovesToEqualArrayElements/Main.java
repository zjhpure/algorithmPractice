package org.pure.algorithm.minimumMovesToEqualArrayElements;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-24 19:53
 * @description 最小操作次数使数组元素相等
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
        int result = minMoves(nums);
        System.out.println(result);
    }

    private static int minMoves(int[] nums) {
        // n-1个数加1等效于1个数减1，即寻找多少次1个数减1，最后数组元素都相等

        // 定义数组中的最小值
        int min = nums[0];

        // 遍历数组，找出数组中的最小值
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        // 定义最小操作次数
        int minCount = 0;

        // 遍历数组
        for (int num : nums) {
            // 每个元素减去最小值就是这个数变成最小值的次数，累计次数
            minCount += num - min;
        }

        // 返回最小操作次数
        return minCount;
    }

}
