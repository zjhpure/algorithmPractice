## 源码路径

/src/main/java/org/pure/algorithm/signOfProductOfArray/Main.java

## 题目地址(数组元素积的符号)

https://leetcode-cn.com/problems/sign-of-the-product-of-an-array

## 题目描述

```
已知函数 signFunc(x) 将会根据 x 的正负返回特定值：

如果 x 是正数，返回 1 。
如果 x 是负数，返回 -1 。
如果 x 是等于 0 ，返回 0 。

给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。

返回 signFunc(product) 。

示例1:

输入：nums = [-1,-2,-3,-4,3,2,1]
输出：1
解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1

示例2:

输入：nums = [1,5,0,2,-3]
输出：0
解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0

示例3:

输入：nums = [-1,1,-1,1,-1]
输出：-1
解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1

提示：

1 <= nums.length <= 1000
-100 <= nums[i] <= 100
```

## 代码

- 语言：Java

```
class Solution {

    public int arraySign(int[] nums) {
        // 定义乘积，只需判断正数或负数或0即可，无需算出乘积
        int product = 1;

        // 遍历数组nums
        for (int num : nums) {
            if (num == 0) {
                // 若有一个元素为0，那么乘积肯定是0，所以直接返回0
                return 0;
            } else if (num > 0) {
                // 若元素为正数，视为1，累乘
                product *= 1;
            } else {
                // 若元素为负数，视为-1，累乘
                product *= -1;
            }
        }

        return product;
    }

}
```