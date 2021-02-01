package org.pure.algorithm.fibonacciNumber;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-02 01:16
 * @description 波那契数
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
        // 直接调用递归方法
        return fibonacci(n);
    }

    // 递归法
    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // f(n)等于前两个相加
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
