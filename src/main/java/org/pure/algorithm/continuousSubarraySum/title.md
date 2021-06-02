## 源码路径

/src/main/java/org/pure/algorithm/continuousSubarraySum/Main.java

## 题目地址(连续的子数组和)

https://leetcode-cn.com/problems/continuous-subarray-sum

## 题目描述

```
给定一个包含 非负数 的数组和一个目标 整数 k ，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n * k ，其中 n 也是一个整数。

示例1:

输入：[23,2,4,6,7], k = 6
输出：True
解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。

示例2:

输入：[23,2,6,4,7], k = 6
输出：True
解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。

说明:

数组的长度不会超过 10,000 。
你可以认为所有数字总和在 32 位有符号整数范围内。
```

## 代码

- 语言：Java

```
class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        // 定义连续子数组总和
        int sum;

        // 第一轮遍历数组nums的元素，从0到倒数第2个
        for (int i = 0; i < nums.length - 1; ++i) {
            // 初始化连续子数组总和
            sum = nums[i];

            // 第二轮遍历数组nums的元素，从上一轮的下一个到倒数第1个
            for (int j = i + 1; j < nums.length; ++j) {
                // 累加计算连续子数组的总和
                sum += nums[j];
                
                if (sum % k == 0) {
                    // 若连续子数组总和对k求余等于0，那么总和就是k的倍数，那么就是找到了符合条件的连续子数组
                    return true;
                }
            }
        }

        // 若两轮遍历完都没有找到符合条件的连续子数组，那么就是不存在这样的连续子数组
        return false;
    }

}
```