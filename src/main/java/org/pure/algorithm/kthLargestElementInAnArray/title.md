## 源码路径

/src/main/java/org/pure/algorithm/kthLargestElementInAnArray/Main.java

## 题目地址(数组中的第K个最大元素)

https://leetcode-cn.com/problems/kth-largest-element-in-an-array

## 题目描述

```
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

说明：

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
```

## 代码

- 语言：Java

```
class Solution {

    public int findKthLargest(int[] nums, int k) {
        // 对数组排序，用系统提供的sort方法排序
        Arrays.sort(nums);
        // 取倒数第k个数，因为前面排序后是从小到大的，这里通过数组长度-k得到第k个数的索引
        return nums[nums.length - k];
    }

}
```