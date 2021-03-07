## 源码路径

/src/main/java/org/pure/algorithm/runningSumArray/Main.java

## 题目地址(一维数组的动态和)

https://leetcode-cn.com/problems/running-sum-of-1d-array

## 题目描述

```
给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

请返回 nums 的动态和。

示例1:

输入：nums = [1,2,3,4]
输出：[1,3,6,10]
解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。

示例2:

输入：nums = [1,1,1,1,1]
输出：[1,2,3,4,5]
解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。

示例3:

输入：nums = [3,1,2,10,1]
输出：[3,4,6,16,17]

提示:

1 <= nums.length <= 1000
-10^6 <= nums[i] <= 10^6
```

## 代码

- 语言：Java

```
class Solution {

    public int[] runningSum(int[] nums) {
        // 定义总和
        int sum = 0;

        // 定义结果数组
        int[] results = new int[nums.length];

        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            // 逐个叠加
            sum += nums[i];
            // 叠加结果放入结果数组中
            results[i] = sum;
        }
        
        return results;
    }

}
```