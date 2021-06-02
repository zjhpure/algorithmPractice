## 源码路径

/src/main/java/org/pure/algorithm/findPivotIndex/Main.java

## 题目地址(寻找数组的中心索引)

https://leetcode-cn.com/problems/find-pivot-index

## 题目描述

```
给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。

数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。

如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。

注意：中心索引可能出现在数组的两端。

示例1:

输入：nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
同时, 3 也是第一个符合要求的中心索引。

示例2:

输入：nums = [1, 2, 3]
输出：-1
解释：
数组中不存在满足此条件的中心索引。

示例3:

输入：nums = [2, 1, -1]
输出：0
解释：
索引 0 左侧不存在元素，视作和为 0 ；右侧数之和为 1 + (-1) = 0 ，二者相等。

示例4:

输入：nums = [0, 0, 0, 0, 1]
输出：4
解释：
索引 4 左侧数之和为 0 ；右侧不存在元素，视作和为 0 ，二者相等。

提示:

nums 的长度范围为 [0, 10000]。
任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
```

## 代码

- 语言：Java

```
class Solution {

    public int pivotIndex(int[] nums) {
        if (nums.length <= 1) {
            // 若整数数组nums的长度小于2，则没有中心索引，直接返回-1
            return -1;
        }

        // 中心索引左侧元素相加之和
        int preSum = 0;

        // 中心索引右侧元素相加之和
        int lastSum = 0;

        // 从nums的第2个元素开始遍历，构建初始的lastSum
        for (int i = 1; i < nums.length; ++i) {
            lastSum += nums[i];
        }

        // 遍历整数数组nums，preSum通过累加获取，lastSum通过累减获取
        for (int i = 0; i < nums.length; ++i) {
            if (i - 1 >= 0) {
                // 当索引i大于0时，开始累加获取preSum
                preSum += nums[i - 1];
            }

            if (i + 1 >= 2) {
                // 当索引i大于0时，开始累减获取lastSum
                lastSum -= nums[i];
            }

            if (preSum == lastSum) {
                // 若preSum等于lastSum，则找到了中心索引
                return i;
            }
        }

        // 遍历整数数组nums结束后还没有返回中心索引，则证明没有中心索引，返回-1
        return -1;
    }

}
```