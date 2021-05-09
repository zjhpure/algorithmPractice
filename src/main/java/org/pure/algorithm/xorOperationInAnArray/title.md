## 源码路径

/src/main/java/org/pure/algorithm/xorOperationInAnArray/Main.java

## 题目地址(数组异或操作)

https://leetcode-cn.com/problems/xor-operation-in-an-array

## 题目描述

```
给你两个整数，n 和 start 。

数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。

请返回 nums 中所有元素按位异或（XOR）后得到的结果。

示例1:

输入：n = 5, start = 0
输出：8
解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
     "^" 为按位异或 XOR 运算符。

示例2:

输入：n = 4, start = 3
输出：8
解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.

示例3:

输入：n = 1, start = 7
输出：7

示例4:

输入：n = 10, start = 5
输出：2

提示:

1 <= n <= 1000
0 <= start <= 1000
n == nums.length
```

## 代码

- 语言：Java

```
class Solution {

    public int xorOperation(int n, int start) {
        // 定义异或结果，初始值为数组nums的第一个元素，也就是start
        int result = start;

        // 从1到n-1遍历，计算异或结果
        for (int i = 1; i < n; ++i) {
            // 数组的元素等于start+2*i，拿到结果再进行异或操作
            result ^= start + 2 * i;
        }

        return result;
    }

}
```