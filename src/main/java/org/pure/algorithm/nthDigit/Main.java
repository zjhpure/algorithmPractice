package org.pure.algorithm.nthDigit;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 11/30/21 9:24 PM
 * @description 第N位数字
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = findNthDigit(n);
        System.out.println(result);
    }

//    private static int findNthDigit(int n) {
//        // 暴力法，直接模拟计算出，不推荐，超时
//
//        // 定义当前位数字
//        int digit = 0;
//
//        // 定义当前数字
//        int current = 1;
//
//        // 定义10的当前数字的位数减1次方
//        int e = 1;
//
//        // 定义当前要除以的除数
//        int divide = 1;
//
//        // 从1遍历到n
//        for (int i = 1; i <= n; ++i) {
//            if (current < e * 10) {
//                // 计算当前位数字，例如123的1，1 = 123 / 10 ^ 2 % 10，2 = 123 / 10 ^ 1 % 10，3 = 123 / 10 ^ 0 % 10
//                digit = (current / divide) % 10;
//                // 除数除以10，给下一个使用
//                divide /= 10;
//                // 若除数变成了0，那么当前数字到了下一个，所以current加1，除数重新变回原来的值，这个值等于10的当前数字的位数减1次方
//                if (divide == 0) {
//                    ++current;
//                    divide = e;
//                }
//            } else {
//                // 若当前数字增加了位数，10的当前数字的位数减1次方也要扩大10倍
//                e *= 10;
//                // 除数等于10的当前数字的位数减1次方
//                divide = e;
//                // 计算当前位数字
//                digit = (current / divide) % 10;
//                // 除数除以10，给下一个使用
//                divide /= 10;
//            }
//        }
//
//        // 返回当前位数字
//        return digit;
//    }

    private static int findNthDigit(int n) {
        // 找规律，待理解原理

        // 10  10  1
        // 11  10  0
        // 12  11  1
        // 13  11  1
        // 14  12  1
        // 15  12  2
        // 16  13  1
        // 17  13  3
        // 18  14  1
        // 19  14  4
        // 20  15  1
        // 21  15  5
        // 22  16  1
        // 23  16  6
        // 24  17  1
        // 25  17  7
        // 26  18  1
        // 27  18  8
        // 28  19  1
        // 29  19  9
        // 30  20  2
        // 31  20  0
        // 32  21  2
        // 33  21  1

        // 从上面可以找出规律：
        // (10+10)/2=10，找到是数字10，(10+10)%2=0，找到是数字10的第0位，即1
        // (11+10)/2=10，找到是数字10，(11+10)%2=1，找到是数字10的第1位，即0
        // (12+10)/2=11，找到是数字11，(12+10)%2=0，找到是数字11的第0位，即1
        // (13+10)/2=11，找到是数字11，(13+10)%2=1，找到是数字11的第1位，即1
        // (30+10)/2=20，找到是数字20，(30+10)%2=0，找到是数字20的第0位，即2
        // (31+10)/2=20，找到是数字20，(31+10)%2=1，找到是数字20的第1位，即0

        // 先把n赋给k
        long k = n;

        // 定义位数，初始为1
        int i = 1;

        // 循环找到位数
        while (i * Math.pow(10, i) <= k) {
            // k每次增加10的i次方，k增加10^1，增加10^2，增加10^3...
            k += Math.pow(10, i);
            // 位数加1
            ++i;
        }

        // k除以i获取当前的数字，k取余i获取当前数字的第几位，从0开始算
        return Long.toString((int) (k / i)).charAt((int) (k % i)) - '0';
    }

}
