package org.pure.algorithm.strPermutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-22 21:28
 * @description 字符串的排列
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        String[] result = permutation(str);
        System.out.println(Arrays.toString(result));
    }

    private static String[] permutation(String s) {
        // 定义字符串列表
        List<String> list = new ArrayList<>();

        // 定义每条结果列表
        StringBuilder sb = new StringBuilder();

        // 调用排列函数，初始层数0
        arrange(list, sb, s, 0);

        // 定义字符数组
        String[] strs = new String[list.size()];

        // 遍历字符串列表，转为字符数组
        for (int i = 0; i < list.size(); ++i) {
            strs[i] = list.get(i);
        }

        return strs;
    }

    // 此方法暂时是错误的，因为此方法只适用于元素都不重复的排列，这里的元素可能会重复
    // 排列函数，递归，回溯算法
    // 想象成树，遍历字符串s的字符就是以哪个元素开头，用一个列表保存每次排列的结果，找到一次结果后删除最后元素进行回溯，逐步向上回溯
    private static void arrange(List<String> list, StringBuilder sb, String s, int n) {
        if (n == s.length()) {
            // 若层数达到了字符串s的长度，结果列表添加元素，结束函数
            list.add(sb.toString());
            return;
        }

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (sb.indexOf(String.valueOf(c)) > -1) {
                // 重复元素不添加，直接跳过
                continue;
            }

            // 每条结果列表添加元素
            sb.append(c);

            // 递归调用，n增加一层
            arrange(list, sb, s, n + 1);

            // 每条结果列表去掉最后一个元素，进行回溯
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
