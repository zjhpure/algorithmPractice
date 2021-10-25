package org.pure.algorithm.searchA2dMatrix2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-25 16:41
 * @description 搜索二维矩阵II
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
        boolean result = searchMatrix(matrix, target);
        System.out.println(result);
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        // 二分查找法

        // 遍历所有行，找出符合条件的行
        for (int[] row : matrix) {
            if (row[0] == target) {
                // 若此行的第一列等于目标值，那么找到了
                return true;
            } else if (row[0] < target) {
                // 若此行的第一列小于目标值，那么此行可能存在目标值，对此行的每列进行二分查找

                // 定义左指针，初始为最左侧
                int left = 1;
                // 定义右指针，初始为最右侧
                int right = row.length - 1;

                // 开始二分查找
                while (left <= right) {
                    // 计算中间指针
                    int mid = (left + right) / 2;

                    if (row[mid] == target) {
                        // 若此行此列等于目标值，那么找到了
                        return true;
                    } else if (row[mid] < target) {
                        // 若此行此列小于目标值，那么往右边区域继续寻找，即左指针等于中间指针加1
                        left = mid + 1;
                    } else {
                        // 若此行此列大于目标值，那么往左边区域继续寻找，即右指针等于中间指针减1
                        right = mid - 1;
                    }
                }
            }
        }

        // 若查找结束还没有找到，返回false
        return false;
    }

}
