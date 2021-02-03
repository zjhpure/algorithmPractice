package org.pure.algorithm.sqrtx;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-03 23:32
 * @description x的平方根
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = mySqrt(x);
        System.out.println(result);
    }

    // 最笨的方法，^_^
    private static int mySqrt(int x) {
        // 用long方法防止i越界，当i是int的边界值时，i+1的平方会越界，导致一直不符合判断条件，导致一直循环到结束，可能会导致超时
        long i = 0;

        // 从1开始查找，查找到x的一半即可
        while (i <= x / 2) {
            if (i * i == x) {
                return (int) i;
            }

            if ((i + 1) * (i + 1) == x) {
                return (int) (i + 1);
            }

            if (i * i < x && (i + 1) * (i + 1) > x) {
                return (int) i;
            }

            ++i;
        }

        return (int) i;
    }

}
