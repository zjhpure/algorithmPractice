package org.pure.algorithm.specialPositionsInABinaryMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-08-12 16:00
 * @description 二进制矩阵中的特殊位置
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
        int[][] mat = new int[lists.size()][];
        for (int i = 0; i < lists.size(); ++i) {
            List<String> list = lists.get(i);
            int[] ints = new int[list.size()];
            for (int j = 0; j < list.size(); ++j) {
                ints[j] = Integer.parseInt(list.get(j));
            }
            mat[i] = ints;
        }

        // 获取输出结果
        int result = numSpecial(mat);
        System.out.println(result);
    }

    private static int numSpecial(int[][] mat) {
        // 两次矩阵遍历，时间复杂度O(nm)，第一次矩阵遍历，找出每个位置的行元素总和、列元素总和；第二次矩阵遍历，找出值为1的位置，判断这个位置是否行元素总和、列元素总和都为1，因为特殊位置规定这个元素对应的行和列的其他元素都为0并且自身为1，所以他们的行元素总和为1，列元素总和也为1

        // 定义每个位置的行元素总和
        int[] rows = new int[mat.length];
        // 定义每个位置的列元素总和
        int[] cols = new int[mat[0].length];

        // 第一次矩阵遍历
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                // 计算这个位置的行元素总和
                rows[i] += mat[i][j];
                // 计算这个位置的列元素总和
                cols[j] += mat[i][j];
            }
        }

        // 定义矩阵中特殊位置的数目
        int count = 0;

        // 第二次矩阵遍历
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    // 若这个位置的值为1，并且这个位置的行元素总和为1，列元素总和也为1，那么这个位置就是特殊位置，矩阵中的特殊位置的数目加1
                    ++count;
                }
            }
        }

        // 返回矩阵中特殊位置的数目
        return count;
    }

}
