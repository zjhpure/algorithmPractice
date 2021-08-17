## 源码路径

/src/main/java/org/pure/algorithm/studentAttendanceRecord/Main.java

## 题目地址(学生出勤记录I)

https://leetcode-cn.com/problems/student-attendance-record-i

## 题目描述

```
给你一个字符串s表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况(缺勤、迟到、到场)。记录中只含下面三种字符：

'A'：Absent，缺勤
'L'：Late，迟到
'P'：Present，到场
如果学生能够同时满足下面两个条件，则可以获得出勤奖励：

按总出勤计，学生缺勤('A')严格少于两天。
学生不会存在连续3天或3天以上的迟到('L')记录。
如果学生可以获得出勤奖励，返回true；否则，返回false。

示例1:

输入：s = "PPALLP"
输出：true
解释：学生缺勤次数少于2次，且不存在3天或以上的连续迟到记录。

示例2:

输入：s = "PPALLL"
输出：false
解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。

提示:

1 <= s.length <= 1000
s[i]为'A'、'L'或'P'
```

## 代码

- 语言：Java

```
class Solution {

    public boolean checkRecord(String s) {
        // 定义统计天数，先用作统计缺勤总天数
        int count = 0;

        // 第一次遍历字符串s的字符，判断缺勤总天数是否小于2
        for (int i = 0; i < s.length(); ++i) {
            if ('A' == s.charAt(i)) {
                // 若出现缺勤，那么缺勤总天数加1
                ++count;

                // 若缺勤总天数大于等于2，那么不符合条件，马上返回false
                if (count >= 2) {
                    return false;
                }
            }
        }

        // count用作统计连续迟到天数，重新置为0
        count = 0;

        // 第二次遍历字符串s的字符，
        for (int i = 0; i < s.length(); ++i) {
            if ('L' == s.charAt(i)) {
                if (i == 0) {
                    // 若迟到出现在第一个字符，那么连续迟到天数直接加1
                    ++count;
                } else if ('L' == s.charAt(i - 1)){
                    // 若迟到出现在第二个字符之后并且前一个字符也是迟到，那么连续迟到天数加1
                    ++count;

                    // 若连续迟到天数大于等于3，那么不符合条件，马上返回false
                    if (count >= 3) {
                        return false;
                    }
                } else {
                    // 若前一个字符不是迟到，那么连续迟到天数设置为1
                    count = 1;
                }
            } else {
                // 若不出现迟到，那么连续迟到天数归零
                count = 0;
            }
        }

        // 若程序能运行到这里，那么缺勤条件和迟到条件都达到，符合条件，返回true
        return true;
    }

}
```