## 源码路径

/src/main/java/org/pure/algorithm/shuffleTheArray/Main.java

## 题目地址(重新排列数组)

https://leetcode-cn.com/problems/shuffle-the-array

## 题目描述

```
给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。

请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。

示例1:

输入：nums = [2,5,1,3,4,7], n = 3
输出：[2,3,5,4,1,7] 
解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]

示例2:

输入：nums = [1,2,3,4,4,3,2,1], n = 4
输出：[1,4,2,3,3,2,4,1]

示例3:

输入：nums = [1,1,2,2], n = 2
输出：[1,2,1,2]

提示:

1 <= n <= 500
nums.length == 2n
1 <= nums[i] <= 10^3
```

## 代码

- 语言：Java

```
class Solution {

    public int[] shuffle(int[] nums, int n) {
        // 定义结果数组
        int[] results = new int[nums.length];

        // 遍历2n个元素的数组
        for (int i = 0; i < nums.length; ++i) {
            if (i < n) {
                // 数组前一半
                // 示例1前一半：0 1 2 对应0 2 4，所以是2倍
                results[i * 2] = nums[i];
            } else {
                // 数组后一半
                // 示例1后一半：3 4 5 对应1 3 5，所以先减去3等于前一半的值，再用前一半的推论乘以2，再加1
                results[(i - n) * 2 + 1] = nums[i];
            }
        }

        return results;
    }

}
```