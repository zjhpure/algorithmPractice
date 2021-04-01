package org.pure.algorithm.nThTribonacciNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-01 22:28
 * @description 第N个泰波那契数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int size = tribonacci(n);
        System.out.println(size);
    }

    private static int tribonacci(int n) {
        // 直接调用递归方法
        return getTribonacci(n);
    }

//    // 递归法，不建议使用此方法，此方法当n值很大时会运行超时
//    private static int getTribonacci(int n) {
//        if (n == 0) {
//            return 0;
//        } else if (n == 1 || n == 2) {
//            return 1;
//        } else {
//            // f(n)等于前三个相加
//            return getTribonacci(n - 3) + getTribonacci(n - 2) + getTribonacci(n - 1);
//        }
//    }

    // 定义集合map保存结果
    private static Map<Integer, Integer> map = new HashMap<>();

    // 递归法，带有记忆的递归，如果不带记忆，当n的值比较大时会运行超时
    private static int getTribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        // 若集合map中找到key为n的value，直接返回value
        if (map.get(n) != null) {
            return map.get(n);
        }

        // 计算当前值，当前值等于前三个相加，注意这里必须先计算n-3，再计算n-2，最后计算n-1，因为前面计算出的结果，后面可以直接用
        int n1 = getTribonacci(n - 3);
        int n2 = getTribonacci(n - 2);
        int n3 = getTribonacci(n - 1);

        // 把n的当前值推进集合map中
        map.put(n, n1 + n2 + n3);

        // 最后从集合map中找到n的当前值
        return map.get(n);
    }

}
