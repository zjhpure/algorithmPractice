package org.pure.algorithm.uglyNumber;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-08 14:32
 * @description 丑数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        boolean rs = isUgly(num);
        System.out.println(rs);
    }

    private static boolean isUgly(int num) {
        if (num <= 0) {
            // 丑数都是正整数
            return false;
        } else if (num == 1) {
            // 1是丑数
            return true;
        } else {
            // 先判断一次能否整除2、3、5
            int n = divide(num);

            if (n == -1) {
                // 若返回-1，则不能整除2、3、5，不是丑数
                return false;
            } else if (n == 1) {
                // 若结果为1，则是丑数
                return true;
            }

            // 循环判断
            while (n > 1) {
                // 除2、3、5
                n = divide(n);

                if (n == -1) {
                    // 若返回-1，则不能整除2、3、5，不是丑数
                    return false;
                }
            }

            return true;
        }
    }

    // 除2、3、5
    private static int divide(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else if (n % 3 == 0) {
            return n / 3;
        } else if (n % 5 == 0) {
            return n / 5;
        } else {
            return -1;
        }
    }

}
