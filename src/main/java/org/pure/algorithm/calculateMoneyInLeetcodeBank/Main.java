package org.pure.algorithm.calculateMoneyInLeetcodeBank;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-14 07:56
 * @description 计算力扣银行的钱
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = totalMoney(n);
        System.out.println(result);
    }

    private static int totalMoney(int n) {
        // 定义总和
        int total = 0;

        // 获取除以7的商
        int quotient = n / 7;

        // 获取对7取余的余数
        int res = n % 7;

        // 定义每个星期的总和
        int everyTotal = 28;

        // 遍历除以7的商，也就是遍历有多少个星期
        for (int i = 0; i < quotient; ++i) {
            // 总和累加
            total += everyTotal;

            // 每个星期的总和累加7，因为下一个星期周一都会比前一个星期周一多1块钱
            everyTotal += 7;
        }

        // 定义最后一个星期的总和
        int lastTotal = 0;

        // 遍历对7取余的余数，也就是最后一个星期，这一个星期不够7天
        for (int i = 0; i < res; ++i) {
            // 最后一个星期的总和累加，根据除以7的商加1获得周一的值
            lastTotal += quotient + 1 + i;
        }

        // 总和加上最后一个星期的总和
        total += lastTotal;

        return total;
    }

}
