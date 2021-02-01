## 源码路径

/src/main/java/org/pure/algorithm/fibonacciNumber/Main.java

## 题目地址(波那契数)

https://leetcode-cn.com/problems/fibonacci-number

## 题目描述

```
斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给你 n ，请计算 F(n) 。

示例1:

输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1

示例2:

输入：3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2

示例3:

输入：4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3

提示:

0 <= n <= 30
```

## 代码

- 语言：Java

```
class Solution {

    public int fib(int n) {
        // 直接调用递归方法
        return fibonacci(n);
    }

    // 递归法
    private int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // f(n)等于前两个相加
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
```