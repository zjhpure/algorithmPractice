package org.pure.algorithm.takeCoins;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-10 08:15
 * @description 拿硬币
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
        int result = minCount(nums);
        System.out.println(result);
    }

    private static int minCount(int[] coins) {
        // 定义总次数
        int sum = 0;

        // 遍历数组coins
        for (int coin : coins) {
            if (coin % 2 == 0) {
                // 若元素能被2整除，那么可以每次拿两枚，总次数就是累加上元素整除2的值
                sum += coin / 2;
            } else {
                // 若元素不能被2整除，那么每次拿两枚，最后一次拿一枚，总次数就是累加上元素整除2的值和1
                sum += coin / 2 + 1;
            }
        }

        return sum;
    }

}
