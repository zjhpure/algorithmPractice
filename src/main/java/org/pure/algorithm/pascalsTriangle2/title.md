## 源码路径

/src/main/java/org/pure/algorithm/pascalsTriangle2/Main.java

## 题目地址(杨辉三角II)

https://leetcode-cn.com/problems/pascals-triangle-ii

## 题目描述

![杨辉三角](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

```
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例1:

输入: 3
输出: [1,3,3,1]

进阶:

你可以优化你的算法到 O(k) 空间复杂度吗？
```

## 代码

- 语言：Java

```
class Solution {

    public List<Integer> getRow(int rowIndex) {
        // 动态规划，用上一次的结果计算下一次的结果
        List<Integer> list = new ArrayList<>();

        // 第一列
        list.add(1);

        if (rowIndex == 0) {
            return list;
        }

        // 获取上一次的结果
        List<Integer> listTemp = getRow(rowIndex - 1);

        // 遍历上一次的结果，从第二列到最后一列
        for (int i = 1; i < listTemp.size(); ++i) {
            // 若不是第一列和最后一列，第n行第m列等于上一行第m-1列+第m列
            list.add(listTemp.get(i - 1) + listTemp.get(i));
        }

        // 最后一列
        list.add(1);

        return list;
    }

}
```