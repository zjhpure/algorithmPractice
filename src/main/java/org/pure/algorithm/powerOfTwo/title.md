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
        return n >= 1 && (n & (n - 1)) == 0;
    }

}
```