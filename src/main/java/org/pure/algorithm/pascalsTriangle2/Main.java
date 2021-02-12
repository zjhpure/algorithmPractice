package org.pure.algorithm.pascalsTriangle2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-12 21:24
 * @description 杨辉三角II
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int rowIndex = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        List<Integer> list = getRow(rowIndex);
        System.out.println(list);
    }

    private static List<Integer> getRow(int rowIndex) {
        // 动态规划，用上一次的结果计算下一次的结果
        List<Integer> list = new ArrayList<>();

        // 第一列
        list.add(1);

        if (rowIndex == 0) {
            return list;
        }

        // 获取上一次的结果
        List<Integer> listTemp = getRow(rowIndex - 1);

        // 遍历上一次的结果，从第二列到最后一列
        for (int i = 1; i < listTemp.size(); ++i) {
            // 若不是第一列和最后一列，第n行第m列等于上一行第m-1列+第m列
            list.add(listTemp.get(i - 1) + listTemp.get(i));
        }

        // 最后一列
        list.add(1);

        return list;
    }

}
