## 源码路径

/src/main/java/org/pure/algorithm/maxConsecutiveOnes/Main.java

## 题目地址(最大连续1的个数)

https://leetcode-cn.com/problems/max-consecutive-ones

## 题目描述

```
给定一个二进制数组， 计算其中最大连续1的个数。

示例1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.

提示：

输入的数组只包含 0 和1。
输入数组的长度是正整数，且不超过 10,000。
```

## 代码

- 语言：Java

```
class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        // 定义最大个数
        int max = 0;

        // 定义连续1的个数
        int count = 0;

        // 遍历数组nums
        for (int num : nums) {
            if (num == 1) {
                // 连续1的个数加1
                ++count;

                if (count > max) {
                    // 更新最大个数
                    max = count;
                }
            } else {
                // 连续1的个数重置为0
                count = 0;
            }
        }

        return max;
    }

}
```