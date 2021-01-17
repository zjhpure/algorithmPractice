## 源码路径

/src/main/java/org/pure/algorithm/twoSum/Main.java

## 题目地址(两数之和)

https://leetcode-cn.com/problems/two-sum

## 题目描述

```
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案。

示例1:

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

示例2:

输入：nums = [3,2,4], target = 6
输出：[1,2]

示例3:

输入：nums = [3,3], target = 6
输出：[0,1]

提示：

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案
```

## 代码

- 语言：Java

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