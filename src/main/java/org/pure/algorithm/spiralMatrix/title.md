## 源码路径

/src/main/java/org/pure/algorithm/spiralMatrix/Main.java

## 题目地址(螺旋矩阵)

https://leetcode-cn.com/problems/spiral-matrix

## 题目描述

```
给你一个m行n列的矩阵matrix，请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例1:

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

示例2:

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

提示:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
```

## 代码

- 语言：Java

```
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        // 定义列表list，保存返回的所有元素
        List<Integer> list = new ArrayList<>();

        // 定义上指标，初始为0
        int top = 0;
        // 定义下指标，初始为行数减1
        int bottom = matrix.length - 1;
        // 定义左指标，初始为0
        int left = 0;
        // 定义右指标，初始为列数减1
        int right = matrix[0].length - 1;

        // 循环，顺时针螺旋也就是向右、向下、向左、向上，依次遍历，直到没有元素遍历为止
        while (true) {
            // 向右移动，行不变，列从左到右
            for (int i = left; i <= right; ++i) {
                list.add(matrix[top][i]);
            }

            // 向右移动后，因为接下来要向下移动，所以上指标加1，如果上指标大于下指标，结束循环
            if (++top > bottom) {
                break;
            }

            // 向下移动，列不变，行从上到下
            for (int i = top; i <= bottom; ++i) {
                list.add(matrix[i][right]);
            }

            // 向下移动后，因为接下来要向左移动，所以右指标减1，如果右指标小于左指标，结束循环
            if (--right < left) {
                break;
            } 

            // 向左移动，行不变，列从右到左
            for (int i = right; i >= left; --i) {
                list.add(matrix[bottom][i]);
            }

            // 向左移动后，因为接下来要向上移动，所以下指标减1，如果下指标小于上指标，结束循环
            if (--bottom < top) {
                break;
            } 

            // 向上移动，列不变，行从下到上
            for (int i = bottom; i >= top; --i) {
                list.add(matrix[i][left]);
            }

            // 向上移动后，因为接下来要向右移动，所以左指标加1，如果左指标大于右指标，结束循环
            if (++left > right) {
                break;
            } 
        }

        // 返回列表list
        return list;
    }

}
```