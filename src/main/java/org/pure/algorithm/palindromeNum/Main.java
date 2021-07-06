package org.pure.algorithm.palindromeNum;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-18 02:19
 * @description 回文数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        boolean rs = isPalindrome(x);
        System.out.println(rs);
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int n = x;
            int sum = 0;
            // 得到反转后的数
            while (x > 0) {
                int m = x % 10;
                sum = sum * 10 + m;
                x = x / 10;
            }
            return n == sum;
        }
    }

}
