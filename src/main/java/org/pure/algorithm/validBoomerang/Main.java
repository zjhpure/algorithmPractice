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

    private static boolean isBoomerang(int[][] points) {
        // 通过判断斜率来判断三点是否在同一直线
        // 假设为点a，点b，点c，分别为a(x1, y1), b(x2, y2), c(x3,y3)，a点和b点之间的距离为m1，a点和c点之间的距离为m2
        // a点和b点之间的斜率k1 = (y2 - y1) / (x2 - x1)
        // a点和c点之间的斜率k2 = (y3 - y1) / (x3 - x1)
        // 如果点a、b、c在同一直线上，那么他们的斜率相等，即k1 = k2
        // 即：(y2 - y1) / (x2 - x1) = (y3 - y1) / (x3 - x1)
        // 即：(y2 - y1) * (x3 - x1) = (x2 - x1) * (y3 - y1)
        // 所以只要判断以上等式是否成立即可，如果以上等式成立，那么点a、b、c在同一直线上，不是有效的回旋镖，返回false，如果以上等式不成立，那么点a、b、c不在同一直线上，是有效的回旋镖，返回true
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[1][0] - points[0][0]) * (points[2][1] - points[0][1]);
    }

}
