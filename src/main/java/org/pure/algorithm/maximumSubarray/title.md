## 源码路径

/src/main/java/org/pure/algorithm/maximumSubarray/Main.java

## 题目地址(最大子序和)

https://leetcode-cn.com/problems/maximum-subarray

## 题目描述

```
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例1:

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

示例2:

输入：nums = [1]
输出：1

示例3:

输入：nums = [0]
输出：0

示例4:

输入：nums = [-1]
输出：-1

示例5:

输入：nums = [-100000]
输出：-100000

提示：

1 <= nums.length <= 3 * 10^4
-10^5 <= nums[i] <= 10^5
```

## 代码

- 语言：Java

```
class Solution {

    public int maxSubArray(int[] nums) {
        // 定义初始最大和，用数组nums的第一个元素作为初始最大和
        int res = nums[0];

        // 定义计算过程的最大和
        int sum = 0;

        // 遍历数组nums
        // 逐个元素叠加出sum值，当sum小于等于0时，重置sum为当前元素，因为前面部分的和为0，计算总和时等于0加当前元素，即为当前元素
        for (int num : nums) {
            if (sum > 0) {
                // 若sum大于0，继续叠加
                sum += num;
            } else {
                // 若sum小于等于0，重置sum为当前元素
                sum = num;
            }
            
            if (sum > res) {
                // 更新最大和
                res = sum;
            }
        }

        return res;
    }

}
```