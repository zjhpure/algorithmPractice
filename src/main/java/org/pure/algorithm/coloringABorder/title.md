## 源码路径

/src/main/java/org/pure/algorithm/coloringABorder/Main.java

## 题目地址(边界着色)

https://leetcode-cn.com/problems/coloring-a-border

## 题目描述

```
给你一个大小为m x n的整数矩阵grid，表示一个网格。另给你三个整数row、col和color。网格中的每个值表示该位置处的网格块的颜色。

两个网格块属于同一连通分量需满足下述全部条件：

两个网格块颜色相同
在上、下、左、右任意一个方向上相邻
连通分量的边界是指连通分量中满足下述条件之一的所有网格块：

在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
在网格的边界上(第一行/列或最后一行/列)
请你使用指定颜色color为所有包含网格块grid[row][col]的连通分量的边界进行着色，并返回最终的网格grid。

示例1：

输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
输出：[[3,3],[3,2]]

示例2：

输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
输出：[[1,3,3],[2,3,3]]

示例3：

输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
输出：[[2,2,2],[2,1,2],[2,2,2]]

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 50
1 <= grid[i][j], color <= 1000
0 <= row < m
0 <= col < n
```

## 代码

- 语言：Java

```
class Solution {

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        // 深度优先搜索，待理解原理，题目意思很难读懂，待理解题意

        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        List<int[]> borders = new ArrayList<>();

        int originalColor = grid[r0][c0];

        visited[r0][c0] = true;

        dfs(grid, r0, c0, visited, borders, originalColor);

        for (int[] border : borders) {
            int x = border[0], y = border[1];
            grid[x][y] = color;
        }

        return grid;
    }

    // 深度优先搜索
    private void dfs(int[][] grid, int x, int y, boolean[][] visited, List<int[]> borders, int originalColor) {
        int m = grid.length, n = grid[0].length;

        boolean isBorder = false;

        int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < 4; ++i) {
            int nx = direc[i][0] + x, ny = direc[i][1] + y;

            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == originalColor)) {
                isBorder = true;
            } else if (!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(grid, nx, ny, visited, borders, originalColor);
            }                
        }
        
        if (isBorder) {
            borders.add(new int[]{x, y});
        }
    }

}
```