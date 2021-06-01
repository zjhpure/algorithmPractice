## 源码路径

/src/main/java/org/pure/algorithm/powerOfTwo/Main.java

## 题目地址(2的幂)

https://leetcode-cn.com/problems/power-of-two

## 题目描述

```
给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。

如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。

示例1:

输入：n = 1
输出：true
解释：20 = 1

示例2:

输入：n = 16
输出：true
解释：24 = 16

示例3:

输入：n = 3
输出：false

示例4:

输入：n = 4
输出：true

示例5:

输入：n = 5
输出：false

提示：

-2^31 <= n <= 2^31 - 1

进阶：

你能够不使用循环/递归解决此问题吗？
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isPowerOfTwo(int n) {
        // 2的幂肯定大于等于1，然后通过类似计算汉明距离的方法用&运算把n的最右边的1的位变成0，因为除了1其他2的幂都是只有1位是1，所以如果这个1变成了0，结果就会变成0，也就是&运算后等于0就是2的幂
        return n >= 1 && (n & (n - 1)) == 0;
    }

}
```