## 源码路径

/src/main/java/org/pure/algorithm/numberOfDaysInAMonth/Main.java

## 题目地址(一月有多少天)

https://leetcode-cn.com/problems/number-of-days-in-a-month

## 题目描述

```
指定年份Y和月份M，请你帮忙计算出该月一共有多少天。

示例1:

输入：Y = 1992, M = 7
输出：31

示例2:

输入：Y = 2000, M = 2
输出：29

示例3:

输入：Y = 1900, M = 2
输出：28

提示：

1583 <= Y <= 2100
1 <= M <= 12
```

## 代码

- 语言：Java

```
class Solution {

    public int numberOfDays(int year, int month) {
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
    private int getMonthDays(boolean isLeapYear, int month) {
        int monthDays = 0;

        switch (month) {
            case 1:
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
            case 3:
                monthDays = 31;
                break;
            case 4:
                monthDays = 30;
                break;
            case 5:
                monthDays = 31;
                break;
            case 6:
                monthDays = 30;
                break;
            case 7:
                monthDays = 31;
                break;
            case 8:
                monthDays = 31;
                break;
            case 9:
                monthDays = 30;
                break;
            case 10:
                monthDays = 31;
                break;
            case 11:
                monthDays = 30;
                break;
            case 12:
                monthDays = 31;
                break;
        }

        return monthDays;
    }

}
```