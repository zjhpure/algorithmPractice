package org.pure.algorithm.spiralMatrix2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-22 16:29
 * @description 螺旋矩阵II
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int[][] result = generateMatrix(n);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] generateMatrix(int n) {
        // 定义结果数组
        int[][] results = new int[n][n];

        // 定义要累加的数字，初始为1
        int num = 1;
        // 定义螺旋层数索引，初始为0
        int index = 0;

        // 循环，从1累加到n的平方，每次循环构造一层螺旋的元素，每次顺时针螺旋即为向右、向下、向左、向上移动
        while (num <= n * n) {
            // 向右移动
            // 行不变，值是：螺旋层数索引
            // 列从左到右，范围是：螺旋层数索引 -> n - 螺旋层数索引 - 1
            for (int i = index; i < n - index; ++i) {
                results[index][i] = num++;
            }

            // 向下移动
            // 列不变，值是：n - 螺旋层数索引 - 1
            // 行从上到下，范围是：螺旋层数索引 + 1 -> n - 螺旋层数索引 - 1
            for (int i = index + 1; i < n - index; ++i) {
                results[i][n - index - 1] = num++;
            }

            // 向左移动
            // 行不变，值是：n - 螺旋层数索引 - 1
            // 列从右到左，范围是：n - 螺旋层数索引 - 2 -> 螺旋层数索引
            for (int i = n - index - 2; i >= index; --i) {
                results[n - index - 1][i] = num++;
            }

            // 向上移动
            // 列不变，值是：螺旋层数索引
            // 行从下到上，范围是：n - 螺旋层数索引 - 2 -> 螺旋层数索引 + 1
            for (int i = n - index - 2; i > index; --i) {
                results[i][index] = num++;
            }

            // 螺旋层数索引加1，最多加到n除以2加1就会结束循环，index <= n / 2 + 1
            ++index;
        }

        // 返回结果数组
        return results;
    }

}
