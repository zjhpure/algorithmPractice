## 源码路径

/src/main/java/org/pure/algorithm/countOddNumbersInAnIntervalRange/Main.java

## 题目地址(在区间范围内统计奇数数目)

https://leetcode-cn.com/problems/count-odd-numbers-in-an-interval-range

## 题目描述

```
给你两个非负整数low和high。请你返回low和high之间(包括二者)奇数的数目。

示例1:

输入：low = 3, high = 7
输出：3
解释：3到7之间奇数数字为[3,5,7]。

示例2:

输入：low = 8, high = 10
输出：1
解释：8到10之间奇数数字为[9]。

提示:

0 <= low <= high <= 10^9
```

## 代码

- 语言：Java

```
class Solution {

    public int countOdds(int low, int high) {
        // 直接数学计算可以算出答案，举例四个，开区间和闭区间分别是奇数和偶数
        // 奇数和奇数：3 7 -- 3,5,7 -- (7-3)/2+1=3，需要加1
        // 偶数和奇数：2 7 -- 3,5,7 -- (7-2)/2+1=3，需要加1
        // 奇数和偶数：3 8 -- 3,5,7 -- (8-3)/2+1=3，需要加1
        // 偶数和偶数：2 8 -- 3,5,7 -- (8-2)/2=3，不需要加1

        // 统计区间内的奇数数目
        int count = (high - low) / 2;

        if (low % 2 == 1 || high % 2 == 1) {
            // 若开区间和闭区间有一个是奇数，那么奇数数目加1
            ++count;
        }

        // 若开区间和闭区间两个都是偶数，那么奇数数目是原来的数量

        // 返回奇数数目
        return count;
    }

}
```