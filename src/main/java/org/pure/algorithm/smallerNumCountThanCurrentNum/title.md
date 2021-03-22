## 源码路径

/src/main/java/org/pure/algorithm/smallerNumCountThanCurrentNum/Main.java

## 题目地址(有多少小于当前数字的数字)

https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number

## 题目描述

```
给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。

换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。

以数组形式返回答案。

示例1:

输入：nums = [8,1,2,2,3]
输出：[4,0,1,1,3]
解释： 
对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。 
对于 nums[1]=1 不存在比它小的数字。
对于 nums[2]=2 存在一个比它小的数字：（1）。 
对于 nums[3]=2 存在一个比它小的数字：（1）。 
对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。

示例2:

输入：nums = [6,5,4,8]
输出：[2,1,0,3]

示例3:

输入：nums = [7,7,7,7]
输出：[0,0,0,0]

提示:

2 <= nums.length <= 500
0 <= nums[i] <= 100
```

## 代码

- 语言：Java

```
class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 定义结果数组results
        int[] results = new int[nums.length];

        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            // 定义满足条件的数目
            int count = 0;

            // 二次遍历数组nums
            for (int j = 0; j < nums.length; ++j) {
                // 如果位置不同而且比当前元素小，那么满足条件
                if (j != i && nums[j] < nums[i]) {
                    ++count;
                }
            }

            // 把数目写进数组
            results[i] = count;
        }

        return results;
    }

}
```