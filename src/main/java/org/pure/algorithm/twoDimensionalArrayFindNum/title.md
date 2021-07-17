## 源码路径

/src/main/java/org/pure/algorithm/twoDimensionalArrayFindNum/Main.java

## 题目地址(二维数组中的查找)

https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof

## 题目描述

```
输入一个字符串，打印出该字符串中字符的所有排列。
在一个n * m的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例:

现有矩阵matrix如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

给定target = 5，返回true。

给定target = 20，返回false。

限制:

0 <= n <= 1000

0 <= m <= 1000
```

## 代码

- 语言：Java

```
class Solution {

    /**
     * 方法1，暴力算法，不推荐
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 暴力算法，直接两层遍历查找
        for (int[] nums : matrix) {
            for (int num : nums) {
                if (target == num) {
                    // 若找到target，返回true
                    return true;
                }
            }
        }

        // 若两层遍历完也找不到target，返回false
        return false;
    }

}
```

```
class Solution {

    /**
     * 方法2，线性查找法，推荐
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 线性查找法，利用行递增和列递增的特点，不断缩小范围

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            // 先把二维数组为空的情况排除掉
            return false;
        }

        // 定义行标，初始值为0
        int row = 0;
        // 定义列标，初始值为二维数组matrix的列长度减1
        int col = matrix[0].length - 1;

        // 循环，行标扩大直到二维数组matrix的行长度减1，列标缩小直到0
        while (row < matrix.length && col >= 0) {
            // 获取当前行标和列标下的二维数组matrix的元素
            int num = matrix[row][col];
            if (target == num) {
                // 若目标值target等于当前元素，那么二维数组matrix中含有目标值target，返回true
                return true;
            } else if (target > num) {
                // 若目标值target大于当前元素，行标加1
                ++row;
            } else {
                // 若目标值target小于当前元素，列标减1
                --col;
            }
        }

        // 若能循环结束，那么在二维数组matrix中没有找到目标值target，返回false
        return false;
    }

}
```