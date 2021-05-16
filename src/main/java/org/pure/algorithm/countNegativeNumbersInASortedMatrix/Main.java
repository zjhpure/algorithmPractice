package org.pure.algorithm.countNegativeNumbersInASortedMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-16 15:22
 * @description 统计有序矩阵中的负数
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
        int result = countNegatives(grid);
        System.out.println(result);
    }

    private static int countNegatives(int[][] grid) {
        // 定义负数数目总和
        int total = 0;

        // 遍历矩阵grid
        for (int[] ints : grid) {
            // 遍历矩阵grid每行的每列
            for (int j = 0; j < ints.length; ++j) {
                if (ints[j] < 0) {
                    // 若找到负数，因为每行的元素都是非递增的，所以后面的肯定也是负数，直接计算出后面有几个负数
                    total += ints.length - j;
                    break;
                }
            }
        }

        return total;
    }
}
