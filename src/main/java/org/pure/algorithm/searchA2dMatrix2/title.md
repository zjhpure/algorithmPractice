## 源码路径

/src/main/java/org/pure/algorithm/searchA2dMatrix2/Main.java

## 题目地址(搜索二维矩阵II)

https://leetcode-cn.com/problems/search-a-2d-matrix-ii

## 题目描述

```
编写一个高效的算法来搜索m x n矩阵matrix中的一个目标值target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。

示例1:

输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
输出：true

示例2:

输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
输出：false

提示：

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-10^9 <= matrix[i][j] <= 10^9
每行的所有元素从左到右升序排列
每列的所有元素从上到下升序排列
-10^9 <= target <= 10^9
```

## 代码

- 语言：Java

```
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 二分查找法
        
        // 遍历所有行，找出符合条件的行
        for (int[] row : matrix) {
            if (row[0] == target) {
                // 若此行的第一列等于目标值，那么找到了
                return true;
            } else if (row[0] < target) {
                // 若此行的第一列小于目标值，那么此行可能存在目标值，对此行的每列进行二分查找

                // 定义左指针，初始为最左侧
                int left = 1;
                // 定义右指针，初始为最右侧
                int right = row.length - 1;

                // 开始二分查找
                while (left <= right) {
                    // 计算中间指针
                    int mid = (left + right) / 2;

                    if (row[mid] == target) {
                        // 若此行此列等于目标值，那么找到了
                        return true;
                    } else if (row[mid] < target) {
                        // 若此行此列小于目标值，那么往右边区域继续寻找，即左指针等于中间指针加1
                        left = mid + 1;
                    } else {
                        // 若此行此列大于目标值，那么往左边区域继续寻找，即右指针等于中间指针减1
                        right = mid - 1;
                    }
                }
            }
        }

        // 若查找结束还没有找到，返回false
        return false;
    }

}
```