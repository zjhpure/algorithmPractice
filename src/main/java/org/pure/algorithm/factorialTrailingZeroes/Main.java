package org.pure.algorithm.factorialTrailingZeroes;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-15 21:48
 * @description 阶乘后的零
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = trailingZeroes(n);
        System.out.println(result);
    }

    private static int trailingZeroes(int n) {
        // 此题尚有疑问，可能分析有误，后续再探究

        // 思路：计算乘法因子中5的数量，5的数量就是阶乘后结果尾数中0的数量，因为2 * 5 = 10，一个10代表有一个尾数0，而且有一个5就会有一个2搭配，2可能是分拆出来的，所以问题就转化为了求乘法因子中5的数量

        // 定义尾数为0的数量，初始为0
        int count = 0;

        // 整数n循环除以5，直到小于5为止，结束循环
        while (n >= 5) {
            // 整数n除以5得到商，尾数为0的数量累加商
            count += n / 5;
            // 整数n更新为除以5后的商
            n /= 5;
        }

        // 最后返回尾数为0的数量
        return count;
    }

}
