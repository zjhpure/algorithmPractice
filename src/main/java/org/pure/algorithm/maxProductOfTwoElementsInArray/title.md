## 源码路径

/src/main/java/org/pure/algorithm/maxProductOfTwoElementsInArray/Main.java

## 题目地址(数组中两元素的最大乘积)

https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array

## 题目描述

```
给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。

请你计算并返回该式的最大值。

示例1:

输入：nums = [3,4,5,2]
输出：12 
解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。 

示例2:

输入：nums = [1,5,4,5]
输出：16
解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。

示例3:

输入：nums = [3,7]
输出：12

提示：

2 <= nums.length <= 500
1 <= nums[i] <= 10^3
```

## 代码

- 语言：Java

```
class Solution {

    public int maxProduct(int[] nums) {
        // 定义乘积最大值
        int max = 0;

        // 第一轮遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            // 第二轮遍历数组nums
            for (int j = 0; j < nums.length; ++j) {
                // 取不同的元素
                if (i != j) {
                    // 计算两者减1的乘积
                    int product = (nums[i] - 1) * (nums[j] - 1);

                    // 和乘积最大值比较，更新乘积最大值
                    if (product > max) {
                        max = product;
                    }
                }
            }
        }

        return max;
    }

}
```