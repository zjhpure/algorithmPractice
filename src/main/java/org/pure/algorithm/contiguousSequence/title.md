## 源码路径

/src/main/java/org/pure/algorithm/contiguousSequence/Main.java

## 题目地址(连续数列)

https://leetcode-cn.com/problems/contiguous-sequence-lcci

## 题目描述

```
给定一个整数数组，找出总和最大的连续数列，并返回总和。

示例:

输入： [-2,1,-3,4,-1,2,1,-5,4]
输出： 6
解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。

进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
```

## 代码

- 语言：Java

```
class Solution {

    public int maxSubArray(int[] nums) {
        // 定义最大总和，初始最大总和为int类型的最小值
        int max = -2147483648;

        // 定义总和
        int sum = 0;

        // 遍历数组nums
        for (int num : nums) {
            // 累加计算当前总和
            sum += num;

            if (sum > max) {
                // 如果当前总和大于最大总和，最大总和更新为当前总和
                max = sum;
            }

            if (sum < 0) {
                // 如果当前总和已经小于0，重置当前总和为0，因为如果当前总和小于0，假如后面的连续数列得到最大总和，因为前面连续数列是负数，如果加上前面连续数列，肯定是变小的，所以最大总和的连续数列肯定是从前面连续数列为负数的下一个元素开始的连续数列，那么这里就应该把总和重置为0，因为后面的总和计算从下一个元素开始了
                sum = 0;
            }
        }

        // 返回最大总和
        return max;
    }

}
```