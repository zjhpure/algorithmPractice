package org.pure.algorithm.theKWeakestRowsInAMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-08-25 00:46
 * @description 矩阵中战斗力最弱的K行
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String items = scanner.nextLine();
        int k = scanner.nextInt();
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
        int[] result = kWeakestRows(mat, k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] kWeakestRows(int[][] mat, int k) {
        // 思路：统计每行的军人数目，使用改造后的冒泡排序进行排序，取排序后的前k个

        // 定义列表list，用数组int[]保存每个元素，数组int[]第一个元素保存行标，第二个元素保存这行的军人数目
        List<int[]> list = new ArrayList<>();

        // 遍历矩阵mat的行
        for (int i = 0; i < mat.length; ++i) {
            // 获取矩阵mat的行
            int[] row = mat[i];

            // 定义军人数目，初始为0
            int count = 0;

            // 遍历每行的列
            for (int col : row) {
                if (1 == col) {
                    // 若元素是1，那么就是军人，军人数目加1
                    ++count;
                }
            }

            // 保存每行的军人数目到列表list，用数组表示，数组的第一个元素保存行标，第二个元素保存这行的军人数目
            list.add(new int[]{i, count});
        }

        // 改造冒泡排序，平时冒泡排序用来对数组int[]进行排序，但这里用来对列表list进行排序，并且列表元素是数组，，平均时间复杂度O(n^2)，最好时间复杂度O(n)，最坏时间复杂度O(n^2)，空间复杂度O(1)

        // 需要进行排序的趟数刚好为列表list的长度减1，每一趟排序找出当前的最大数，挪到对应的位置
        for (int i = 0; i < list.size() - 1; ++i) {
            // 判断列表list是否已经有序
            boolean isFlag = true;

            // 每一趟排序时，不断比较当前元素和下一个元素谁大，把大的元素往后挪
            // 因为列表list的元素是数组int[]，数组的第二个元素保存的是军人数目，所以这里进行比较的元素是数组的第二个元素
            for (int j = 0; j < list.size() - 1 - i; ++j) {
                // 获取当前行标的军人数目
                int before = list.get(j)[1];
                // 获取下一行标的军人数目
                int next = list.get(j + 1)[1];

                if (before > next) {
                    // 若当前军人数目大于下一军人数目，交换两者对应的列表list的元素
                    int[] temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    // 出现交换，那么列表list还不是有序
                    isFlag = false;
                }
            }

            if (isFlag) {
                // 若列表list已经有序，结束循环
                break;
            }
        }

        // 定义结果数组nums，用来保存排序后的前k行军人数目
        int[] nums = new int[k];

        // 从0循环到k-1，构造结果数组nums
        for (int i = 0; i < k; ++i) {
            // 直接把排序后的列表list的行标赋值给结果数组nums
            nums[i] = list.get(i)[0];
        }

        // 返回结果数组nums
        return nums;
    }

}
