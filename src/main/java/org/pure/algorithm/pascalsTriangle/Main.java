package org.pure.algorithm.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-12 22:20
 * @description 杨辉三角
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        List<List<Integer>> list = generate(numRows);
        System.out.println(list);
    }

    private static List<List<Integer>> generate(int numRows) {
        // 定义杨辉三角列表
        List<List<Integer>> dataList = new ArrayList<>();

        // 构造杨辉三角，每次构造一行
        for (int i = 0; i < numRows; ++i) {
            // 定义杨辉三角单行列表
            List<Integer> list = new ArrayList<>();

            // 第一列
            list.add(1);

            if (i > 0) {
                // 第一行之后
                // 获取上一行的结果
                List<Integer> listTemp = dataList.get(i - 1);

                // 遍历上一行的结果，从第二列到最后一列
                for (int j = 1; j < listTemp.size(); ++j) {
                    // 若不是第一列和最后一列，第n行第m列等于上一行第m-1列+第m列
                    list.add(listTemp.get(j - 1) + listTemp.get(j));
                }

                // 最后一列
                list.add(1);

                dataList.add(list);
            } else {
                // 第一行
                dataList.add(list);
            }
        }

        return dataList;
    }

}
