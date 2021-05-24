package org.pure.algorithm.reverseWordsInAString3;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-24 20:29
 * @description 反转字符串中的单词III
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        String result = reverseWords(str);
        System.out.println(result);
    }

    private static String reverseWords(String s) {
        // 定义字符串集合sb
        StringBuilder sb = new StringBuilder();

        // 以空格为分隔符切割字符串s，获取字符串数组
        String[] strs = s.split(" ");

        // 遍历字符串数组
        for (int i = 0; i < strs.length; ++i) {
            // 获取字符串
            String str = strs[i];

            // 遍历字符串的字符，从尾部到头部
            for (int j = str.length() - 1; j >= 0; --j) {
                sb.append(str.charAt(j));
            }

            // 判断是否为最后一个字符串，若是最后一个字符串，则不用添加空格，否则要添加空格
            if (i < strs.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
