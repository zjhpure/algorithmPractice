## 源码路径

/src/main/java/org/pure/algorithm/factorialTrailingZeroes/Main.java

## 题目地址(阶乘后的零)

https://leetcode-cn.com/problems/factorial-trailing-zeroes

## 题目描述

```
给定一个整数n，返回n!结果尾数中零的数量。

示例1:

输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。

示例2:

输入: 5
输出: 1
解释: 5! = 120, 尾数中有1个零。

说明:

你算法的时间复杂度应为O(logn)。
```

## 代码

- 语言：Java

```
class Solution {

    public int trailingZeroes(int n) {
        // 此题尚有疑问，可能分析有误，后续再探究
        
        // 思路：计算乘法因子中5的数量，5的数量就是阶乘后结果尾数中0的数量，因为2 * 5 = 10，一个10代表有一个尾数0，而且有一个5就会有一个2搭配，2可能是分拆出来的，所以问题就转化为了求乘法因子中5的数量

        // 定义尾数为0的数量，初始为0
        int count = 0;

        // 整数n循环除以5，直到小于5为止，结束循环
        while (n >= 5) {
            // 整数n除以5得到商，尾数为0的数量累加商
            count += n / 5;
            // 整数n更新为除以5后的商
            n /= 5;
        }

        // 最后返回尾数为0的数量
        return count;
    }

}
```