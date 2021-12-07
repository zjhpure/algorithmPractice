package org.pure.algorithm.coloringABorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 12/7/21 11:06 PM
 * @description 边界着色
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String items = scanner.nextLine();
        String r0 = scanner.nextLine();
        String c0 = scanner.nextLine();
        String color = scanner.nextLine();
        scanner.close();

        // 处理输入结果，切割字符串，遍历字符串数组，构造字符串列表
        String[] strings = items.split("\\[\\[")[1].split("]]")[0].split("],\\[");
        List<List<String>> lists = new ArrayList<>();
        for (String string : strings) {
            String[] strs = string.split(",");
            List<String> list = new ArrayList<>(Arrays.asList(strs));
            lists.add(list);
        }

        // 处理输入结果，通过字符串列表构造二维整数数组
        int[][] grid = new int[lists.size()][];
        for (int i = 0; i < lists.size(); ++i) {
            List<String> list = lists.get(i);
            int[] ints = new int[list.size()];
            for (int j = 0; j < list.size(); ++j) {
                ints[j] = Integer.parseInt(list.get(j));
            }
            grid[i] = ints;
        }

        // 获取输出结果
        int[][] result = colorBorder(grid, Integer.parseInt(r0), Integer.parseInt(c0), Integer.parseInt(color));
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
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
    private static void dfs(int[][] grid, int x, int y, boolean[][] visited, List<int[]> borders, int originalColor) {
        int m = grid.length, n = grid[0].length;

        boolean isBorder = false;

        int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < 4; ++i) {
            int nx = direc[i][0] + x, ny = direc[i][1] + y;

            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == originalColor)) {
                isBorder = true;
            } else if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(grid, nx, ny, visited, borders, originalColor);
            }
        }

        if (isBorder) {
            borders.add(new int[]{x, y});
        }
    }

}
