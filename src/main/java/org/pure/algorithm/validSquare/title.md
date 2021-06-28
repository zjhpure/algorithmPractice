## 源码路径

/src/main/java/org/pure/algorithm/validSquare/Main.java

## 题目地址(有效的正方形)

https://leetcode-cn.com/problems/valid-square

## 题目描述

```
给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。

一个点的坐标（x，y）由一个有两个整数的整数数组表示。

示例1:

输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
输出: True

注意:
所有输入整数都在 [-10000，10000] 范围内。
一个有效的正方形有四个等长的正长和四个等角（90度角）。
输入点没有顺序。
```

## 代码

- 语言：Java

```
class Solution {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 这里只计算距离的平方即可，不用开根号多此一举

        // p1和p2之间的距离的平方，根据公式，a点和b点的距离 = (a^2 + b^2)的开根号
        double p12 = Math.pow((p1[0] - p2[0]), 2) + Math.pow((p1[1] - p2[1]), 2);

        // p1和p3之间的距离的平方
        double p13 = Math.pow((p1[0] - p3[0]), 2) + Math.pow((p1[1] - p3[1]), 2);

        // p1和p4之间的距离的平方
        double p14 = Math.pow((p1[0] - p4[0]), 2) + Math.pow((p1[1] - p4[1]), 2);

        // p2和p3之间的距离的平方
        double p23 = Math.pow((p2[0] - p3[0]), 2) + Math.pow((p2[1] - p3[1]), 2);

        // p2和p4之间的距离的平方
        double p24 = Math.pow((p2[0] - p4[0]), 2) + Math.pow((p2[1] - p4[1]), 2);

        // p3和p4之间的距离的平方
        double p34 = Math.pow((p3[0] - p4[0]), 2) + Math.pow((p3[1] - p4[1]), 2);

        // 把6个距离的平方保存成数组
        double[] distances = {p12, p13, p14, p23, p24, p34};

        // 定义列表list，保存距离的平方
        List<Double> list = new ArrayList<>();

        // 遍历距离的平方数组
        for (double distance : distances) {
            if (distance == 0) {
                // 如果距离的平方有出现0的，那么这两个点重合，肯定不能构成正方形，返回false
                return false;
            }

            if (!list.contains(distance)) {
                // 如果列表list中没有包含此距离的平方，添加到列表list中
                list.add(distance);
            }
        }

        // 最后，如果列表list中的长度只有2，那么距离的平方只有两种，只有正方形才会出现距离的平方只有两种
        return list.size() == 2;
    }

}
```