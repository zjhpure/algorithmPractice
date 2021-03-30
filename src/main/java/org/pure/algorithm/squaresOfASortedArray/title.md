## 源码路径

/src/main/java/org/pure/algorithm/squaresOfASortedArray/Main.java

## 题目地址(有序数组的平方)

https://leetcode-cn.com/problems/squares-of-a-sorted-array

## 题目描述

```
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

示例1:

输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]

示例2:

输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]

提示：

1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums 已按 非递减顺序 排序

进阶：

请你设计时间复杂度为 O(n) 的算法解决本问题
```

## 代码

- 语言：Java

```
class Solution {

    public int[] sortedSquares(int[] nums) {
        // 获取数组nums长度
        int n = nums.length;

        // 定义结果数组results
        int[] results = new int[n];

        // 用双指针遍历数组nums，从数组nums两边往里遍历，每次结果数组results只取大的数，结果数组results从后往前填满，直到两个指针游标相等
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                // 若前指针i的位置的元素的平方大于后指针j的位置的元素的平方，那么前指针i移动
                results[pos] = nums[i] * nums[i];
                ++i;
            } else {
                // 若前指针i的位置的元素的平方小于等于后指针j的位置的元素的平方，那么后指针j移动
                results[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }

        return results;
    }

}
```