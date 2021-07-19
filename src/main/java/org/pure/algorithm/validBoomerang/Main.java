package org.pure.algorithm.validBoomerang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-19 19:18
 * @description 有效的回旋镖
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
        int[][] points = new int[lists.size()][];
        for (int i = 0; i < lists.size(); ++i) {
            List<String> list = lists.get(i);
            int[] ints = new int[list.size()];
            for (int j = 0; j < list.size(); ++j) {
                ints[j] = Integer.parseInt(list.get(j));
            }
            points[i] = ints;
        }

        // 获取输出结果
        boolean result = isBoomerang(points);
        System.out.println(result);
    }

//    private static boolean isBoomerang(int[][] points) {
//        // 获取点p1
//        int[] p1 = points[0];
//        // 获取点p2
//        int[] p2 = points[1];
//        // 获取点p3
//        int[] p3 = points[2];
//
//        // p1和p2之间的距离的平方，根据公式，a点和b点的距离 = (a^2 + b^2)的开根号
//        double p12 = Math.pow((p1[0] - p2[0]), 2) + Math.pow((p1[1] - p2[1]), 2);
//
//        // p1和p3之间的距离的平方
//        double p13 = Math.pow((p1[0] - p3[0]), 2) + Math.pow((p1[1] - p3[1]), 2);
//
//        // p2和p3之间的距离的平方
//        double p23 = Math.pow((p2[0] - p3[0]), 2) + Math.pow((p2[1] - p3[1]), 2);
//
//        // 若三个点能构成三角形，那么这些点各不相同且不在一条直线上，即有效的回旋镖
//        // 判断三角形用勾股定理：a^2 + b^2 = c^2
//        return p12 + p13 == p23 || p12 + p23 == p13 || p13 + p23 == p12;
//    }

    private static boolean isBoomerang(int[][] points) {
        // 判断斜率
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }

}
