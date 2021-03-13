package org.pure.algorithm.subtractProductAndSum;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-13 22:40
 * @description 整数的各位积和之差
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = subtractProductAndSum(n);
        System.out.println(result);
    }

    private static int subtractProductAndSum(int n) {
        // 各位数之积
        int product = 1;

        // 各位数之和
        int sum = 0;

        // 循环获取整数n各位数字
        while (n > 0) {
            // 通过对10取余获取各位数字
            int num = n % 10;

            // 计算累加值
            product *= num;

            // 计算累积值
            sum += num;

            // 通过除以10降一位
            n = n / 10;
        }

        return product - sum;
    }

}
