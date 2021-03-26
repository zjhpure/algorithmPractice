package org.pure.algorithm.numOfSegmentsInString;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-26 22:57
 * @description 字符串中的单词数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = countSegments(str);
        System.out.println(result);
    }

    private static int countSegments(String s) {
        // 定义单词数
        int count = 0;

        // 定义单词标志
        boolean isWord = false;

        // 遍历字符串s的每个字符
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ' ') {
                // 若不是空格字符，就是单词字符
                if (!isWord) {
                    // 若前面没有判断出是单词字符，那么单词数加1
                    ++count;
                    // 单词标志设置为是
                    isWord = true;
                }
            } else {
                // 若是空格字符，单词标志设置为否
                isWord = false;
            }
        }

        return count;
    }

}
