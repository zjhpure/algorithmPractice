## 源码路径

/src/main/java/org/pure/algorithm/integerReplacement/Main.java

## 题目地址(整数替换)

https://leetcode-cn.com/problems/integer-replacement

## 题目描述

```
给定一个正整数n，你可以做如下操作：

如果n是偶数，则用n / 2替换n。
如果n是奇数，则可以用n + 1或n - 1替换n。
n变为1所需的最小替换次数是多少？

示例1：

输入：n = 8
输出：3
解释：8 -> 4 -> 2 -> 1

示例2：

输入：n = 7
输出：4
解释：7 -> 8 -> 4 -> 2 -> 1
或 7 -> 6 -> 3 -> 2 -> 1

示例3：

输入：n = 4
输出：2

提示：

1 <= n <= 2^31 - 1
```

## 代码

- 语言：Java

```
class Solution {

    public int integerReplacement(int n) {
        // 枚举法，利用递归

        if (n == 1) {
            // 若n是1，已达到条件，返回0
            return 0;
        } 

        if (n % 2 == 0) {
            // 若n是偶数，n变成n/2，这里有一次替换，所以1加上输入n/2的结果
            return 1 + integerReplacement(n / 2);
        }

        // 若n是奇数，n可能加1，也可能减1，加1或者减1都会变成偶数，变成偶数后又会变成它的一半，所以这里会有两次替换，即2加上之后的结果。如果是加1再除以2，即n/2+1；如果是减1再除以2，即n/2，例如：(7+1)/2=4，等于7/2+1=4，(7-1)/2=3，等于7/2=3。比较这两种情况得到的替换次数，取最小值，因为是递归，所以能保证每次都取到最小值
        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }

}
```