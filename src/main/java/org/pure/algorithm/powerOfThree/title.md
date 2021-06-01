## 源码路径

/src/main/java/org/pure/algorithm/powerOfThree/Main.java

## 题目地址(3的幂)

https://leetcode-cn.com/problems/power-of-three

## 题目描述

```
给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。

整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x

示例1:

输入：n = 27
输出：true

示例2:

输入：n = 0
输出：false

示例3:

输入：n = 9
输出：true

示例4:

输入：n = 45
输出：false

提示：

-2^31 <= n <= 2^31 - 1

进阶：

你能不使用循环或者递归来完成本题吗？
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
           // 3的幂必定大于等于1，若小于1，直接判定为不是
           return false;
        }
    
        // 若一个数是3的幂，必定是3的倍数，而且除以3后还是3的倍数，再除以3，直到最后为1，如果最后不是1，那么证明这个数虽然是3的倍数，但是不是所有因子都是3，所以不是3的幂
        while (n % 3 == 0) {
           n /= 3;
        }

        // 最后一步判断是否为1，若是1，则证明n是3的幂，若不是1，则证明n不是3的幂
        return n == 1;
    }

}
```