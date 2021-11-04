## 源码路径

/src/main/java/org/pure/algorithm/validPerfectSquare/Main.java

## 题目地址(有效的完全平方数)

https://leetcode-cn.com/problems/valid-perfect-square

## 题目描述

```
给定一个正整数num，编写一个函数，如果num是一个完全平方数，则返回true，否则返回false。

进阶：不要使用任何内置的库函数，如sqrt。

示例1：

输入：num = 16
输出：true

示例2：

输入：num = 14
输出：false

提示：

1 <= num <= 2^31 - 1
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isPerfectSquare(int num) {
        // 二分查找，注意溢出，测试判断平方时强转为long类型，避免溢出

        if (num == 1) {
            // 若是1，1是1的完全平方数，直接返回true
            return true;
        }

        // 定义左指针
        int left = 1;
        // 定义右指针，开方数一定小于等于一半，所以判断一半即可
        int right = num / 2;

        // 二分查找，从两侧往里查找
        while (left <= right) {
            // 定义中间指针，通过左指针加左右指针除以2的方式计算中间指针，而不是左指针加右指针再除以2，防止超过整数范围
            int mid = left + (right - left) / 2;

            // 计算中间指针的平方，判断是否等于整数num，注意强转为long，因为可能会超出整数范围，例如最大整数的一半的平方，肯定是超过整数范围的
            long square = (long) mid * mid;
            
            if (square == num) {
                // 若中间指针的平方等于整数num，那么是完全平方数，返回true
                return true;
            } else if (square < num) {
                // 若中间指针的平方小于整数num，那么往右侧区域继续寻找
                left = mid + 1;
            } else {
                // 若中间指针的平方大于整数num，那么往左侧区域继续寻找
                right = mid - 1;
            }
        }

        // 若二分查找结束后还没有匹配到完全平方数，即整数num不是完全平方数，返回false
        return false;
    }

}
```