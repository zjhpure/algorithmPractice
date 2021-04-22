package org.pure.algorithm.simplifiedRobot;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-23 07:51
 * @description 速算机器人
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int result = calculate(str);
        System.out.println(result);
    }

    private static int calculate(String s) {
        // 定义x和y的初始值
        int x = 1, y = 0;

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            if ('A' == s.charAt(i)) {
                // 若字符为A，进行A运算
                x = 2 * x + y;
            } else {
                // 若字符为B，进行B运算
                y = 2 * y + x;
            }
        }

        return x + y;
    }

}
