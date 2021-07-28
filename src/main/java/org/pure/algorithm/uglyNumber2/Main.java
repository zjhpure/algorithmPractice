package org.pure.algorithm.uglyNumber2;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-28 21:13
 * @description 丑数II
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = nthUglyNumber(num);
        System.out.println(result);
    }

    // 方法1，枚举法，运行超时，不能使用
    private static int nthUglyNumber(int n) {
        // 此方法直接沿用之前判断丑数的解题思路，从1遍历n-1，遍历时调用之前判断丑数的函数，若是丑数数量加1，若数量达到了n个，结束循环，返回当前的数字，此数字正是第n个丑数，但是此方法耗时多，提交后运行超时，不能使用

        // 丑数，第一个为1
        int i = 1;

        // 丑数个数
        int count = 1;

        while (count < n) {
            ++i;
            if (isUgly(i)) {
                // 若找到丑数，丑数个数加1
                ++count;
            }
        }

        return i;
    }

    // 判断是否为丑数
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
