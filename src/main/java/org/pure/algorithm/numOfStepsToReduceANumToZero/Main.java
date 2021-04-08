package org.pure.algorithm.numOfStepsToReduceANumToZero;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-08 22:32
 * @description 将数字变成0的操作次数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = numberOfSteps(num);
        System.out.println(result);
    }

    private static int numberOfSteps(int num) {
        // 定义操作次数
        int count = 0;

        // 循环判断非负整数num是否等于0
        while (num > 0) {
            if (num % 2 == 0) {
                // 若是偶数，除以2
                num = num / 2;
            } else {
                // 若是奇数，减去1
                --num;
            }

            // 每次增加一次操作次数
            ++count;
        }

        return count;
    }

}
