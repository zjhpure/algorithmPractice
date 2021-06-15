## 源码路径

/src/main/java/org/pure/algorithm/peakIndexInAMountainArray/Main.java

## 题目地址(山脉数组的峰顶索引)

https://leetcode-cn.com/problems/peak-index-in-a-mountain-array

## 题目描述

```
符合下列属性的数组 arr 称为 山脉数组 ：

arr.length >= 3

存在 i（0 < i < arr.length - 1）使得：

arr[0] < arr[1] < ... arr[i-1] < arr[i]

arr[i] > arr[i+1] > ... > arr[arr.length - 1]

给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。

示例1:

输入：arr = [0,1,0]
输出：1

示例2:

输入：arr = [0,2,1,0]
输出：1

示例3:

输入：arr = [0,10,5,2]
输出：1

示例4:

输入：arr = [3,4,5,1]
输出：2

示例5:

输入：arr = [24,69,100,99,79,78,67,36,26,19]
输出：2

提示：

3 <= arr.length <= 10^4
0 <= arr[i] <= 10^6
题目数据保证 arr 是一个山脉数组

进阶：

很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
```

## 代码

- 语言：Java

```
class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        // 本题可归结为查找数组的最大值，因为山脉数组要从小到大再从大到小，峰顶值刚好就是数组的最大值

        // 定义峰顶索引，初始值为0
        int index = 0;
        // 定义峰顶元素，初始值为第一个元素
        int max = arr[0];

        // 遍历山脉数组，查找最大值，保存最大值的索引
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > max) {
                index = i;
                max = arr[i];
            }
        }

        return index;
    }

}
```