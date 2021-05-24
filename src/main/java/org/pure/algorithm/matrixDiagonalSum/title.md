## 源码路径

/src/main/java/org/pure/algorithm/matrixDiagonalSum/Main.java

## 题目地址(矩阵对角线元素的和)

https://leetcode-cn.com/problems/matrix-diagonal-sum

## 题目描述

```
给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。

请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。

示例1:

输入：mat = [[1,2,3],
            [4,5,6],
            [7,8,9]]
输出：25
解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
请注意，元素 mat[1][1] = 5 只会被计算一次。

示例2:

输入：mat = [[1,1,1,1],
            [1,1,1,1],
            [1,1,1,1],
            [1,1,1,1]]
输出：8

示例3:

输入：mat = [[5]]
输出：5

提示：

n == mat.length == mat[i].length
1 <= n <= 100
1 <= mat[i][j] <= 100
```

## 代码

- 语言：Java

```
class Solution {

    public int diagonalSum(int[][] mat) {
        // 定义总和
        int sum = 0;

        // 定义正方形矩阵长度
        int length = mat.length;

        // 遍历正方形矩阵的行
        for (int i = 0; i < length; ++i) {
            if (i == 0 || i == length - 1) {
                // 首行和末行，取首列和末列
                if (length > 1) {
                    // 若长度大于1，首列和末列不是同一列
                    sum += mat[i][0];
                    sum += mat[i][length - 1];
                } else {
                    // 若长度小于等于1，首列和末列是同一列
                    sum += mat[i][0];
                }
            } else {
                // 非首行和末行，取和行相同下标的列，以及以列长度中间数作为分隔，此列对面的列
                if (length % 2 != 0 && length / 2 == i) {
                    // 若是中间行，这种列只有一个，行长度为奇数的才有中间行
                    sum += mat[i][length / 2];
                } else {
                    // 若不是中间行，这种列有两个，两列刚好对称
                    sum += mat[i][i];
                    sum += mat[i][length - 1 - i];
                }
            }
        }

        return sum;
    }

}
```