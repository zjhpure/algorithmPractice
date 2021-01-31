## 源码路径

/src/main/java/org/pure/algorithm/searchInsertPosition/Main.java

## 题目地址(搜索插入位置)

https://leetcode-cn.com/problems/search-insert-position

## 题目描述

```
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例1:

输入: [1,3,5,6], 5
输出: 2

示例2:

输入: [1,3,5,6], 2
输出: 1

示例3:

输入: [1,3,5,6], 7
输出: 4

示例4:

输入: [1,3,5,6], 0
输出: 0
```

## 代码

- 语言：Java

```
class Solution {

    public int searchInsert(int[] nums, int target) {
        // 遍历排序数组nums
        for (int i = 0; i < nums.length; ++i) {
            if (target == nums[i]) {
                // 等于数组元素
                return i;
            } else if (target < nums[i]) {
                // 小于数组元素
                if (i == 0 || target > nums[i - 1]) {
                    // 若是第1个数组元素，或者大于前1个数组元素
                    return i;
                }
            }
        }

        // 若遍历排序数组nums后无法返回结果，则证明target比数组中任何一个数大，那么返回数组最大索引加1
        return nums.length;
    }

}
```