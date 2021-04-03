package org.pure.algorithm.findNUniqueIntsSumUpToZero;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-03 16:36
 * @description 和为零的N个唯一整数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int[] results = sumZero(n);
        System.out.println(Arrays.toString(results));
    }

    private static int[] sumZero(int n) {
        // 定义结果数组results
        int[] results = new int[n];

        if (n <= 1) {
            // 若n小于等于1，那么结果数组results只有一个元素，并且是0
            results[0] = 0;
        }

        // 定义总和
        int sum = 0;

        // 从1开始遍历到n-1
        for (int i = 1; i <= n - 1; ++i) {
            // 每次把n本身赋值到结果数组results中
            results[i - 1] = i;

            // 累加n值得到总和
            sum += i;
        }

        // 结果数组results的最后一个元素取总和的负数，那么他们相加之和就肯定为0了
        results[n - 1] = sum * -1;

        return results;
    }

}
