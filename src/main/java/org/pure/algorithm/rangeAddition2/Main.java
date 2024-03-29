package org.pure.algorithm.rangeAddition2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-07 18:49
 * @description 范围求和II
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
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
        int[][] ops = new int[lists.size()][];
        for (int i = 0; i < lists.size(); ++i) {
            List<String> list = lists.get(i);
            int[] ints = new int[list.size()];
            for (int j = 0; j < list.size(); ++j) {
                ints[j] = Integer.parseInt(list.get(j));
            }
            ops[i] = ints;
        }

        // 获取输出结果
        int result = maxCount(Integer.parseInt(str1), Integer.parseInt(str2), ops);
        System.out.println(result);
    }

    private static int maxCount(int m, int n, int[][] ops) {
        // 待理解原理

        // 定义最小x
        int minX = m;
        // 定义最小y
        int minY = n;

        // 遍历二维数组
        for (int[] op : ops) {
            // 每次拿x和一维数组的第一个元素比较大小，取最小值
            minX = Math.min(minX, op[0]);
            // 每次拿y和一维数组的第二个元素比较大小，取最小值
            minY = Math.min(minY, op[1]);
        }

        // x乘以y等于矩阵中含有最大整数的元素个数
        return minX * minY;
    }

}
