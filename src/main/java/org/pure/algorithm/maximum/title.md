## 源码路径

/src/main/java/org/pure/algorithm/maximum/Main.java

## 题目地址(最大数值)

https://leetcode-cn.com/problems/maximum-lcci

## 题目描述

```
编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。

示例:

输入： a = 1, b = 2
输出： 2
```

## 代码

- 语言：Java

```
class Solution {

    public int maximum(int a, int b) {
        // 利用简单的数学知识即可，a和b的最大值 = (a + b + abs(a - b)) / 2
        // 当a > b时，(a + b + abs(a - b)) / 2 = (a + b + a - b) / 2 = 2a / 2 = a
        // 当b > a时，(a + b + abs(a - b)) / 2 = (a + b + b - a) / 2 = 2b / 2 = b
        long abs = Math.abs((long)a - (long)b);
        long sum = (long)a + (long)b + abs;
        return (int)(sum / 2);
    }

}
```