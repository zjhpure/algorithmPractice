## 源码路径

/src/main/java/org/pure/algorithm/nthDigit/Main.java

## 题目地址(第N位数字)

https://leetcode-cn.com/problems/nth-digit

## 题目描述

```
给你一个整数n，请你在无限的整数序列[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...]中找出并返回第n位数字。

示例1：

输入：n = 3
输出：3

示例2：

输入：n = 11
输出：0
解释：第11位数字在序列1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。

提示：

1 <= n <= 2^31 - 1
```

## 代码

- 语言：Java

```
class Solution {

    public int findNthDigit(int n) {
        // 找规律，待理解原理

        // 10  10  1
        // 11  10  0
        // 12  11  1
        // 13  11  1
        // 14  12  1
        // 15  12  2
        // 16  13  1
        // 17  13  3
        // 18  14  1
        // 19  14  4
        // 20  15  1
        // 21  15  5
        // 22  16  1
        // 23  16  6
        // 24  17  1
        // 25  17  7
        // 26  18  1
        // 27  18  8
        // 28  19  1
        // 29  19  9
        // 30  20  2
        // 31  20  0
        // 32  21  2
        // 33  21  1

        // 从上面可以找出规律：
        // (10+10)/2=10，找到是数字10，(10+10)%2=0，找到是数字10的第0位，即1
        // (11+10)/2=10，找到是数字10，(11+10)%2=1，找到是数字10的第1位，即0
        // (12+10)/2=11，找到是数字11，(12+10)%2=0，找到是数字11的第0位，即1
        // (13+10)/2=11，找到是数字11，(13+10)%2=1，找到是数字11的第1位，即1
        // (30+10)/2=20，找到是数字20，(30+10)%2=0，找到是数字20的第0位，即2
        // (31+10)/2=20，找到是数字20，(31+10)%2=1，找到是数字20的第1位，即0

        // 先把n赋给k
        long k = n;

        // 定义位数，初始为1
        int i = 1;

        // 循环找到位数
        while (i * Math.pow(10, i) <= k) {
            // k每次增加10的i次方，k增加10^1，增加10^2，增加10^3...
            k += Math.pow(10, i);
            // 位数加1
            ++i;
        }

        // k除以i获取当前的数字，k取余i获取当前数字的第几位，从0开始算
        return Long.toString((int) (k / i)).charAt((int) (k % i)) - '0';
    }

}
```