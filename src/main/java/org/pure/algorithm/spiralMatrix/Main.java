package org.pure.algorithm.spiralMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-21 19:25
 * @description 螺旋矩阵
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
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        // 定义列表list，保存返回的所有元素
        List<Integer> list = new ArrayList<>();

        // 定义上指标，初始为0
        int top = 0;
        // 定义下指标，初始为行数减1
        int bottom = matrix.length - 1;
        // 定义左指标，初始为0
        int left = 0;
        // 定义右指标，初始为列数减1
        int right = matrix[0].length - 1;

        // 循环，顺时针螺旋也就是向右、向下、向左、向右，依次遍历，直到没有元素遍历为止
        while (true) {
            // 向右移动，行不变，列从左到右
            for (int i = left; i <= right; ++i) {
                list.add(matrix[top][i]);
            }

            // 向右移动后，因为接下来要向下移动，所以上指标加1，如果上指标大于下指标，结束循环
            if (++top > bottom) {
                break;
            }

            // 向下移动，列不变，行从上到下
            for (int i = top; i <= bottom; ++i) {
                list.add(matrix[i][right]);
            }

            // 向下移动后，因为接下来要向左移动，所以右指标减1，如果右指标小于左指标，结束循环
            if (--right < left) {
                break;
            }

            // 向左移动，行不变，列从右到左
            for (int i = right; i >= left; --i) {
                list.add(matrix[bottom][i]);
            }

            // 向左移动后，因为接下来要向上移动，所以下指标减1，如果下指标小于上指标，结束循环
            if (--bottom < top) {
                break;
            }

            // 向上移动，列不变，行从下到上
            for (int i = bottom; i >= top; --i) {
                list.add(matrix[i][left]);
            }

            // 向上移动后，因为接下来要向右移动，所以左指标加1，如果左指标大于右指标，结束循环
            if (++left > right) {
                break;
            }
        }

        // 返回列表list
        return list;
    }

}
