package org.pure.algorithm.consecutiveCharacters;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-26 14:48
 * @description 连续字符
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int result = maxPower(str);
        System.out.println(result);
    }

    private static int maxPower(String s) {
        // 定义最大能量
        int max = 0;

        // 定义当前子字符串的长度
        int currentCount = 0;
        // 定义当前字符
        char currentC = '0';

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (currentC == c) {
                // 如果当前字符等于遍历到的字符，那么当前子字符串的长度加1
                ++currentCount;
            } else {
                // 如果当前字符不等于遍历到的字符，那么前面的子字符串结束，从这里重新开始，把当前字符设置为遍历到的字符，并且当前子字符串的长度设置为1
                currentC = c;
                currentCount = 1;
            }

            // 比较当前子字符串的长度和最大能量，取较大值
            max = Math.max(currentCount, max);
        }

        // 最后得出子字符串的最长长度
        return max;
    }

}
