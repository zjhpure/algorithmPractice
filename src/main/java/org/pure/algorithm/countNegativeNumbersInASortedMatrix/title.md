## 源码路径

/src/main/java/org/pure/algorithm/countNegativeNumbersInASortedMatrix/Main.java

## 题目地址(统计有序矩阵中的负数)

https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix

## 题目描述

```
给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 

请你统计并返回 grid 中 负数 的数目。

示例1:

输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
输出：8
解释：矩阵中共有 8 个负数。

示例2:

输入：grid = [[3,2],[1,0]]
输出：0

示例3:

输入：grid = [[1,-1],[-1,-1]]
输出：3

示例4:

输入：grid = [[-1]]
输出：1

提示:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100

进阶:

你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？
```

## 代码

- 语言：Java

```
class Solution {

    public int countNegatives(int[][] grid) {
        // 定义负数数目总和
        int total = 0;

        // 遍历矩阵grid
        for (int[] ints : grid) {
            // 遍历矩阵grid每行的每列
            for (int j = 0; j < ints.length; ++j) {
                if (ints[j] < 0) {
                    // 若找到负数，因为每行的元素都是非递增的，所以后面的肯定也是负数，直接计算出后面有几个负数
                    total += ints.length - j;
                    break;
                }
            }
        }

        return total;
    }

}
```