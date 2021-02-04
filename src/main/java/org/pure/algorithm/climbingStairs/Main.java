package org.pure.algorithm.climbingStairs;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-04 23:03
 * @description 爬楼梯
 */
@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = climbStairs(n);
        System.out.println(result);
//        int result = fib(n);
//        System.out.println(result);
    }

    private static int climbStairs(int n) {
        // 通过比较1、2、3、4、5的结果就能发现，其实就是斐波那契数列，f(n)=f(n-1)+f(n-2)
        // n阶：1、2、3、4、5
        // 方法：1、2、3、5、8
        // 但是直接用递归法解，会超时，当n=10时就已经超时了
        // 下面从1开始递增，每次计算出当前结果，当等于n时就结束
        // 注意：n=45时，返回的结果已经到了边界值，n=46时，返回的结果已经溢出

        // 保存当前结果
        int currentTotal = 1;
        // 保存上一个结果
        int lastTotal = 1;

        int m = 1;

        // 从1开始递增
        while (m < n) {
            int temp = currentTotal;
            currentTotal += lastTotal;
            lastTotal = temp;
            ++m;
        }

        return currentTotal;
    }

    // 不提倡用这个方法，时间复杂度很大，当n=10时就已经能明显感觉到要运行很久才能出结果，而第一个方法会很快出结果
    private static int fib(int n) {
        // 直接调用递归方法
        return fibonacci(n);
    }

    // 递归法
    private static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        // f(n)等于前两个相加
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
