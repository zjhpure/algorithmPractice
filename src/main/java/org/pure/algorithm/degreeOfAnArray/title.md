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
        // 定义集合map，保存数组nums每种元素的数量、头下标、尾下标，通过一个长度为3的数组保存元素的数量、头下标、尾下标
        Map<Integer, int[]> map = new HashMap<>();

        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];

            if (map.containsKey(num)) {
                // 若集合map存在元素，更新元素的数量、尾下标
                int[] info = map.get(num);
                // 元素的数量加1
                info[0] += 1;
                // 元素的尾下标更新为当前下标
                info[2] = i;
                // 更新元素的信息到集合map中
                map.put(num, info);
            } else {
                // 若集合map不存在元素，保存元素的信息到集合map中，元素的数量为1，头下标为当前下标，尾下标也为当前下标
                map.put(num, new int[]{1, i, i});
            }
        }

        // 定义元素的最大数量，初始为0
        int maxCount = 0;
        // 定义元素的最短连续子数组的长度，初始为0
        int minLength = 0;

        // 遍历集合map
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            // 获取元素的信息
            int[] info = entry.getValue();

            // 获取当前元素的连续子数组的长度
            int length = info[2] - info[1] + 1;

            if (info[0] > maxCount) {
                // 若当前元素的数量大于元素的最大数量，那么更新元素的最大数量
                maxCount = info[0];
                // 更新最短连续子数组的长度
                minLength = length;
            } else if (info[0] == maxCount) {
                // 若当前元素的数量等于元素的最大数量，判断更新最短连续子数组的长度
                if (length < minLength) {
                    // 若当前元素的连续子数组的长度小于最短连续子数组的长度，那么更新最短连续子数组的长度
                    minLength = length;
                } 
            }
        }

        // 返回元素的最短连续子数组的长度
        return minLength;
    }

}
```