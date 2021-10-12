## 源码路径

/src/main/java/org/pure/algorithm/maximumProductSubarray/Main.java

## 题目地址(乘积最大子数组)

https://leetcode-cn.com/problems/maximum-product-subarray

## 题目描述

```
给你一个整数数组nums，请你找出数组中乘积最大的连续子数组(该子数组中至少包含一个数字)，并返回该子数组所对应的乘积。

示例1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组[2,3]有最大乘积6。

示例2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为2, 因为[-2,-1]不是子数组。
```

## 代码

- 语言：Java

```
class Solution {

    public int maxProduct(int[] nums) {
        // 暴力枚举法

        // 定义最大子数组的乘积，初始为最小整数，-2^31=-2147483648
        int maxProduct = -2147483648;

        // 遍历数组，从开头到结尾
        for (int i = 0; i < nums.length; ++i) {
            // 定义每次子数组的乘积，初始为当前元素自身
            int product = nums[i];

            // 先和最大子数组的乘积作比较，取其中的最大值，更新到最大子数组的乘积，因为单独一个元素也算子数组
            maxProduct = Math.max(maxProduct, product);

            // 第二层遍历数组，从第一层数组元素的下一个开始到数组结尾
            for (int j = i + 1; j < nums.length; ++j) {
                // 和数组后面紧挨的元素累乘，得到子数组的乘积
                product *= nums[j];
                
                // 再次和最大子数组的乘积作比较，取其中的最大值，更新到最大子数组的乘积
                maxProduct = Math.max(maxProduct, product);
            }
        }

        // 返回最大子数组的乘积
        return maxProduct;
    }

}
```