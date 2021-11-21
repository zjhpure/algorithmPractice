package org.pure.algorithm.trappingRainWater2;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-11-21 18:10
 * @description 接雨水II
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String items = scanner.nextLine();
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
        int[][] matrix = new int[lists.size()][];
        for (int i = 0; i < lists.size(); ++i) {
            List<String> list = lists.get(i);
            int[] ints = new int[list.size()];
            for (int j = 0; j < list.size(); ++j) {
                ints[j] = Integer.parseInt(list.get(j));
            }
            matrix[i] = ints;
        }

        // 获取输出结果
        int result = trapRainWater(matrix);
        System.out.println(result);
    }

    private static int trapRainWater(int[][] heightMap) {
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
