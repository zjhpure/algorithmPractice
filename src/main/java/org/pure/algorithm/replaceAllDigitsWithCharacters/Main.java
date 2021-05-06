package org.pure.algorithm.replaceAllDigitsWithCharacters;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-06 08:12
 * @description 将所有数字用字符替换
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = replaceDigits(str);
        System.out.println(result);
    }

    private static String replaceDigits(String s) {
        // 定义字符数组，保存替换后的字符
        char[] values = new char[s.length()];

        // 遍历字符串s
        for (int i = 0; i < s.length(); ++i) {
            if (i % 2 == 1) {
                // 奇数下标是数字，通过shift函数把前一个下标的字符转成其后面的第n个字符，再添加到字符数组
                values[i] = shift(s.charAt(i - 1), s.charAt(i) - 48);
            } else {
                // 偶数下标是小写英文字母，直接添加到字符数组
                values[i] = s.charAt(i);
            }
        }

        // 定义字符集合
        StringBuilder sb = new StringBuilder();

        // 遍历字符数组
        for (char value : values) {
            // 把字符添加字符集合
            sb.append(value);
        }

        // 字符转为字符串
        return sb.toString();
    }

    // 把字符转成其后面的第n个字符
    private static char shift(char c, int n) {
        return (char) (c + n);
    }

}
