## 源码路径

/src/main/java/org/pure/algorithm/numOfGoodPairs/Main.java

## 题目地址(好数对的数目)

https://leetcode-cn.com/problems/number-of-good-pairs

## 题目描述

```
给你一个整数数组 nums 。

如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。

返回好数对的数目。

示例1:

输入：nums = [1,2,3,1,1,3]
输出：4
解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始

示例2:

输入：nums = [1,1,1,1]
输出：6
解释：数组中的每组数字都是好数对

示例3:

输入：nums = [1,2,3]
输出：0

提示：

1 <= nums.length <= 100
1 <= nums[i] <= 100
```

## 代码

- 语言：Java

```
class Solution {

    public int numIdenticalPairs(int[] nums) {
        // 定义好数对数目
        int count = 0;

        // 遍历数组nums到倒数第二个元素
        for (int i = 0; i < nums.length - 1; ++i) {
            // 遍历第一轮遍历的结果之后的元素
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] == nums[j]) {
                    // 如果两数相同，那么就是好数对
                    ++count;
                }
            }
        }

        return count;
    }

}
```