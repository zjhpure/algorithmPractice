## 源码路径

/src/main/java/org/pure/algorithm/sumOfAllOddLengthSubarrays/Main.java

## 题目地址(所有奇数长度子数组的和)

https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays

## 题目描述

```
给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。

子数组 定义为原数组中的一个连续子序列。

请你返回 arr 中 所有奇数长度子数组的和 。

示例1:

输入：arr = [1,4,2,5,3]
输出：58
解释：所有奇数长度子数组和它们的和为：
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

示例2:

输入：arr = [1,2]
输出：3
解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。

示例3:

输入：arr = [1,2]
输出：3
解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。

提示:

1 <= arr.length <= 100
1 <= arr[i] <= 1000
```

## 代码

- 语言：Java

```
class Solution {

    public int sumOddLengthSubarrays(int[] arr) {
        // 总和
        int sum = 0;

        // 数组arr长度
        int size = arr.length;
        
        // 遍历数组arr，计算出每个元素在各种组合中出现的次数，每次累加元素*次数
        // 对于每个元素，如果元素左边是偶数个元素，右边也是偶数个元素，那么加上元素本身就能组成奇数长度数组(注意包括0)
        // 对于每个元素，如果元素左边是奇数个元素，右边也是奇数个元素，那么加上元素本身就能组成奇数长度数组(注意包括0)
        for (int i = 0; i < size; ++i) {
            // 左边元素个数
            int left = i;

            // 左边元素奇数个数
            int leftOdd = (left + 1) / 2;

            // 左边元素偶数个数
            int leftEven = left / 2 + 1;

            // 右边元素个数
            int right = size - i - 1;

            // 右边元素奇数个数
            int rightOdd = (right + 1) / 2;

            // 右边元素偶数个数
            int rightEven = right / 2 + 1;

            // 元素在组合中出现的次数=左边元素奇数个数*右边元素奇数个数+左边元素偶数个数*右边元素偶数个数
            int time = leftOdd * rightOdd + leftEven * rightEven;

            // 累加
            sum += arr[i] * time;
        }

        return sum;
    }

}
```