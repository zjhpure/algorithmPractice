## 源码路径

/src/main/java/org/pure/algorithm/longestIncreasingSubsequence/Main.java

## 题目地址(最长递增子序列)

https://leetcode-cn.com/problems/longest-increasing-subsequence

## 题目描述

```
给你一个整数数组nums，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除(或不删除)数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7]是数组[0,3,1,6,2,2,7]的子序列。

示例1:

输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是[2,3,7,101]，因此长度为4。

示例2:

输入：nums = [0,1,0,3,2,3]
输出：4

示例3:

输入：nums = [7,7,7,7,7,7,7]
输出：1

提示：

1 <= nums.length <= 2500
-10^4 <= nums[i] <= 10^4

进阶：

你可以设计时间复杂度为O(n2)的解决方案吗？
你能将算法的时间复杂度降低到O(nlog(n))吗?
```

## 代码

- 语言：Java

```
class Solution {

    public int lengthOfLIS(int[] nums) {
        // 动态规划法，定义数组保存以nums[i]结尾的最长递增子序列长度，以nums[i]结尾的最长递增子序列长度，从以nums[i-i]结尾的的最长递增子序列长度算出
        
        if (nums.length == 0) {
            // 如果数组nums的长度为0，最长递增子序列的长度为0
            return 0;
        }

        // 定义数组dp，长度为数组nums的长度，记录以nums[i]结尾的最长递增子序列长度
        int[] dp = new int[nums.length];

        // 数组dp的第1个元素为1，因为以nums[0]结尾的最长递增子序列长度是1
        dp[0] = 1;

        // 定义最长递增子序列的长度，初始为1
        int maxLength = 1;

        // 遍历数组nums的元素，从1遍历到数组长度-1，计算以nums[0]结尾的最长递增子序列长度，至以nums[nums.length-1]结尾的的最长递增子序列长度
        for (int i = 1; i < nums.length; ++i) {
            // 以nums[i]结尾的最长递增子序列长度初始为1
            dp[i] = 1;

            // 从数组nums的第1个元素遍历到第i个元素
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    // 若当前元素大于前面的元素，那么符合递增，以nums[j]结尾的最长递增子序列长度加1，和以nums[i]结尾的最长递增子序列长度比较，取较大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // dp[i]是以nums[i]结尾的最长递增子序列长度，如果第i+1个元素不大于前面的任何元素，那么dp[i]是初始的1不变，最长递增子序列长度和以nums[i-1]结尾时一样，并不会影响到计算最长递增子序列的长度，因为dp[i] = Math.max(dp[i], dp[j] + 1)，会取较大值

            // 更新最长递增子序列的长度，比较每次以nums[i]结尾的最长递增子序列长度，找出最大值
            maxLength = Math.max(maxLength, dp[i]);
        }

        // 返回最长递增子序列的长度
        return maxLength;
    }

}
```