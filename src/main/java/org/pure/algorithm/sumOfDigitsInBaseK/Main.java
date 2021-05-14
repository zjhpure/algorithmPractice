package org.pure.algorithm.sumOfDigitsInBaseK;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-14 19:37
 * @description K进制表示下的各位数字总和
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = sumBase(Integer.parseInt(str1), Integer.parseInt(str2));
        System.out.println(result);
    }

    private static int sumBase(int n, int k) {
        // 定义各位相加总和
        int total = 0;

        // 除K取余法
        while (n > 0) {
            // 取余
            total += n % k;
            // 除以k
            n = n / k;
        }

        return total;
    }

}
