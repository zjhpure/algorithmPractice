## 源码路径

/src/main/java/org/pure/algorithm/minimumMovesToEqualArrayElements/Main.java

## 题目地址(最小操作次数使数组元素相等)

https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements

## 题目描述

```
给你一个长度为n的整数数组，每次操作将会使n - 1个元素增加1。返回让数组所有元素相等的最小操作次数。

示例1:

输入：nums = [1,2,3]
输出：3
解释：
只需要3次操作(注意每次操作会增加两个元素的值)：
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

示例2:

输入：nums = [1,1,1]
输出：0

提示：

n == nums.length
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
答案保证符合32-bit整数
```

## 代码

- 语言：Java

```
class Solution {

    public int minMoves(int[] nums) {
        // n-1个数加1等效于1个数减1，即寻找多少次1个数减1，最后数组元素都相等

        // 定义数组中的最小值
        int min = nums[0];

        // 遍历数组，找出数组中的最小值
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        // 定义最小操作次数
        int minCount = 0;

        // 遍历数组
        for (int num : nums) {
            // 每个元素减去最小值就是这个数变成最小值的次数，累计次数
            minCount += num - min;
        }

        // 返回最小操作次数
        return minCount;
    }

}
```