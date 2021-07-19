## 源码路径

/src/main/java/org/pure/algorithm/validBoomerang/Main.java

## 题目地址(有效的回旋镖)

https://leetcode-cn.com/problems/valid-boomerang

## 题目描述

```
回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。

给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。

示例1:

输入：[[1,1],[2,3],[3,2]]
输出：true

示例2:

输入：[[1,1],[2,2],[3,3]]
输出：false

提示:
points.length == 3
points[i].length == 2
0 <= points[i][j] <= 100
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isBoomerang(int[][] points) {
        // 判断斜率
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }

}
```