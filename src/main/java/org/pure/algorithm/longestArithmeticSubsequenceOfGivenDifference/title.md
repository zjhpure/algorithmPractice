## 源码路径

/src/main/java/org/pure/algorithm/longestArithmeticSubsequenceOfGivenDifference/Main.java

## 题目地址(最长定差子序列)

https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference

## 题目描述

```
给你一个整数数组arr和一个整数difference，请你找出并返回arr中最长等差子序列的长度，该子序列中相邻元素之间的差等于difference。

子序列是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从arr派生出来的序列。

示例1：

输入：arr = [1,2,3,4], difference = 1
输出：4
解释：最长的等差子序列是[1,2,3,4]。

示例2：

输入：arr = [1,3,5,7], difference = 1
输出：1
解释：最长的等差子序列是任意单个元素。

示例3：

输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
输出：4
解释：最长的等差子序列是[7,5,3,1]。

提示：

1 <= arr.length <= 10^5
-10^4 <= arr[i], difference <= 10^4
```

## 代码

- 语言：Java

```
class Solution {

    // 方法1，暴力法，但是时间超时，不推荐
    public int longestSubsequence(int[] arr, int difference) {
        // 暴力法，双层遍历，时间超时

        // 定义最大等差子序列长度
        int maxCount = 0;

        // 第一层遍历数组，从0到末尾
        for (int i = 0; i < arr.length; ++i) {
            // 定义等差子序列长度
            int count = 1;

            // 定义上一个数，初始为当前遍历到的元素
            int last = arr[i];

            // 第二层遍历数组，从下一个元素到末尾，计算等差子序列长度
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] - last == difference) {
                    // 若第二层遍历到的元素和上一个数的差等于difference，那么符合条件，等差子序列长度加1
                    ++count;
                    // 上一个数更新为第二层遍历到的元素
                    last = arr[j];
                }
            }

            // 更新当前最大等差子序列长度
            maxCount = Math.max(count, maxCount);
        }

        // 返回最大等差子序列长度
        return maxCount;
    }

}
```