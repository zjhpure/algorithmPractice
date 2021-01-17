package org.pure.algorithm.intReverse;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-18 02:11
 * @description 整数反转
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int num = reverse(x);
        System.out.println(num);
    }

    private static int reverse(int x) {
        int n = x;

        if (x < 0) {
            x = x * -1;
        }

        int sum = 0;

        while (x > 0) {
            int m = x % 10;
            int temp = sum;
            sum = sum * 10 + m;
            if (sum / 10 != temp) {
                // 通过和之前一个对比，可以判断是否溢出
                return 0;
            }
            x = x / 10;
        }

        if (n < 0) {
            sum = sum * -1;
        }

        return sum;
    }

}
