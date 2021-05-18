## 源码路径

/src/main/java/org/pure/algorithm/arrayPartition/Main.java

## 题目地址(数组拆分I)

https://leetcode-cn.com/problems/array-partition-i

## 题目描述

```
给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。

返回该 最大总和 。

示例1:

输入：nums = [1,4,3,2]
输出：4
解释：所有可能的分法（忽略元素顺序）为：
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
所以最大总和为 4

示例2:

输入：nums = [6,2,6,5,1,2]
输出：9
解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9

提示:

1 <= n <= 10^4
nums.length == 2 * n
-10^4 <= nums[i] <= 10^4
```

## 代码

- 语言：Java

```
class Solution {

    public int arrayPairSum(int[] nums) {
        // 排序数组nums
        Arrays.sort(nums);

        // 定义总和
        int sum = 0;

        // 遍历排序后的数组nums，隔一个遍历，0-2-4...，最优分对是数组从小到大排序，按顺序每两个作为一对
        for (int i = 0; i < nums.length; i += 2) {
            // 每次取两个中的第一个元素，也就是每次取每对的最小值
            sum += nums[i];
        }

        // 返回总和
        return sum;
    }

}
```