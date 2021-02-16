## 源码路径

/src/main/java/org/pure/algorithm/maximumAverageSubarray/Main.java

## 题目地址(子数组最大平均数I)

https://leetcode-cn.com/problems/maximum-average-subarray-i

## 题目描述

```
给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

示例1:

输入：[1,12,-5,-6,50,3], k = 4
输出：12.75
解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75

提示：

1 <= k <= n <= 30,000。
所给数据范围 [-10,000，10,000]。
```

## 代码

- 语言：Java

```
class Solution {

    // 此方法超出时间限制
    public double findMaxAverage(int[] nums, int k) {
        // 定义最大平均数
        double averageMax = -2147483648d;

        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            if (nums.length - i >= k) {
                // 若数组nums后面的长度大于等于k
                // 定义总和
                double sum = nums[i];

                // 计算连续子数组的总和
                for (int j = i + 1; j < i + k; ++j) {
                    sum += nums[j];
                }

                // 计算平均数
                double average = sum / k;

                if (average > averageMax) {
                    // 比较更新最大平均数
                    averageMax = average;
                }
            }
        }

        return averageMax;
    }

}
```