package org.pure.algorithm.matrixDiagonalSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-23 13:25
 * @description 矩阵对角线元素的和
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
        int result = diagonalSum(grid);
        System.out.println(result);
    }

    private static int diagonalSum(int[][] mat) {
        // 定义总和
        int sum = 0;

        // 定义正方形矩阵长度
        int length = mat.length;

        // 遍历正方形矩阵的行
        for (int i = 0; i < length; ++i) {
            if (i == 0 || i == length - 1) {
                // 首行和末行，取首列和末列
                if (length > 1) {
                    // 若长度大于1，首列和末列不是同一列
                    sum += mat[i][0];
                    sum += mat[i][length - 1];
                } else {
                    // 若长度小于等于1，首列和末列是同一列
                    sum += mat[i][0];
                }
            } else {
                // 非首行和末行，取和行相同下标的列，以及以列长度中间数作为分隔，此列对面的列
                if (length % 2 != 0 && length / 2 == i) {
                    // 若是中间行，这种列只有一个，行长度为奇数的才有中间行
                    sum += mat[i][length / 2];
                } else {
                    // 若不是中间行，这种列有两个，两列刚好对称
                    sum += mat[i][i];
                    sum += mat[i][length - 1 - i];
                }
            }
        }

        return sum;
    }

}
