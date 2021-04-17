## 源码路径

/src/main/java/org/pure/algorithm/binarySearch/Main.java

## 题目地址(二分查找)

https://leetcode-cn.com/problems/binary-search

## 题目描述

```
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

示例1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4

示例2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1

提示:

1.你可以假设 nums 中的所有元素是不重复的。
2.n 将在 [1, 10000]之间。
3.nums 的每个元素都将在 [-9999, 9999]之间。
```

## 代码

- 语言：Java

```
class Solution {

    public int search(int[] nums, int target) {
        // // 直接遍历查找，效率很低，不建议使用
        // for (int i = 0; i < nums.length; ++i) {
        //     if (target == nums[i]) {
        //         return i;
        //     }
        // }

        // 定义中间指针，左指针
        int center, left = 0;
        // 定义右指针
        int right = nums.length - 1;

        // 二分查找法，对于已经排好序的数组，用二分查找效率高
        while (left <= right) {
            // 获取数组的中间索引
            center = (left + right) / 2;

            if (target == nums[center]) {
                // 若目标值等于数组的元素，那么就是找到了目标值，返回下标即可
                return center;
            } else if (target < nums[center]) {
                // 若目标值小于数组的元素，那么目标值落在数组的前半部分，把右指针更新为中间指针减1
                right = center - 1;
            } else {
                // 若目标值大于数组的元素，那么目标值落在数组的后半部分，把左指针更新为中间指针加1
                left = center + 1;
            }
        }

        // 若没有找到目标值，返回-1
        return -1;
    }

}
```