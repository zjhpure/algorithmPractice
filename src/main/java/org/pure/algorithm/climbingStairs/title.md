## 源码路径

/src/main/java/org/pure/algorithm/climbingStairs/Main.java

## 题目地址(爬楼梯)

https://leetcode-cn.com/problems/climbing-stairs

## 题目描述

```
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例1:

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶

示例2:

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
```

## 代码

- 语言：Java

```
class Solution {

    public int climbStairs(int n) {
        // 通过比较1、2、3、4、5的结果就能发现，其实就是斐波那契数列，f(n)=f(n-1)+f(n-2)
        // n阶：1、2、3、4、5
        // 结果：1、2、3、5、8
        // 但是直接用递归法解，会超时，当n=10时就已经超时了
        // 下面从1开始递增，每次计算出当前结果，当等于n时就结束
        // 注意：n=45时，返回的结果已经到了边界值，n=46时，返回的结果已经溢出

        // 保存当前结果
        int currentTotal = 1;
        // 保存上一个结果
        int lastTotal = 1;

        int m = 1;

        // 从1开始递增
        while (m < n) {
            int temp = currentTotal;
            currentTotal += lastTotal;
            lastTotal = temp;
            ++m;
        }

        return currentTotal;
    }

}
```