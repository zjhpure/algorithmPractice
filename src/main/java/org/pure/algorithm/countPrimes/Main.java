package org.pure.algorithm.countPrimes;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-07 23:25
 * @description 计数质数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = countPrimes(n);
        System.out.println(result);
    }

    private static int countPrimes(int n) {
        if (n < 3) {
            // 若n小于3，结果为0
            return 0;
        } else {
            // 质数数量
            int num = 1;

            // 从3开始循环判断，每次自增2，因为偶数不是质数，不用判断
            for (int i = 3; i < n; i += 2) {
                // 是否为质数
                boolean isPrime = true;

                // 从3循环到这个数的平方根
                for (int j = 3; j * j <= i; j += 2) {
                    if (i % j == 0) {
                        // 若能被除尽，则不是质数
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    // 质数数量加1
                    ++num;
                }
            }

            return num;
        }
    }

}
