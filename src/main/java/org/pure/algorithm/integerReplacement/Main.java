package org.pure.algorithm.integerReplacement;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-19 22:47
 * @description 整数替换
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = integerReplacement(n);
        System.out.println(result);
    }

    private static int integerReplacement(int n) {
        // 枚举法，利用递归

        if (n == 1) {
            // 若n是1，已达到条件，返回0
            return 0;
        }

        if (n % 2 == 0) {
            // 若n是偶数，n变成n/2，这里有一次替换，所以1加上输入n/2的结果
            return 1 + integerReplacement(n / 2);
        }

        // 若n是奇数，n可能加1，也可能减1，加1或者减1都会变成偶数，变成偶数后又会变成它的一半，所以这里会有两次替换，即2加上之后的结果。如果是加1再除以2，即n/2+1；如果是减1再除以2，即n/2，例如：(7+1)/2=4，等于7/2+1=4，(7-1)/2=3，等于7/2=3。比较这两种情况得到的替换次数，取最小值，因为是递归，所以能保证每次都取到最小值
        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }

}
