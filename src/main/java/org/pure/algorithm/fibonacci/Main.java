package org.pure.algorithm.fibonacci;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-04 23:05
 * @description 斐波那契数列
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = fib(n);
        System.out.println(result);
    }

    private static int fib(int n) {
        // 不使用递归法，使用迭代法，或者叫动态规划，并且要注意整数溢出的问题，不能在最后再对1000000007取模，因为这时在取模前可能就已经整数溢出了

        if (n == 0 || n == 1) {
            // 若n是0或1，直接返回自身
            return n;
        }

        // f(n) = f(n - 1) + f(n - 2)，定义这三个数
        int a = 0;
        int b = 1;
        int c = 1;

        // 从2开始，遍历到n
        for (int i = 2; i <= n; ++i) {
            // 每次相加计算下一个数时就对1000000007取模，保证整数不会溢出
            c = (a + b) % 1000000007;
            // 这时的f(n - 2)变成前一个等式的f(n - 1)
            a = b;
            // 这时的f(n - 1)变成前一个等式的f(n)
            b = c;
        }

        // 返回f(n)
        return c;
    }

}
