## 源码路径

/src/main/java/org/pure/algorithm/nThTribonacciNumber/Main.java

## 题目地址(第N个泰波那契数)

https://leetcode-cn.com/problems/n-th-tribonacci-number

## 题目描述

```
泰波那契序列 Tn 定义如下： 

T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

给你整数 n，请返回第 n 个泰波那契数 Tn 的值。

示例1:

输入：n = 4
输出：4
解释：
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

示例2:

输入：n = 25
输出：1389537

提示：

0 <= n <= 37
答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
```

## 代码

- 语言：Java

```
class Solution {

    public int tribonacci(int n) {
        // 直接调用递归方法
        return getTribonacci(n);
    }

    // 定义集合map保存结果
    private Map<Integer, Integer> map = new HashMap<>();

    // 递归法，带有记忆的递归，如果不带记忆，当n的值比较大时会运行超时
    private int getTribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        // 若集合map中找到key为n的value，直接返回value
        if (map.get(n) != null) {
            return map.get(n);
        }

        // 计算当前值，当前值等于前三个相加，注意这里必须先计算n-3，再计算n-2，最后计算n-1，因为前面计算出的结果，后面可以直接用
        int n1 = getTribonacci(n - 3);
        int n2 = getTribonacci(n - 2);
        int n3 = getTribonacci(n - 1);

        // 把n的当前值推进集合map中
        map.put(n, n1 + n2 + n3);

        // 最后从集合map中找到n的当前值
        return map.get(n);
    }

}
```