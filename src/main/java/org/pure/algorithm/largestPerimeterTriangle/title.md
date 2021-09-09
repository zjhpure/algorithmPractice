## 源码路径

/src/main/java/org/pure/algorithm/largestPerimeterTriangle/Main.java

## 题目地址(三角形的最大周长)

https://leetcode-cn.com/problems/largest-perimeter-triangle

## 题目描述

```
给定由一些正数(代表长度)组成的数组A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。

如果不能形成任何面积不为零的三角形，返回0。

示例1:

输入：[2,1,2]
输出：5

示例2:

输入：[1,2,1]
输出：0

示例3:

输入：[3,2,3,4]
输出：10

示例4:

输入：[3,6,2,3]
输出：8

提示：

3 <= A.length <= 10000
1 <= A[i] <= 10^6
```

## 代码

- 语言：Java

```
class Solution {

    public int largestPerimeter(int[] nums) {
        // 在一个三角形中，任意两边之和大于第三边，或者任意两边之差小于第三边，通过这个规则来判断是三个数是否可以构成三角形

        // 排序
        Arrays.sort(nums);

        // 遍历排序后的数组，从尾到头，这样能从大的数开始判断，只要符合条件就是最大周长的三角形
        for (int i = nums.length - 1; i >= 2; --i) {
            // 若符合任意两边之和大于第三边，那么构成三角形，因为是从大的数一侧开始判断，所以这里就是最大周长的三角形，而且不会存在三角形的前两边在前面，因为数组已经排序好，这里是在最后去判断是否符合三角形的，往前即使符合也不是最大周长的三角形
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                // 找到构成最大周长的三角形，返回三条边相加的和
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }

        // 如果任意三个数都不能构成三角形，那么返回0
        return 0;
    }

}
```