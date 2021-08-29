package org.pure.algorithm.numberOfDaysInAMonth;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-08-30 01:54
 * @description 一月有多少天
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        String month = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = numberOfDays(Integer.parseInt(year), Integer.parseInt(month));
        System.out.println(result);
    }

    private static int numberOfDays(int year, int month) {
        if (year % 100 == 0) {
            // 若年份被100整除，判断是否被400整除
            if (year % 400 == 0) {
                // 若年份被400整除，年份是闰年
                return getMonthDays(true, month);
            } else {
                // 若年份不被400整除，年份不是闰年
                return getMonthDays(false, month);
            }
        } else {
            // 若年份不被100整除，判断是否被4整除
            if (year % 4 == 0) {
                // 若年份被4整除，年份是闰年
                return getMonthDays(true, month);
            } else {
                // 若年份不被4整除，年份不是闰年
                return getMonthDays(false, month);
            }
        }
    }

    // 计算月份的天数
    private static int getMonthDays(boolean isLeapYear, int month) {
        int monthDays = 0;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 8:
            case 7:
            case 10:
            case 12:
                monthDays = 31;
                break;
            case 2:
                if (isLeapYear) {
                    // 闰年二月份29天
                    monthDays = 29;
                } else {
                    // 非闰年二月份28天
                    monthDays = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                monthDays = 30;
                break;
        }

        return monthDays;
    }

}
