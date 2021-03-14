package org.pure.algorithm.sumOfAllOddLengthSubarrays;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-14 13:08
 * @description 所有奇数长度子数组的和
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
        int result = sumOddLengthSubarrays(nums);
        System.out.println(result);
    }

    private static int sumOddLengthSubarrays(int[] arr) {
        // 总和
        int sum = 0;

        // 数组arr长度
        int size = arr.length;

        // 遍历数组arr，计算出每个元素在各种组合中出现的次数，每次累加元素*次数
        // 对于每个元素，如果元素左边是偶数个元素，右边也是偶数个元素，那么加上元素本身就能组成奇数长度数组(注意包括0)
        // 对于每个元素，如果元素左边是奇数个元素，右边也是奇数个元素，那么加上元素本身就能组成奇数长度数组(注意包括0)
        for (int i = 0; i < size; ++i) {
            // 左边元素个数
            int left = i;

            // 左边元素奇数个数
            int leftOdd = (left + 1) / 2;

            // 左边元素偶数个数
            int leftEven = left / 2 + 1;

            // 右边元素个数
            int right = size - i - 1;

            // 右边元素奇数个数
            int rightOdd = (right + 1) / 2;

            // 右边元素偶数个数
            int rightEven = right / 2 + 1;

            // 元素在组合中出现的次数=左边元素奇数个数*右边元素奇数个数+左边元素偶数个数*右边元素偶数个数
            int time = leftOdd * rightOdd + leftEven * rightEven;

            // 累加
            sum += arr[i] * time;
        }

        return sum;
    }

}
