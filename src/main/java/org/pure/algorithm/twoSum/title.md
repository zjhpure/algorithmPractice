## 题目源码路径

/src/main/java/org/pure/algorithm/twoSum/Main.java

## 题目地址(两数之和)

https://leetcode-cn.com/problems/two-sum

## 题目描述

```
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

## 前置知识

- 哈希表

## 思路

最容易想到的就是暴力枚举，我们可以利用两层 for 循环来遍历每个元素，并查找满足条件的目标元素。不过这样时间复杂度为 O(N^2)，空间复杂度为 O(1)，时间复杂度较高，我们要想办法进行优化。

这里我们可以增加一个 Map 记录已经遍历过的数字及其对应的索引值。这样当遍历一个新数字的时候就去 Map 里查询 **target 与该数的差值是否已经在前面的数字中出现过**。如果出现过，就找到了答案，就不必再往下继续执行了。

## 关键点

- 求和转换为求差
- 借助 Map 结构将数组中每个元素及其索引相互对应
- 以空间换时间，将查找时间从 O(N) 降低到 O(1)

## 代码

- 语言支持：Java

```
class Solution {

    public int[] twoSum(int[] nums, int target) {
        // 第一遍轮询
        for (int i = 0; i < nums.length; ++i) {
            // 第二遍轮询
            for (int j = 0; j < nums.length; ++j) {
                // 判断两数相加是否等于target
                if (i != j && nums[i] + nums[j] == target) {
                    // 返回两个数组的下标
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
```