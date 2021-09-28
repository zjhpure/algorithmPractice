package org.pure.algorithm.arraysOfNumShowTimes;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-28 23:30
 * @description 数组中数字出现的次数
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
        int[] result = singleNumbers(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] singleNumbers(int[] nums) {
        // 分区异或法

        // 思路：如果除了一个数字以外，其他数字都出现了两次，那么全员进行异或操作即可找到这个数字，而这里有两个只出现一次的数字，所以我们的思路就是把所有数字分为两组，两个只出现一次的数字在不同的组中，相同的数字被分到相同的组中，关键就是如何分组
        // 分组：先通过累计异或找到只出现一次的两个数字的异或结果，然后从异或结果中找到第一个是1的位，根据这个位就可以区分这两个数字，并且对于区分其他所有数字也适用，最后再次遍历数组，各自在两个组内进行异或操作，各自得到两个组内只出现一次的数字
        // 为何不是找第一个是0的位，因为得到的是异或结果，如果是0，那么证明这个位置上的两个位是相同的，无法证明这是两个不同的数字，但是如果一旦出现1，那么证明这个位置上的两个位是不同的，只要出现了不同的位，那么这两个数就是不同的，根据这个标识就可以把只出现一次的两个数字给区分开，而对于其它成对出现数字，因为成对的数字是相同的，所以某一个位也是相同的，所以成对的数字肯定也会被分到同一个组内

        // 只出现一次的两个数字的异或结果
        int xor = 0;

        // 遍历数组，累计异或，相同的两个数字会异或成0，0和任何数异或又会得到自身，那么最后得到剩下的两个不同的数字的异或结果
        for (int num : nums) {
            xor ^= num;
        }

        // 定义异或结果从右到左数起第一个为1的位
        int divide = 1;

        // 通过不断向左移动位，找到从右到左数起第一个为1的位，循环结束后就找到了分区标识
        while ((divide & xor) == 0) {
            // 每次向左移动1位
            divide <<= 1;
        }

        // 定义只出现一次的两个数字
        int a = 0, b = 0;

        // 再次遍历数组，找出只出现一次的两个数字
        for (int num : nums) {
            if ((divide & num) == 0) {
                // 在第一个分组内累计异或，计算出第一个只出现一次的数字
                a ^= num;
            } else {
                // 在第二个分组内累计异或，计算出第二个只出现一次的数字
                b ^= num;
            }
        }

        // 返回只出现一次的两个数字
        return new int[]{a, b};
    }

}
