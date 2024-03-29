## 源码路径

/src/main/java/org/pure/algorithm/rangeAddition2/Main.java

## 题目地址(范围求和II)

https://leetcode-cn.com/problems/range-addition-ii

## 题目描述

```
给定一个初始元素全部为0，大小为m*n的矩阵M以及在M上的一系列更新操作。

操作用二维数组表示，其中的每个操作用一个含有两个正整数a和b的数组表示，含义是将所有符合0 <= i < a以及0 <= j < b的元素M[i][j]的值都增加1。

在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。

示例1：

输入: 
m = 3, n = 3
operations = [[2,2],[3,3]]
输出: 4
解释: 
初始状态, M = 
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

执行完操作[2,2]后, M = 
[[1, 1, 0],
 [1, 1, 0],
 [0, 0, 0]]

执行完操作[3,3]后, M = 
[[2, 2, 1],
 [2, 2, 1],
 [1, 1, 1]]

M中最大的整数是2, 而且M中有4个值为2的元素。因此返回4。

提示：

m和n的范围是[1,40000]。
a的范围是[1,m]，b的范围是[1,n]。
操作数目不超过10000。
```

## 代码

- 语言：Java

```
class Solution {

    public int maxCount(int m, int n, int[][] ops) {
        // 定义最小x
        int minX = m;
        // 定义最小y
        int minY = n;

        // 遍历二维数组
        for (int[] op : ops) {
            // 每次拿x和一维数组的第一个元素比较大小，取最小值
            minX = Math.min(minX, op[0]);
            // 每次拿y和一维数组的第二个元素比较大小，取最小值
            minY = Math.min(minY, op[1]);
        }

        // x乘以y等于矩阵中含有最大整数的元素个数
        return minX * minY;
    }

}
```