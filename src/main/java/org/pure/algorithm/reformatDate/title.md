## 源码路径

/src/main/java/org/pure/algorithm/reformatDate/Main.java

## 题目地址(转变日期格式)

https://leetcode-cn.com/problems/reformat-date

## 题目描述

```
给你一个字符串 date ，它的格式为 Day Month Year ，其中：

Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
Year 的范围在 ​[1900, 2100] 之间。
请你将字符串转变为 YYYY-MM-DD 的格式，其中：

YYYY 表示 4 位的年份。
MM 表示 2 位的月份。
DD 表示 2 位的天数。

示例1:

输入：date = "20th Oct 2052"
输出："2052-10-20"

示例2:

输入：date = "6th Jun 1933"
输出："1933-06-06"

示例3:

输入：date = "26th May 1960"
输出："1960-05-26"

提示：

给定日期保证是合法的，所以不需要处理异常输入。
```

## 代码

- 语言：Java

```
class Solution {

    public String reformatDate(String date) {
        // 切割字符串date，通过空格分割，分割成日、月、年
        String[] strs = date.split(" ");

        // 获取日字符串，去掉最后两个字符，剩下就是日的字符串，再转为整数
        int day =  Integer.parseInt(strs[0].substring(0, strs[0].length() - 2));

        // 定义月
        int month = 0;

        // 定义月字符串数组
        String[] monthList = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        // 遍历月字符串数组，找出月是哪一个月
        for (int i = 0; i < monthList.length; ++i) {
            if (strs[1].equals(monthList[i])) {
                month = i + 1;
            }
        }

        // 获取年
        String year = strs[2];

        // 定义字符串集合
        StringBuilder sb = new StringBuilder();

        // 字符串集合添加年
        sb.append(year);
        
        sb.append("-");

        // 字符串集合添加月
        if (month < 10) {
            // 小于10的补零
            sb.append("0");
        } 
        sb.append(month);

        sb.append("-");

        // 字符串集合添加日
        if (day < 10) {
            // 小于10的补零
            sb.append("0");
        } 
        sb.append(day);

        return sb.toString();
    }

}
```