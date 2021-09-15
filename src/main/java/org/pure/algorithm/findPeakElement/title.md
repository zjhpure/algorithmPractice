## 源码路径

/src/main/java/org/pure/algorithm/findPeakElement/Main.java

## 题目地址(寻找峰值)

https://leetcode-cn.com/problems/find-peak-element

## 题目描述

```
峰值元素是指其值严格大于左右相邻值的元素。

给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设nums[-1] = nums[n] = -∞ 。

你必须实现时间复杂度为O(logn)的算法来解决此问题。

示例1:

输入：nums = [1,2,3,1]
输出：2
解释：3是峰值元素，你的函数应该返回其索引2。

示例2:

输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5 
解释：你的函数可以返回索引1，其峰值元素为2；
     或者返回索引5，其峰值元素为6。

提示:

1 <= nums.length <= 1000
-2^31 <= nums[i] <= 2^31 - 1
对于所有有效的i都有nums[i] != nums[i + 1]
```

## 代码

- 语言：Java

```
class Solution {

    // 方法1，枚举法，寻找最大值的下标
    public int findPeakElement(int[] nums) {
        // 寻找数组最大值的下标，因为nums[i] != nums[i + 1]，所以数组最大值的下标是一个可行的峰值的下标

        // 定义数组最大值的下标
        int maxIndex = 0;

        // 从数组的第二个元素开始遍历到最后一个元素，寻找数组最大值的下标
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                maxIndex = i;
            }
        }

        // 返回数组最大值的下标
        return maxIndex;
    }

}
```