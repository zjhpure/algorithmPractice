## 源码路径

/src/main/java/org/pure/algorithm/sqrtx/Main.java

## 题目地址(x的平方根)

https://leetcode-cn.com/problems/sqrtx

## 题目描述

```
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例1:

输入: 4
输出: 2

示例2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
```

## 代码

- 语言：Java

```
class Solution {

    // 最笨的方法，^_^
    public int mySqrt(int x) {
        // 用long方法防止i越界，当i是int的边界值时，i+1的平方会越界，导致一直不符合判断条件，导致一直循环到结束，可能会导致超时
        long i = 0;

        // 从1开始查找，查找到x的一半即可
        while (i <= x / 2) {
            if (i * i == x) {
                return (int) i;
            }

            if ((i + 1) * (i + 1) == x) {
                return (int) (i + 1);
            }

            if (i * i < x && (i + 1) * (i + 1) > x) {
                return (int) i;
            }

            ++i;
        }

        return (int) i;
    }

}
```