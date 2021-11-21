## 源码路径

/src/main/java/org/pure/algorithm/trappingRainWater2/Main.java

## 题目地址(接雨水II)

https://leetcode-cn.com/problems/trapping-rain-water-ii

## 题目描述

```
给你一个m x n的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。

示例1：

输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
输出: 4
解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。

示例2：

输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
输出: 10

提示：

m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 * 10^4
```

## 代码

- 语言：Java

```
class Solution {

    public int trapRainWater(int[][] heightMap) {
        // 未解决，题目意思待理解，解体思路也待理解

        // 最小堆法

        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }

        int m = heightMap.length;

        int n = heightMap[0].length;

        boolean[][] visit = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{i * n + j, heightMap[i][j]});
                    visit[i][j] = true;
                }
            }
        }

        int res = 0;

        int[] dirs = {-1, 0, 1, 0, -1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            for (int k = 0; k < 4; ++k) {
                int nx = curr[0] / n + dirs[k];

                int ny = curr[0] % n + dirs[k + 1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) {
                    if (curr[1] > heightMap[nx][ny]) {
                        res += curr[1] - heightMap[nx][ny];
                    }

                    pq.offer(new int[]{nx * n + ny, Math.max(heightMap[nx][ny], curr[1])});

                    visit[nx][ny] = true;
                }
            }
        }

        return res;
    }

}
```