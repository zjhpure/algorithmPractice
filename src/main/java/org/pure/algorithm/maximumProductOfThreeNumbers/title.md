## 源码路径

/src/main/java/org/pure/algorithm/maximumProductOfThreeNumbers/Main.java

## 题目地址(三个数的最大乘积)

https://leetcode-cn.com/problems/maximum-product-of-three-numbers

## 题目描述

```
给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例1:

输入：nums = [1,2,3]
输出：6

示例2:

输入：nums = [1,2,3,4]
输出：24

示例3:

输入：nums = [-1,-2,-3]
输出：-6

提示：

3 <= nums.length <= 10^4
-1000 <= nums[i] <= 1000
```

## 代码

- 语言：Java

```
class Solution {

    public int maximumProduct(int[] nums) {
        // 对数组nums排序
        Arrays.sort(nums);

        // 取第一最小值
        int min1 = nums[0];
        // 取第二最小值
        int min2 = nums[1];

        // 取第一最大值
        int max1 = nums[nums.length - 1];
        // 取第二最大值
        int max2 = nums[nums.length - 2];
        // 取第三最大值
        int max3 = nums[nums.length - 3];

        // 若全部是正数，最大乘积=第一最大值*第二最大值*第三最大值
        // 若全部是负数，最大乘积=第一最大值*第二最大值*第三最大值
        // 若有正数也有负数，最大乘积是以下两种情况中的一种，取最大值

        // 第一种情况，第一最大值*第二最大值*第三最大值
        int product1 = max1 * max2 * max3;
        // 第二种情况，第一最小值*第二最小值*第一最大值，因为如果数组中有正数也有负数时，两个负数相乘得到正数
        int product2 = min1 * min2 * max1;

        // 取两种情况中的最大值
        return Math.max(product1, product2);
    }

}
```