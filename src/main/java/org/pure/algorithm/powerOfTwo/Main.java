package org.pure.algorithm.powerOfTwo;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-30 10:35
 * @description 2的幂
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        boolean result = isPowerOfTwo(n);
        System.out.println(result);
    }

    private static boolean isPowerOfTwo(int n) {
        return n >= 1 && (n & (n - 1)) == 0;
    }

}
