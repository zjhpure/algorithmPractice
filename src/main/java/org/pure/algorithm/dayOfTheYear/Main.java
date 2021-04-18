package org.pure.algorithm.dayOfTheYear;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-18 22:21
 * @description 一年中的第几天
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int result = dayOfYear(str);
        System.out.println(result);
    }

    private static int dayOfYear(String date) {
        // 切割字符串，切割出年月日
        String[] strs = date.split("-");

        // 获取年，直接转字符串为整数
        int year = Integer.parseInt(strs[0]);

        // 获取月
        int month;
        if (strs[1].startsWith("0")) {
            // 若月以0开头，那么取0之后的字符串转为整数
            month = Integer.parseInt(strs[1].substring(1, 2));
        } else {
            // 若月不以0开头，那么直接转字符串为整数
            month = Integer.parseInt(strs[1]);
        }

        // 获取日
        int day;
        if (strs[2].startsWith("0")) {
            // 若日以0开头，那么取0之后的字符串转为整数
            day = Integer.parseInt(strs[2].substring(1, 2));
        } else {
            // 若日不以0开头，那么直接转字符串为整数
            day = Integer.parseInt(strs[2]);
        }

        // 是否闰年
        boolean isLeapYear;

        // 计算年是否为闰年
        if (year % 100 == 0) {
            // 若是100的倍数，判断是否被400整除
            isLeapYear = year % 400 == 0;
        } else {
            // 若不是100的倍数，判断是否被4整除
            isLeapYear = year % 4 == 0;
        }

        // 定义总天数
        int sum = 0;

        // 遍历月，总天数累加月份的天数
        for (int i = 1; i < month; ++i) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    sum += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    sum += 30;
                    break;
                case 2:
                    sum += isLeapYear ? 29 : 28;
                    break;
            }
        }

        // 总天数最后累加上天数
        sum += day;

        return sum;
    }

}
