## 源码路径

/src/main/java/org/pure/algorithm/dayOfTheYear/Main.java

## 题目地址(一年中的第几天)

https://leetcode-cn.com/problems/day-of-the-year

## 题目描述

```
给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。

通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。

示例1:

输入：date = "2019-01-09"
输出：9

示例2:

输入：date = "2019-02-10"
输出：41

示例3:

输入：date = "2003-03-01"
输出：60

示例4:

输入：date = "2004-03-01"
输出：61

提示:

date.length == 10
date[4] == date[7] == '-'，其他的 date[i] 都是数字。
date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
```

## 代码

- 语言：Java

```
class Solution {

    public int dayOfYear(String date) {
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
```