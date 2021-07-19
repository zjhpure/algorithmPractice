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
        // 通过判断斜率来判断三点是否是同一直线
        // 假设为点a，点b，点c，分别为a(x1, y1), b(x2, y2), c(x3,y3)，a点和b点之间的距离为m1，a点和c点之间的距离为m2
        // a点和b点之间的斜率k1 = (y2 - y1) / (x2 - x1)
        // a点和c点之间的斜率k2 = (y3 - y1) / (x3 - x1)
        // 如果点a、b、c在同一直线上，那么他们的斜率相等，即k1 = k2
        // 即：(y2 - y1) / (x2 - x1) = (y3 - y1) / (x3 - x1)
        // 即：(y2 - y1) * (x3 - x1) = (x2 - x1) * (y3 - y1)
        // 所以只要判断以上等式是否成立即可，如果以上等式成立，那么点a、b、c在同一直线上，不是有效的回旋镖，返回false，如果以上等式不成立，那么点a、b、c不在同一直线上，是有效的回旋镖，返回true
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[1][0] - points[0][0]) * (points[2][1] - points[0][1]);
    }

}}
```