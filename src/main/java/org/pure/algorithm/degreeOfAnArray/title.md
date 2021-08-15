## 源码路径

/src/main/java/org/pure/algorithm/degreeOfAnArray/Main.java

## 题目地址(数组的度)

https://leetcode-cn.com/problems/degree-of-an-array

## 题目描述

```
给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是在nums中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。

示例1:

输入：[1, 2, 2, 3, 1]
输出：2
解释：
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2。

示例2:

输入：[1,2,2,3,1,4,2]
输出：6

提示:

nums.length在1到50000区间范围内。
nums[i]是一个在0到49999范围内的整数。
```

## 代码

- 语言：Java

```
class Solution {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];

            if (map.containsKey(num)) {
                int[] info = map.get(num);
                info[0] += 1;
                info[2] = i;
                map.put(num, info);
            } else {
                map.put(num, new int[]{1, i, i});
            }
        }

        int maxCount = 0;
        int minLength = 0;

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] info = entry.getValue();

            if (info[0] > maxCount) {
                maxCount = info[0];
                minLength = info[2] - info[1] + 1;
            } else if (info[0] == maxCount) {
                if (info[2] - info[1] + 1 < minLength) {
                    minLength = info[2] - info[1] + 1;
                } 
            }
        }

        return minLength;
    }

}
```