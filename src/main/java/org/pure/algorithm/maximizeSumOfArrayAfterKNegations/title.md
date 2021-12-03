## 源码路径

/src/main/java/org/pure/algorithm/maximizeSumOfArrayAfterKNegations/Main.java

## 题目地址(K次取反后最大化的数组和)

https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations

## 题目描述

```
给你一个整数数组nums和一个整数k，按以下方法修改该数组：

选择某个下标i并将nums[i]替换为-nums[i]。
重复这个过程恰好k次。可以多次选择同一个下标i。

以这种方式修改数组后，返回数组可能的最大和。

示例1：

输入：nums = [4,2,3], k = 1
输出：5
解释：选择下标1，nums变为[4,-2,3]。

示例2：

输入：nums = [3,-1,0,2], k = 3
输出：6
解释：选择下标(1, 2, 2)，nums变为[3,1,0,2]。

示例3：

输入：nums = [2,-3,-1,5,-4], k = 2
输出：13
解释：选择下标(1, 4)，nums变为[2,3,-1,5,4]。

提示：

1 <= nums.length <= 10^4
-100 <= nums[i] <= 100
1 <= k <= 10^4
```

## 代码

- 语言：Java

```
class Solution {

    public int largestSumAfterKNegations(int[] nums, int k) {
        // 排序+暴力
        
        // 对数组排序
        Arrays.sort(nums);

        // 定义最大和
        int maxSum = 0;

        // 处理k次取反，每次都是取反当前最小值
        for (int i = 1; i <= k; ++i) {
            // 每次只对当前最小值取反
            nums[0] = nums[0] * -1;
            // 取反后马上对数组再排序
            Arrays.sort(nums);
        }

        // 遍历处理好后的数组，累加得到最大和
        for (int num : nums) {
            maxSum += num;
        }

        // 返回最大和
        return maxSum;
    }

}
```