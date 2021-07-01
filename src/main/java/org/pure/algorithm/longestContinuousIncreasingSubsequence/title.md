## 源码路径

/src/main/java/org/pure/algorithm/longestContinuousIncreasingSubsequence/Main.java

## 题目地址(最长连续递增序列)

https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence

## 题目描述

```
给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。

连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。

示例1:

输入：nums = [1,3,5,4,7]
输出：3
解释：最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。

示例2:

输入：nums = [2,2,2,2,2]
输出：1
解释：最长连续递增序列是 [2], 长度为1。

提示：

1 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
```

## 代码

- 语言：Java

```
class Solution {

    public int findLengthOfLCIS(int[] nums) {
        // 定义最大长度
        int max = 0;
        // 定义连续递增子序列长度
        int count = 0;

        // 遍历数组nums的元素
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                // 若是第一个元素，连续递增子序列长度加1
                ++count;
            } else {
                if (nums[i] > nums[i - 1]) {
                    // 若当前元素大于前一个元素，那么是递增子序列，连续递增子序列长度加1
                    ++count;
                } else {
                    // 若当前元素小于等于前一个元素，那么不是递增子序列了
                    if (count > max) {
                        // 更新最大长度
                        max = count;
                    }
                    // 重置连续递增子序列长度为1，自己本身一个数就算作长度1
                    count = 1;
                }
            }
        }

        if (count > max) {
            // 最后再更新最大长度
            max = count;
        }

        // 返回最大长度
        return max;
    }

}
```