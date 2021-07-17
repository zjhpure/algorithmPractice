package org.pure.algorithm.twoDimensionalArrayFindNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-17 16:08
 * @description 二维数组中的查找
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String items = scanner.nextLine();
        int target = scanner.nextInt();
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
        boolean result = findNumberIn2DArray(matrix, target);
        System.out.println(result);
    }

    // 方法1，暴力算法，不推荐
//    private static boolean findNumberIn2DArray(int[][] matrix, int target) {
//        // 暴力算法，直接两层遍历查找
//        for (int[] nums : matrix) {
//            for (int num : nums) {
//                if (target == num) {
//                    // 若找到target，返回true
//                    return true;
//                }
//            }
//        }
//
//        // 若两层遍历完也找不到target，返回false
//        return false;
//    }

    // 方法2，线性查找法，推荐
    private static boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 线性查找法，利用行递增和列递增的特点，不断缩小范围

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            // 先把二维数组为空的情况排除掉
            return false;
        }

        // 定义行标，初始值为0
        int row = 0;
        // 定义列标，初始值为二维数组matrix的列长度减1
        int col = matrix[0].length - 1;

        // 循环，行标扩大直到二维数组matrix的行长度减1，列标缩小直到0
        while (row < matrix.length && col >= 0) {
            // 获取当前行标和列标下的二维数组matrix的元素
            int num = matrix[row][col];
            if (target == num) {
                // 若目标值target等于当前元素，那么二维数组matrix中含有目标值target，返回true
                return true;
            } else if (target > num) {
                // 若目标值target大于当前元素，行标加1
                ++row;
            } else {
                // 若目标值target小于当前元素，列标减1
                --col;
            }
        }

        // 若能循环结束，那么在二维数组matrix中没有找到目标值target，返回false
        return false;
    }

}
