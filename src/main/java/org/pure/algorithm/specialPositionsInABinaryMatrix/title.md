## 源码路径

/src/main/java/org/pure/algorithm/specialPositionsInABinaryMatrix/Main.java

## 题目地址(二进制矩阵中的特殊位置)

https://leetcode-cn.com/problems/special-positions-in-a-binary-matrix

## 题目描述

```
给你一个大小为rows x cols的矩阵mat，其中mat[i][j]是0或1，请返回矩阵mat中特殊位置的数目。

特殊位置定义：如果mat[i][j] == 1并且第i行和第j列中的所有其他元素均为0(行和列的下标均从0开始)，则位置(i, j)被称为特殊位置。

示例1:

输入：mat = [[1,0,0],
            [0,0,1],
            [1,0,0]]
输出：1
解释：(1,2)是一个特殊位置，因为mat[1][2] == 1且所处的行和列上所有其他元素都是0

示例2:

输入：mat = [[1,0,0],
            [0,1,0],
            [0,0,1]]
输出：3
解释：(0,0), (1,1)和(2,2)都是特殊位置

示例3:

输入：mat = [[0,0,0,1],
            [1,0,0,0],
            [0,1,1,0],
            [0,0,0,0]]
输出：2

示例4:

输入：mat = [[0,0,0,0,0],
            [1,0,0,0,0],
            [0,1,0,0,0],
            [0,0,1,0,0],
            [0,0,0,1,1]]
输出：3

提示:

rows == mat.length
cols == mat[i].length
1 <= rows, cols <= 100
mat[i][j]是0或1
```

## 代码

- 语言：Java

```
class Solution {

    public int numSpecial(int[][] mat) {
        // 两次矩阵遍历，时间复杂度O(nm)，第一次矩阵遍历，找出每个位置的行元素总和、列元素总和；第二次矩阵遍历，找出值为1的位置，判断这个位置是否行元素总和、列元素总和都为1，因为特殊位置规定这个元素对应的行和列的其他元素都为0并且自身为1，所以他们的行元素总和为1，列元素总和也为1

        // 定义每个位置的行元素总和
        int[] rows = new int[mat.length];
        // 定义每个位置的列元素总和
        int[] cols = new int[mat[0].length];

        // 第一次矩阵遍历
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                // 计算这个位置的行元素总和
                rows[i] += mat[i][j];
                // 计算这个位置的列元素总和
                cols[j] += mat[i][j];
            }
        }

        // 定义矩阵中特殊位置的数目
        int count = 0;

        // 第二次矩阵遍历
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    // 若这个位置的值为1，并且这个位置的行元素总和为1，列元素总和也为1，那么这个位置就是特殊位置，矩阵中的特殊位置的数目加1
                    ++count;
                }
            }
        }

        // 返回矩阵中特殊位置的数目
        return count;
    }

}
```