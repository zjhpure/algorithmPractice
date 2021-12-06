package org.pure.algorithm.truncateSentence;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 12/6/21 12:58 PM
 * @description 截断句子
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        String result = truncateSentence(s, k);
        System.out.println(result);
    }

    private static String truncateSentence(String s, int k) {
        // 模拟法

        // 以空格切割单词为字符串数组
        String[] strs = s.split(" ");

        // 定义字符串集合，保存结果
        StringBuilder sb = new StringBuilder();

        // 从0遍历到k-1，取前k个单词
        for (int i = 0; i < k; ++i) {
            sb.append(strs[i]);

            // 处理最后一个单词，最后一个单词没有空格
            if (i < k - 1) {
                sb.append(" ");
            }
        }

        // 字符串集合转为字符串，返回结果
        return sb.toString();
    }

}
