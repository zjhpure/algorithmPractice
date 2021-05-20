package org.pure.algorithm.flippingAnImage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-20 19:40
 * @description 翻转图像
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
        int[][] result = flipAndInvertImage(grid);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] flipAndInvertImage(int[][] image) {
        // 定义二维数组results
        int[][] results = new int[image.length][];

        // 遍历矩阵A的每行
        for (int i = 0; i < image.length; ++i) {
            // 定义下标
            int n = 0;

            // 定义一维数组result
            int[] result = new int[image[i].length];

            // 遍历矩阵A每行的每列，从尾遍历到头，进行水平翻转
            for (int j = image[i].length - 1; j >= 0; --j) {
                // 赋值给一维数组result
                result[n] = image[i][j];
                // 下标加1
                ++n;
            }

            // 遍历一维数组result，进行反转
            for (int j = 0; j < result.length; ++j) {
                // 0替换成1，1替换成0
                result[j] = result[j] == 1 ? 0 : 1;
            }

            // 二维数组results的一行处理好
            results[i] = result;
        }

        return results;
    }

}
