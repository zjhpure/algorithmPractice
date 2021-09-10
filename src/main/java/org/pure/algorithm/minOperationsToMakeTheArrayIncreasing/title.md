## 源码路径

/src/main/java/org/pure/algorithm/minOperationsToMakeTheArrayIncreasing/Main.java

## 题目地址(最少操作使数组递增)

https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-increasing

## 题目描述

```
给你一个整数数组nums(下标从0开始)。每一次操作中，你可以选择数组中一个元素，并将它增加1。

比方说，如果nums = [1,2,3]，你可以选择增加nums[1]得到nums = [1,3,3]。
请你返回使nums严格递增的最少操作次数。

我们称数组nums是严格递增的，当它满足对于所有的0 <= i < nums.length - 1都有nums[i] < nums[i+1]。一个长度为1的数组是严格递增的一种特殊情况。

示例1:

输入：nums = [1,1,1]
输出：3
解释：你可以进行如下操作：
1) 增加nums[2]，数组变为[1,1,2]。
2) 增加nums[1]，数组变为[1,2,2]。
3) 增加nums[2]，数组变为[1,2,3]。

示例2:

输入：nums = [1,5,2,4,1]
输出：14

示例3:

输入：nums = [8]
输出：0

提示：

1 <= nums.length <= 5000
1 <= nums[i] <= 10^4
```

## 代码

- 语言：Java

```
class Solution {

    public int minOperations(int[] nums) {
        // 定义最少操作次数
        int minCount = 0;

        // 从数组的第一个元素开始遍历，到数组的最后一个元素
        for (int i = 1; i < nums.length; ++i) {
            // 若当前元素小于等于前一个元素，开始进行操作，使得当前元素大于前一个元素
            if (nums[i] - nums[i - 1] <= 0) {
                // 获取这次要操作的次数，因为一次只能加1，所以差值加1就是这次要操作的次数
                int time = nums[i - 1] - nums[i] + 1;

                // 最少操作次数累加这次要操作的次数
                minCount += time;

                // 当前元素更新为被操作后的数字
                nums[i] += time;
            }
        }

        // 返回最少操作次数
        return minCount;
    }

}
```