package org.pure.algorithm.numOfRectsThatCanFormTheLargestSquare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-07 21:19
 * @description 可以形成最大正方形的矩形数目
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
        int[][] rectangles = new int[lists.size()][];
        for (int i = 0; i < lists.size(); ++i) {
            List<String> list = lists.get(i);
            int[] ints = new int[list.size()];
            for (int j = 0; j < list.size(); ++j) {
                ints[j] = Integer.parseInt(list.get(j));
            }
            rectangles[i] = ints;
        }

        // 获取输出结果
        int result = countGoodRectangles(rectangles);
        System.out.println(result);
    }

    private static int countGoodRectangles(int[][] rectangles) {
        // 定义正方形边长数组
        int[] sides = new int[rectangles.length];

        // 遍历矩形数组rectangles
        for (int i = 0; i < rectangles.length; ++i) {
            // 取矩形中小的边长作为正方形的边长
            sides[i] = Math.min(rectangles[i][0], rectangles[i][1]);
        }

        // 定义最大正方形边长
        int maxLen = 0;

        // 遍历正方形边长数组，找出最大正方形边长
        for (int side : sides) {
            if (side > maxLen) {
                maxLen = side;
            }
        }

        // 定义最大正方形边长的数目
        int count = 0;

        // 遍历正方形边长数组，统计最大正方形边长的数目
        for (int side : sides) {
            if (side == maxLen) {
                ++count;
            }
        }

        return count;
    }

}
