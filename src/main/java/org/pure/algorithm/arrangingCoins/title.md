## 源码路径

/src/main/java/org/pure/algorithm/arrangingCoins/Main.java

## 题目地址(排列硬币)

https://leetcode-cn.com/problems/arranging-coins

## 题目描述

```
你总共有n枚硬币，并计划将它们按阶梯状排列。对于一个由k行组成的阶梯，其第i行必须正好有i枚硬币。阶梯的最后一行可能是不完整的。

给你一个数字n，计算并返回可形成完整阶梯行的总行数。

示例1:

1
11
11
输入：n = 5
输出：2
解释：因为第三行不完整，所以返回2。

示例2:

1
11
111
11
输入：n = 8
输出：3
解释：因为第四行不完整，所以返回3。

提示:

1 <= n <= 2^31 - 1
```

## 代码

- 语言：Java

```
class Solution {

    public int arrangeCoins(int n) {
        // 二分查找法，对n二分查找，因为前row行的总数sum可以通过公式计算：sum = (1 + row) * row / 2
        // 每次计算从1到row累加的和，比较是否等于硬币数n，若相等，那么完整阶梯行的总行数就是row；若大于，往左边区域寻找；若小于，右边区域寻找；一直二分收窄范围，直到左指针等于右指针，指针值就是完整阶梯行的总行数row

        if (n == 1) {
            // 若硬币数为1，那么完整阶梯行的总行数为1
            return 1;
        }

        // 定义左指针
        int left = 1;
        // 定义右指针
        int right = n;

        // 二分查找
        while (left < right) {
            // 注意整数范围，不要用左右指针相加再除以2的方法计算中间指针，因为可能会溢出，要通过左指针加上左右指针之差的方法计算中间指针
            int center = left + (right - left) / 2;

            // 计算前center完整阶梯行总数的2倍，公式：sum = (1 + row) * row / 2，这里要注意整数范围，从1开始大概累加到9万多，就会超出int的范围，所以这里强转为long来解决
            long sum = (long) center * (center + 1);
            
            if (sum == (long) 2 * n) {
                // 若前center完整阶梯行总数等于硬币数n，直接返回中间指针center
                return center;
            } else if (sum < (long) 2 * n){
                // 若前center完整阶梯行总数小于硬币数n，把左指针更新为中间指针加1
                left = center + 1;
            } else {
                // 若前center完整阶梯行总数大于硬币数n，把右指针更新为中间指针减1
                right = center - 1;
            }
        }

        // while循环结束，即左指针等于右指针，再判断一次前left完整阶梯行总数，若小于等于n，那么左指针刚好就是完整阶梯行的总行数，否则就是大于n，那么左指针减1就是完整阶梯行的总行数
        return (long) left * (left + 1) <= (long) 2 * n ? left : left - 1;
    }

}
```